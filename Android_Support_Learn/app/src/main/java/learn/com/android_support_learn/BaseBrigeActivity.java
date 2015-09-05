package learn.com.android_support_learn;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.bindlibrary.databind.base.activity.BaseBindActivity;

import de.greenrobot.event.EventBus;
import learn.com.android_support_learn.event.BaseEvent;

/**
 * @ClassName: BaseBrigeActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/5 0005
 */
public abstract class BaseBrigeActivity<T extends ViewDataBinding> extends BaseBindActivity<T> {
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
        setContentView(getLayoutInflater().inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(R.layout.base_layout_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        base_content = (FrameLayout) findViewById(R.id.base_content);
        base_content.addView(view);

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
