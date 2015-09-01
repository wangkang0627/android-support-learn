package learn.com.android_support_learn.utils;

import java.util.ArrayList;

import learn.com.android_support_learn.LinearLayoutCompatActivity;
import learn.com.android_support_learn.model.ActivityModel;

/**
 * @ClassName: DataSource
 * @Description:
 * @Author wk
 * @Date 2015/9/1 0001
 */
public class DataSource {
    public static ArrayList<ActivityModel> getData() {
        ArrayList<ActivityModel> arrayList = new ArrayList<ActivityModel>();
        ActivityModel activityModel = new ActivityModel();
        activityModel.name = "LinearLayoutCompat";
        activityModel.aClass = LinearLayoutCompatActivity.class;
        arrayList.add(activityModel);
        return arrayList;
    }
}
