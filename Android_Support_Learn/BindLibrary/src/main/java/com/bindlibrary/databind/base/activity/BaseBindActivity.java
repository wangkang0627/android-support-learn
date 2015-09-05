package com.bindlibrary.databind.base.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


/**
 * @ClassName: BaseBindActivity
 * @Description: 基础Bind activity
 * @Author wk
 * @Date: 2015/7/30 0030
 */
public abstract class BaseBindActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T viewDataBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewDataBind = DataBindingUtil.setContentView(this, getLayoutResId());
        View view = this.viewDataBind.getRoot();
        setContentView(view);
        initViews();
        viewDataBind.executePendingBindings();
    }

    public void setVarible(int id, Object obj) {
        viewDataBind.setVariable(id, obj);
    }

    /**
     * @return 布局id
     */
    protected abstract int getLayoutResId();

    protected abstract void initViews();
}
