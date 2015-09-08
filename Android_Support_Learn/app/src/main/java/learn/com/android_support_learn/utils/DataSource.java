package learn.com.android_support_learn.utils;

import java.util.ArrayList;

import learn.com.android_support_learn.activity.widget.AppCompatButtonActivity;
import learn.com.android_support_learn.activity.widget.DialogCompatActivity;
import learn.com.android_support_learn.activity.layout.LinearLayoutCompatActivity;
import learn.com.android_support_learn.activity.widget.AppCompatSpinnerActivity;
import learn.com.android_support_learn.activity.widget.RecyclerViewAnimateActivity;
import learn.com.android_support_learn.activity.widget.RecyclerViewGragActivity;
import learn.com.android_support_learn.activity.widget.RecyclerViewGridActivity;
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

/*---------------------widget-----------------------------*/
        ActivityModel activityMode2 = new ActivityModel();
        activityMode2.name = "DialogCompat";
        activityMode2.aClass = DialogCompatActivity.class;
        arrayList.add(activityMode2);

        ActivityModel activityMode3 = new ActivityModel();
        activityMode3.name = "AppCompatSpinner";
        activityMode3.aClass = AppCompatSpinnerActivity.class;
        arrayList.add(activityMode3);

        ActivityModel activityMode4 = new ActivityModel();
        activityMode4.name = "AppCompatButton";
        activityMode4.aClass = AppCompatButtonActivity.class;
        arrayList.add(activityMode4);


        ActivityModel activityMode5 = new ActivityModel();
        activityMode5.name = "RecyclerViewGridActivity";
        activityMode5.aClass = RecyclerViewGridActivity.class;
        arrayList.add(activityMode5);


        ActivityModel activityMode6 = new ActivityModel();
        activityMode6.name = "RecyclerViewGragActivity";
        activityMode6.aClass = RecyclerViewGragActivity.class;
        arrayList.add(activityMode6);

        ActivityModel activityMode7 = new ActivityModel();
        activityMode7.name = "RecyclerViewAnimateActivity";
        activityMode7.aClass = RecyclerViewAnimateActivity.class;
        arrayList.add(activityMode7);
        return arrayList;
    }
}
