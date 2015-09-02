package learn.com.android_support_learn.activity.widget;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import learn.com.android_support_learn.BaseActivity;
import learn.com.android_support_learn.R;

/**
 * @ClassName: DialogCompatActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/2 0002
 */
public class DialogCompatActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_layout);
        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(DialogCompatActivity.this);
                builder.setTitle("Dialog");
                builder.setMessage("测试");
                builder.setPositiveButton(android.R.string.yes, null);
                builder.setNegativeButton(android.R.string.no, null);
                builder.show();
            }
        });
    }
}
