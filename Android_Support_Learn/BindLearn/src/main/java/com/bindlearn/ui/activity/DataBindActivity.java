package com.bindlearn.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.bindlearn.BR;
import com.bindlearn.R;
import com.bindlearn.databinding.ActivityDatabindLayoutBinding;
import com.bindlearn.model.UserModel;
import com.core.library.activity.BaseToolBarActivity;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @ClassName: DataBindActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class DataBindActivity extends BaseToolBarActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserModel userModel = new UserModel();
        userModel.card_num="##########0016";
        userModel.name = "测试";
        userModel.date = new Date();
        //这个类是自动生成的，一般都是Activity开头加当前Activity的名字
        ActivityDatabindLayoutBinding databindLayoutBinding = DataBindingUtil.setContentView(this, R.layout.activity_databind_layout);
        //这个方法也是自动生成的，用来设置data标签里面变量的
        databindLayoutBinding.setUser(userModel);
        //上面的databindLayoutBinding.setUser(userModel) 可以替换成这个方法也可以用
       // databindLayoutBinding.setVariable(BR.user,userModel);
        setContentView(databindLayoutBinding.getRoot());
        databindLayoutBinding.executePendingBindings();
    }
}
