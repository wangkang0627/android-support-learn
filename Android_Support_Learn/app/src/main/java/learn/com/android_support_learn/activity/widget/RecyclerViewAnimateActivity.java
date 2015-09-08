package learn.com.android_support_learn.activity.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import learn.com.android_support_learn.BaseActivity;
import learn.com.android_support_learn.R;
import learn.com.android_support_learn.adapter.RecyclerViewAnimateAdapter;
import learn.com.android_support_learn.adapter.base.BaseRecyclerAdapter;
import learn.com.android_support_learn.model.ArticleModel;

/**
 * @ClassName: RecyclerViewAnimateActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class RecyclerViewAnimateActivity extends BaseActivity {
    private android.support.v7.widget.RecyclerView recyclerview;
    private RecyclerViewAnimateAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {
            ArticleModel articleModel = new ArticleModel();
            articleModel.setDesc("长按删除(new)");
            String conent = "我是插入内容";
            for (int j = 0; j < 5; j++) {
                conent += "---" + conent;
            }
            articleModel.setContent(conent);
            adapter.mDatas.add(2, articleModel);
            adapter.notifyItemInserted(2);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_recycler_layout);
        setBackAction("RecyclerViewAnimateActivity");
        this.recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAnimateAdapter(this);
        recyclerview.setAdapter(adapter);
        RecyclerView.ItemAnimator mCachedAnimator = recyclerview.getItemAnimator();
        mCachedAnimator.setSupportsChangeAnimations(
                true
        );
        List<ArticleModel> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ArticleModel articleModel = new ArticleModel();
            articleModel.setDesc("长按删除");
            String conent = "我是内容";
            for (int j = 0; j < 5; j++) {
                conent += "---" + conent;
            }
            articleModel.setContent(conent);
            data.add(articleModel);
        }
        adapter.addData(data);
        adapter.notifyDataSetChanged();
        adapter.setItemSelectListener(new BaseRecyclerAdapter.ItemSelectListener() {

            @Override
            public void onSelect(RecyclerView.ViewHolder viewHolder, int position) {
                RecyclerViewAnimateAdapter.AnimateViewHolder animateViewHolder = (RecyclerViewAnimateAdapter.AnimateViewHolder) viewHolder;
                animateViewHolder.textView.append(adapter.getItem(position).content);
                adapter.getItem(position).setDesc(animateViewHolder.textView.getText().toString());
                adapter.notifyItemChanged(position);
            }
        });
        adapter.setItemLongSelectListener(new BaseRecyclerAdapter.ItemLongSelectListener() {
            @Override
            public void onSelect(RecyclerView.ViewHolder viewHolder, int position) {
                adapter.mDatas.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });
    }
}
