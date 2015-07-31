package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import learn.com.android_support_learn.R;

/**
 * @ClassName: RightMainAdapter
 * @Description:
 * @Author wk
 * @Date: 2015/8/1 0001
 */
public class RightMainAdapter extends RecyclerView.Adapter<RightMainAdapter.RightMainViewHolder> {
    private final Context context;

    public RightMainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RightMainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RightMainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_cardview_recycler, null));
    }

    @Override
    public void onBindViewHolder(RightMainViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected class RightMainViewHolder extends RecyclerView.ViewHolder {

        public RightMainViewHolder(View itemView) {
            super(itemView);
        }
    }
}
