package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.HashMap;

import learn.com.android_support_learn.R;

/**
 * @ClassName: RightMainAdapter
 * @Description:
 * @Author wk
 * @Date: 2015/8/1 0001
 */
public class RightMainAdapter extends RecyclerView.Adapter<RightMainAdapter.RightMainViewHolder> {
    private final Context context;
    private SparseArray<Integer> animation_index;
    private Animation itemAnmation;

    public RightMainAdapter(Context context) {
        this.context = context;
        this.animation_index = new SparseArray<Integer>();
        this.itemAnmation = AnimationUtils.loadAnimation(this.context, R.anim.listview_item_enter);
    }

    @Override
    public RightMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RightMainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_cardview_recycler, null));
    }

    @Override
    public void onBindViewHolder(RightMainViewHolder holder, int position) {
        if (animation_index.get(position) == null) {
            animation_index.put(position, position);
            holder.itemView.startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.listview_item_enter));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected class RightMainViewHolder extends RecyclerView.ViewHolder {
        public View rootView;

        public RightMainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
