package learn.com.android_support_learn.activity.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.Space;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import learn.com.android_support_learn.BaseActivity;
import learn.com.android_support_learn.R;

/**
 * @ClassName: AppCompatSpinnerActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/2 0002
 */
public class AppCompatSpinnerActivity extends BaseActivity {
    private AppCompatSpinner spinner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_compat_layout);
        this.spinner = (AppCompatSpinner) findViewById(R.id.spinner);
        this.spinner.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int i) {
                return i;
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, null);
                }
                TextView textView = (TextView) view;
                textView.setText(i + "");
                return view;
            }
        });
    }
}
