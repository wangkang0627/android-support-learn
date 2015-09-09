package com.core.library.activity;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.core.library.R;

import java.lang.reflect.Field;

/**
 * @ClassName: BaseToolBarActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class BaseToolBarActivity extends AppCompatActivity {
    public Toolbar toolbar;
    protected FrameLayout base_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        setContentView(getLayoutInflater().inflate(layoutResID, null));
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(R.layout.core_base_layout_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        base_content = (FrameLayout) findViewById(R.id.base_content);
        base_content.addView(view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int statusBarHeight = getStatusBarHeight();
            this.toolbar.setPadding(0, statusBarHeight, 0, 0);
        }
        setSupportActionBar(toolbar);

    }
    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
            Rect frame = new Rect();
            getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
            return frame.top;
        }
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

}
