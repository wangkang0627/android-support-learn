package learn.com.android_support_learn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;

/**
 * @ClassName: LinearLayoutCompat
 * @Description:
 * @Author wk
 * @Date 2015/9/1 0001
 */
public class LinearLayoutCompatActivity extends BaseActivity {
    private LinearLayoutCompat linearcompat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linearlayout_compat);
        this.linearcompat = (LinearLayoutCompat) findViewById(R.id.linear_compat);
    }
}
