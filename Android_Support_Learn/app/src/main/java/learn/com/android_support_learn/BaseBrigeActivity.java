package learn.com.android_support_learn;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);

    }
}
