package learn.com.android_support_learn.adapter.base;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * @ClassName: BaseSwipRecycleAdapter
 * @Description: 支持滑动到下一个的adapter
 * @Author wk
 * @Date 2015/9/7 0007
 */
public abstract class BaseSwipRecycleAdapter<T, VH extends BaseRecyclerAdapter.ViewHolder> extends BaseDragRecycleAdapter<T, VH> {

    public BaseSwipRecycleAdapter(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
    }

    @Override
    protected void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

    @Override
    protected boolean onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        return super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
