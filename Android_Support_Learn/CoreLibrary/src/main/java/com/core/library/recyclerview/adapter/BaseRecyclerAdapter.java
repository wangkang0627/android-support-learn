package com.core.library.recyclerview.adapter;

import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BaseRecyclerAdapter
 * @Description:
 * @Author wk
 * @Date 2015/9/1 0001
 */
public abstract class BaseRecyclerAdapter<T, VH extends BaseRecyclerAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {
    public List<T> mDatas = new ArrayList<>();
    protected Context mContext;

    public BaseRecyclerAdapter(Context context) {
        this.mContext = context;
    }

    public void addData(List<T> data) {
        if (data != null) {
            this.mDatas.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void refreshData(List<T> data) {
        if (data != null) {
            this.mDatas.addAll(data);
            notifyDataSetChanged();
        }
    }

    public T getItem(int position) {
        return mDatas.get(position);
    }

    public abstract VH onBaseCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH vh = onBaseCreateViewHolder(parent, viewType);
        ItemClickListener itemClickListener = new ItemClickListener();
        LongItemClickListener longItemClickListener = new LongItemClickListener();
        vh.itemView.setOnLongClickListener(longItemClickListener);
        vh.itemView.setOnClickListener(itemClickListener);
        vh.itemClickListener = itemClickListener;
        vh.longItemClickListener = longItemClickListener;
        return vh;
    }

    public abstract void onBaseBindViewHolder(VH holder, int position);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.itemClickListener.position = position;
        holder.itemClickListener.viewHolder = holder;
        holder.longItemClickListener.position = position;
        holder.longItemClickListener.viewHolder = holder;
        onBaseBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private ItemSelectListener itemSelectListener;
    private ItemLongSelectListener itemLongSelectListener;

    public static interface ItemLongSelectListener {
        public void onSelect(RecyclerView.ViewHolder viewHolder, int position);
    }

    public static interface ItemSelectListener {
        public void onSelect(RecyclerView.ViewHolder viewHolder, int position);
    }

    class LongItemClickListener implements View.OnLongClickListener {
        public int position;
        public ViewHolder viewHolder;

        @Override
        public boolean onLongClick(View view) {
            if (itemLongSelectListener != null)
                itemLongSelectListener.onSelect(viewHolder, position);
            return false;
        }
    }

    class ItemClickListener implements View.OnClickListener {
        public int position;
        public ViewHolder viewHolder;

        @Override
        public void onClick(View v) {
            if (itemSelectListener != null) {
                itemSelectListener.onSelect(viewHolder, position);
            }

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemClickListener itemClickListener;
        public LongItemClickListener longItemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public ItemLongSelectListener getItemLongSelectListener() {
        return itemLongSelectListener;
    }

    public void setItemLongSelectListener(ItemLongSelectListener itemLongSelectListener) {
        this.itemLongSelectListener = itemLongSelectListener;
    }

    public ItemSelectListener getItemSelectListener() {
        return itemSelectListener;
    }

    public void setItemSelectListener(ItemSelectListener itemSelectListener) {
        this.itemSelectListener = itemSelectListener;
    }
}
