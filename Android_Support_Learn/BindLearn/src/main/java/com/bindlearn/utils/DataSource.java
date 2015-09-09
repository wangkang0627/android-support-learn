package com.bindlearn.utils;

import com.bindlearn.model.ActivityModel;
import com.bindlearn.ui.activity.DataBindActivity;

import java.util.ArrayList;

/**
 * @ClassName: DataSource
 * @Description:
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class DataSource {
    public static ArrayList<ActivityModel> getData() {
        ArrayList<ActivityModel> arrayList = new ArrayList<ActivityModel>();
        ActivityModel activityModel = new ActivityModel();
        activityModel.name = "DataBindActivity,在activity中使用DataBind";
        activityModel.aClass = DataBindActivity.class;
        arrayList.add(activityModel);
        return arrayList;
    }
}
