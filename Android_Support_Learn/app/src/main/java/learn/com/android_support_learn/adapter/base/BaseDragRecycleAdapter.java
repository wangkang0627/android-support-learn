package learn.com.android_support_learn.adapter.base;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * @ClassName: BaseDragRecycleAdapter
 * @Description: //支持滑动的Adapter
 * @Author wk
 * @Date 2015/9/5 0005
 */
public abstract class BaseDragRecycleAdapter<T, VH extends BaseRecyclerAdapter.ViewHolder> extends BaseRecyclerAdapter<T, VH> {

    protected ItemTouchHelper mItemTouchHelper;
    protected ItemTouchHelper.Callback mCallback;
    protected RecyclerView mRecyclerView;
    protected boolean mDragUpEnabled = true;
    protected boolean mDragDownEnabled = true;

    public BaseDragRecycleAdapter(Context context, RecyclerView recyclerView) {
        super(context);
        this.mRecyclerView = recyclerView;
        mCallback = createCallback();
        mItemTouchHelper = new ItemTouchHelper(mCallback);
    }

    public int getMovementFlags(RecyclerView recyclerView,
                                RecyclerView.ViewHolder viewHolder) {
        return mCallback.makeMovementFlags(
                (mDragUpEnabled ? ItemTouchHelper.UP : 0) |
                        (mDragDownEnabled ? ItemTouchHelper.DOWN : 0), 0);
    }

    public void move(int from, int to) {
        notifyItemMoved(from, to);
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
                BaseDragRecycleAdapter.this.move(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                //mAdapter.delete(viewHolder.getAdapterPosition());
            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
                //ItemTouchHelperActivity.this.onSelectedChanged(viewHolder, actionState);
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder,
                                    float dX, float dY, int actionState, boolean isCurrentlyActive) {
             /*   if (ItemTouchHelperActivity.this.onChildDraw(c, recyclerView, viewHolder,
                        dX, dY, actionState, isCurrentlyActive)) {
                    return;
                }*/
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState,
                        isCurrentlyActive);
            }

            @Override
            public void onChildDrawOver(Canvas c, RecyclerView recyclerView,
                                        RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState,
                                        boolean isCurrentlyActive) {
           /*     if (ItemTouchHelperActivity.this.onChildDrawOver(c, recyclerView, viewHolder,
                        dX, dY, actionState, isCurrentlyActive)) {
                    return;
                }*/
                super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState,
                        isCurrentlyActive);
            }

            @Override
            public boolean isLongPressDragEnabled() {
                return true;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return false;
            }

            @Override
            public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                //ItemTouchHelperActivity.this.clearView(viewHolder);
            }
        };
    }
}
