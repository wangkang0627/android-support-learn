package learn.com.android_support_learn;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import de.greenrobot.event.EventBus;
import learn.com.android_support_learn.event.BaseEvent;
import learn.com.android_support_learn.event.MainActivityEvent;

/**
 * @ClassName: BaseActivity
 * @Description: 基础activity
 * @Author wk
 * @Date: 2015/7/30 0030
 */
public class BaseActivity extends AppCompatActivity {
    public Toolbar toolbar;
    protected FrameLayout base_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    public <T extends BaseEvent> void onEventMainThread(T event) {
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(getLayoutInflater().inflate(layoutResID,null));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(R.layout.base_layout_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        base_content = (FrameLayout) findViewById(R.id.base_content);
        base_content.addView(view);
    }

    /**
     * @param layoutResID 设置没有actionbar的view
     */
    public void setContentViewNoActionBar(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }
    //设置返回按钮
    protected void setBackAction(String str)
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(str);
    }
    protected void setBackAction(int res_str)
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(res_str);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);

    }
}
