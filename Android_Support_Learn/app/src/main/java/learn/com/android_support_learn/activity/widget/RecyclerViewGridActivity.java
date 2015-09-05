package learn.com.android_support_learn.activity.widget;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import learn.com.android_support_learn.BaseActivity;
import learn.com.android_support_learn.R;
import learn.com.android_support_learn.adapter.RecyclerViewGridAdapter;
import learn.com.android_support_learn.databinding.ActivityRightRecyclerLayoutBinding;
import learn.com.android_support_learn.model.ImageModel;

/**
 * @ClassName: RecyclerViewGridActivity
 * @Description: RecyclerView的瀑布流用法
 * @Author wk
 * @Date 2015/9/4 0004
 */
public class RecyclerViewGridActivity extends BaseActivity {
    private android.support.v7.widget.RecyclerView recyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRightRecyclerLayoutBinding activityRightRecyclerLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_right_recycler_layout);
        activityRightRecyclerLayoutBinding.setAdapter(new RecyclerViewGridAdapter(this));
        activityRightRecyclerLayoutBinding.executePendingBindings();
        View view = activityRightRecyclerLayoutBinding.getRoot();
        setContentView(view);
        ActionBar actionBar = getSupportActionBar();
        this.recyclerview  = (RecyclerView) view.findViewById(R.id.recycler_view);
        RecyclerViewGridAdapter adapter = (RecyclerViewGridAdapter) this.recyclerview.getAdapter();
        List<ImageModel> data = new ArrayList<>();
        for (int i = 0;i<100;i++)
        {
            ImageModel imageModel = new ImageModel();
            imageModel.img = i+"";
            data.add(imageModel);
        }
        adapter.addData(data);
    }
}
