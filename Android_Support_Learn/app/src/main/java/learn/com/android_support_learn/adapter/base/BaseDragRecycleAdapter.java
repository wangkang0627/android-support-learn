package learn.com.android_support_learn.adapter.base;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.animation.ValueAnimatorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.animation.TranslateAnimation;

/**
 * @ClassName: BaseDragRecycleAdapter
 * @Description: //支持滑动删除的Adapter
 * @Author wk
 * @Date 2015/9/5 0005
 */
public abstract class BaseDragRecycleAdapter<T, VH extends BaseRecyclerAdapter.ViewHolder> extends BaseRecyclerAdapter<T, VH> {
    public static String TAG;
    protected ItemTouchHelper mItemTouchHelper;
    protected ItemTouchHelper.Callback mCallback;
    protected RecyclerView mRecyclerView;
    protected boolean mDragUpEnabled = true;//上滑动
    protected boolean mDragDownEnabled = true;//下滑动
    protected boolean mSwipLeftEnabled = true;//左滑动
    protected boolean mSwipRightEnabled = true;//右滑动
    protected boolean longPressDragEnabled = false;//是否可以长按进行滑动
    protected boolean itemViewSwipeEnabled = false;//是否支持左右滑动

    public BaseDragRecycleAdapter(Context context, RecyclerView recyclerView) {
        super(context);
        TAG = getClass().getName();
        this.mRecyclerView = recyclerView;
        mCallback = createCallback();
        mItemTouchHelper = new ItemTouchHelper(mCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    //滑动支持
    protected int getMovementFlags(RecyclerView recyclerView,
                                   RecyclerView.ViewHolder viewHolder) {
        int swipeFlag = (mSwipLeftEnabled ? ItemTouchHelper.LEFT : 0) | (mSwipRightEnabled ? ItemTouchHelper.RIGHT : 0);//滑动支持向左和向右
        int dragFlag = (mDragUpEnabled ? ItemTouchHelper.UP : 0) |
                (mDragDownEnabled ? ItemTouchHelper.DOWN : 0);
        return mCallback.makeMovementFlags(dragFlag
                , swipeFlag);
    }

    /**
     * 上下移动的时候调用
     *
     * @param from 点击的position
     * @param to   放入的position
     */
    protected boolean move(int from, int to) {
        T prev = mDatas.remove(from);
        mDatas.add(to > from ? to - 1 : to, prev);
        notifyItemMoved(from, to);
        return true;
    }

    public void delete(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }

    /**
     * @param viewHolder
     * @param direction  方向
     */
    protected void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        if (direction == ItemTouchHelper.RIGHT) {
            Log.d(TAG, "onSwiped:RIGHT");
        } else if (direction == ItemTouchHelper.LEFT) {
            Log.d(TAG, "onSwiped:LEFT");
        }
        delete(viewHolder.getAdapterPosition());//删除
    }

    protected boolean onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        return false;
    }

    protected boolean onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        return false;
    }

    /**
     * 在每次View Holder的状态变成拖拽 (ACTION_STATE_DRAG) 或者 滑动 (ACTION_STATE_SWIPE)的时候被调用。
     *
     * @param viewHolder
     * @param actionState
     */
    private void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {

    }

    public ItemTouchHelper.Callback createCallback() {
        return new ItemTouchHelper.Callback() {

            @Override
            public int getMovementFlags(RecyclerView recyclerView,
                                        RecyclerView.ViewHolder viewHolder) {
                return BaseDragRecycleAdapter.this.getMovementFlags(recyclerView, viewHolder);
            }


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                return BaseDragRecycleAdapter.this.move(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                BaseDragRecycleAdapter.this.onSwiped(viewHolder, direction);
            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                //  super.onSelectedChanged(viewHolder, actionState);
                BaseDragRecycleAdapter.this.onSelectedChanged(viewHolder, actionState);
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder,
                                    float dX, float dY, int actionState, boolean isCurrentlyActive) {

                if (BaseDragRecycleAdapter.this.onChildDraw(c, recyclerView, viewHolder,
                        dX, dY, actionState, isCurrentlyActive)) {
                    return;
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState,
                        isCurrentlyActive);
            }


            /**
             *  Most of the time, you only need to override onChildDraw but due to limitations of platform prior
             *  to Honeycomb, you may need to implement onChildDrawOver as well.
             * @param c
             * @param recyclerView
             * @param viewHolder
             * @param dX
             * @param dY
             * @param actionState
             * @param isCurrentlyActive
             */
            @Override
            public void onChildDrawOver(Canvas c, RecyclerView recyclerView,
                                        RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState,
                                        boolean isCurrentlyActive) {
                if (BaseDragRecycleAdapter.this.onChildDrawOver(c, recyclerView, viewHolder,
                        dX, dY, actionState, isCurrentlyActive)) {
                    return;
                }
                super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState,
                        isCurrentlyActive);
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return longPressDragEnabled;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return itemViewSwipeEnabled;
            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                //ItemTouchHelperActivity.this.clearView(viewHolder);
            }
        };
    }

    public boolean ismDragUpEnabled() {
        return mDragUpEnabled;
    }

    public void setmDragUpEnabled(boolean mDragUpEnabled) {
        this.mDragUpEnabled = mDragUpEnabled;
    }

    public boolean ismDragDownEnabled() {
        return mDragDownEnabled;
    }

    public void setmDragDownEnabled(boolean mDragDownEnabled) {
        this.mDragDownEnabled = mDragDownEnabled;
    }

    public boolean ismSwipLeftEnabled() {
        return mSwipLeftEnabled;
    }

    public void setmSwipLeftEnabled(boolean mSwipLeftEnabled) {
        this.mSwipLeftEnabled = mSwipLeftEnabled;
    }

    public boolean ismSwipRightEnabled() {
        return mSwipRightEnabled;
    }

    public void setmSwipRightEnabled(boolean mSwipRightEnabled) {
        this.mSwipRightEnabled = mSwipRightEnabled;
    }

    public boolean isLongPressDragEnabled() {
        return longPressDragEnabled;
    }

    public void setLongPressDragEnabled(boolean longPressDragEnabled) {
        this.longPressDragEnabled = longPressDragEnabled;
    }

    public boolean isItemViewSwipeEnabled() {
        return itemViewSwipeEnabled;
    }

    public void setItemViewSwipeEnabled(boolean itemViewSwipeEnabled) {
        this.itemViewSwipeEnabled = itemViewSwipeEnabled;
    }
}
