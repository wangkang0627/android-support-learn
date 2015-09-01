package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.internal.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

import java.util.HashMap;

import learn.com.android_support_learn.BR;
import learn.com.android_support_learn.PApplication;
import learn.com.android_support_learn.R;
import learn.com.android_support_learn.model.ActivityModel;

/**
 * @ClassName: RightMainAdapter
 * @Description:
 * @Author wk
 * @Date: 2015/8/1 0001
 */
public class RightMainAdapter extends BaseRecyclerAdapter<ActivityModel, RightMainAdapter.RightMainViewHolder> {
    private final Context context;
    private SparseArray<Integer> animation_index;
    private Animation itemAnmation;

    public RightMainAdapter(Context context) {
        this.context = context;
        this.animation_index = new SparseArray<Integer>();
        this.itemAnmation = AnimationUtils.loadAnimation(this.context, R.anim.listview_item_enter);
    }


    @Override
    public RightMainViewHolder onBaseCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate((LayoutInflater.from(context)), R.layout.main_cardview_recycler, null, false);
        RightMainViewHolder rightMainViewHolder = new RightMainViewHolder(viewDataBinding.getRoot());
        rightMainViewHolder.viewDataBinding = viewDataBinding;
        return rightMainViewHolder;
    }

    @Override
    public void onBaseBindViewHolder(RightMainViewHolder holder, int position) {
        if (animation_index.get(position) == null) {
            animation_index.put(position, position);
            holder.itemView.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.listview_item_enter));
        }
        holder.viewDataBinding.setVariable(BR.activityType, getItem(position));
        holder.viewDataBinding.executePendingBindings();
    }


    protected class RightMainViewHolder extends BaseRecyclerAdapter.ViewHolder {
        public View rootView;
        public ImageView iv_image;
        public ViewDataBinding viewDataBinding;

        public RightMainViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
