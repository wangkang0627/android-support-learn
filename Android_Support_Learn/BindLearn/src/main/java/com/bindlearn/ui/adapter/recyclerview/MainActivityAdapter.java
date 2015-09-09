package com.bindlearn.ui.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bindlearn.R;
import com.bindlearn.model.ActivityModel;
import com.core.library.recyclerview.adapter.BaseRecyclerAdapter;

/**
 * @ClassName: MainActivityAdapter
 * @Description: 主activity的adapter
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class MainActivityAdapter extends BaseRecyclerAdapter<ActivityModel, MainActivityAdapter.MainViewHolder> {
    public MainActivityAdapter(Context context) {
        super(context);
    }

    @Override
    public MainViewHolder onBaseCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_main_r_layout, null));
    }

    @Override
    public void onBaseBindViewHolder(MainViewHolder holder, int position) {
        holder.tv_desc.setText(getItem(position).getName());
    }

    public class MainViewHolder extends BaseRecyclerAdapter.ViewHolder {
        public TextView tv_desc;

        public MainViewHolder(View itemView) {
            super(itemView);
            this.tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
