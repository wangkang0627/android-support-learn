package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import learn.com.android_support_learn.adapter.base.BaseRecyclerAdapter;
import learn.com.android_support_learn.model.ArticleModel;

/**
 * @ClassName: RecyclerViewAnimateAdapter
 * @Description: RecyclerView 动画的adpater
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class RecyclerViewAnimateAdapter extends BaseRecyclerAdapter<ArticleModel, RecyclerViewAnimateAdapter.AnimateViewHolder> {
    public RecyclerViewAnimateAdapter(Context context) {
        super(context);
    }

    @Override
    public AnimateViewHolder onBaseCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimateViewHolder(LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, null));
    }

    @Override
    public void onBaseBindViewHolder(AnimateViewHolder holder, int position) {
        TextView textView = (TextView) holder.itemView;
        textView.setTextColor(Color.BLACK);
        ArticleModel articleModel = getItem(position);
        textView.setText(articleModel.desc);
        textView.append("【查看更多】");
        holder.content = articleModel.content;
    }

    public class AnimateViewHolder extends BaseRecyclerAdapter.ViewHolder {
        public String content;
        public TextView textView;
        public AnimateViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;


        }
    }
}
