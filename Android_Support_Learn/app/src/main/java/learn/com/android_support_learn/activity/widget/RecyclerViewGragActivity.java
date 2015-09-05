package learn.com.android_support_learn.activity.widget;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import learn.com.android_support_learn.BR;
import learn.com.android_support_learn.BaseActivity;
import learn.com.android_support_learn.BaseBrigeActivity;
import learn.com.android_support_learn.R;
import learn.com.android_support_learn.adapter.RecyclerViewGragAdapter;
import learn.com.android_support_learn.adapter.RecyclerViewGridAdapter;
import learn.com.android_support_learn.databinding.ActivityRecyclerDragLayoutBinding;
import learn.com.android_support_learn.databinding.ActivityRightRecyclerLayoutBinding;
import learn.com.android_support_learn.model.ImageModel;

/**
 * @ClassName: RecyclerViewGridActivity
 * @Description: RecyclerView的瀑布流用法
 * @Author wk
 * @Date 2015/9/4 0004
 */
public class RecyclerViewGragActivity extends BaseBrigeActivity<ActivityRecyclerDragLayoutBinding> {
    private RecyclerView recyclerview;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_recycler_drag_layout;
    }

    @Override
    protected void loadBindFinish() {
        super.loadBindFinish();
        setVarible(BR.adapter, new RecyclerViewGragAdapter(this, this.recyclerview));
    }

    @Override
    protected void initViews() {
        setBackAction("RecyclerViewGragActivity");
        this.recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerViewGragAdapter adapter = (RecyclerViewGragAdapter) this.recyclerview.getAdapter();
        //正对item大小变得item进行优化
        this.recyclerview.setHasFixedSize(true);
        List<ImageModel> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ImageModel imageModel = new ImageModel();
            imageModel.img = i + "";
            data.add(imageModel);
        }
        adapter.addData(data);
    }
}
