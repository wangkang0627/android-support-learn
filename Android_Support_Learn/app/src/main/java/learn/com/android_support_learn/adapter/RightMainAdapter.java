package learn.com.android_support_learn.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
       /* Bitmap bitmap  = BitmapFactory.decodeResource(context.getResources(),R.mipmap.img_feed_center_1);
        int w=bitmap.getWidth(),h=bitmap.getHeight();
        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 获得像素的颜色
                int color = pix[w * i + j];
                int red = ((color & 0x00FF0000) >> 16);
                int green = ((color & 0x0000FF00) >> 8);
                int blue = color & 0x000000FF;
                color = (red + green + blue)/3;
                color = alpha | (color << 16) | (color << 8) | color;
                pix[w * i + j] = color;
            }
        }
        Bitmap result=Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        result.setPixels(pix, 0, w, 0, 0,w, h);*/
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected class RightMainViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_image;
        public RightMainViewHolder(View itemView) {
            super(itemView);
            iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
        }
    }
}
