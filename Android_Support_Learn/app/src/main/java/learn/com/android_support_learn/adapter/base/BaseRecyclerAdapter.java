package learn.com.android_support_learn.adapter.base;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @ClassName: BaseRecyclerAdapter
 * @Description:
 * @Author wk
 * @Date 2015/9/1 0001
 */
public abstract class BaseRecyclerAdapter<T, VH extends BaseRecyclerAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {
    public ObservableList<T> mDatas = new ObservableArrayList<T>();
    protected Context mContext;
    public BaseRecyclerAdapter(Context context){
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
        vh.itemView.setOnClickListener(itemClickListener);
        vh.itemClickListener = itemClickListener;
        return vh;
    }

    public abstract void onBaseBindViewHolder(VH holder, int position);

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.itemClickListener.position = position;
        onBaseBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    private ItemSelectListener itemSelectListener;

    public interface ItemSelectListener {
        public void onSelect(int position);
    }

    class ItemClickListener implements View.OnClickListener {
        public int position;

        @Override
        public void onClick(View v) {
            if (itemSelectListener != null) {
                itemSelectListener.onSelect(position);
            }

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public ItemSelectListener getItemSelectListener() {
        return itemSelectListener;
    }

    public void setItemSelectListener(ItemSelectListener itemSelectListener) {
        this.itemSelectListener = itemSelectListener;
    }
}
