package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import learn.com.android_support_learn.BR;
import learn.com.android_support_learn.R;
import learn.com.android_support_learn.model.ImageModel;

/**
 * @ClassName: RecyclerViewGridAdapter
 * @Description:
 * @Author wk
 * @Date 2015/9/4 0004
 */
public class RecyclerViewGridAdapter extends BaseRecyclerAdapter<ImageModel, RecyclerViewGridAdapter.RecyclerViewGridViewHolder> implements View.OnClickListener {

    public RecyclerViewGridAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerViewGridViewHolder onBaseCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate((LayoutInflater.from(mContext)), R.layout.item_recycle_layout, null, false);
        RecyclerViewGridViewHolder rightMainViewHolder = new RecyclerViewGridViewHolder(viewDataBinding.getRoot());
        rightMainViewHolder.viewDataBinding = viewDataBinding;
        return rightMainViewHolder;
    }

    @Override
    public void onBaseBindViewHolder(RecyclerViewGridViewHolder holder, int position) {

        holder.viewDataBinding.setVariable(BR.imageModel, getItem(position));
        holder.viewDataBinding.executePendingBindings();
        int height = (int) ((position % 3 + 1) * 30 + mContext.getResources().getDimension(R.dimen.stage_height));
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.iv_image.getLayoutParams();
        params.height = height;
        holder.iv_image.setLayoutParams(params);
        holder.btn_click.setTag(getItem(position));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_click:
                ImageModel imageModel = (ImageModel) view.getTag();
                imageModel.setPrize(true);
                imageModel.setImg("click");
                break;
        }
    }

    public class RecyclerViewGridViewHolder extends BaseRecyclerAdapter.ViewHolder {
        public ViewDataBinding viewDataBinding;
        public ImageView iv_image;
        public Button btn_click;

        public RecyclerViewGridViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
            btn_click = (Button) itemView.findViewById(R.id.btn_click);
            btn_click.setOnClickListener(RecyclerViewGridAdapter.this);
        }
    }
}
