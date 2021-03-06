package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import learn.com.android_support_learn.R;
import learn.com.android_support_learn.adapter.base.BaseDragRecycleAdapter;
import learn.com.android_support_learn.adapter.base.BaseRecyclerAdapter;
import learn.com.android_support_learn.model.ImageModel;

/**
 * @ClassName: RecyclerViewGragAdapter
 * @Description: 可拖拽的 RecyclerView
 * @Author wk
 * @Date 2015/9/5 0005
 */
public class RecyclerViewGragAdapter extends BaseDragRecycleAdapter<ImageModel, RecyclerViewGragAdapter.ViewHolder> {
    public RecyclerViewGragAdapter(Context context, RecyclerView recyclerView) {
        super(context, recyclerView);
    }

    @Override
    public ViewHolder onBaseCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate((LayoutInflater.from(mContext)), R.layout.item_drag_recycler, null, false);
        final ViewHolder viewHolder = new ViewHolder(viewDataBinding.getRoot());
        viewHolder.viewDataBinding = viewDataBinding;

        return viewHolder;
    }

    @Override
    public void onBaseBindViewHolder(ViewHolder holder, int position) {

    }

    public class ViewHolder extends BaseRecyclerAdapter.ViewHolder {
        Button btn;
        public ViewDataBinding viewDataBinding;

        public ViewHolder(View itemView) {
            super(itemView);
            btn = (Button) itemView.findViewById(R.id.btn_drag);
            btn.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (MotionEventCompat.getActionMasked(motionEvent) == MotionEvent.ACTION_DOWN) {
                        mItemTouchHelper.startDrag(ViewHolder.this);
                    }
                    return false;
                }
            });
        }
    }
}
