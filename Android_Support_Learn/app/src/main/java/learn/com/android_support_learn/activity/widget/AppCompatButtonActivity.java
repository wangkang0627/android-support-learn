package learn.com.android_support_learn.activity.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.CheckedTextView;

import learn.com.android_support_learn.BaseActivity;
import learn.com.android_support_learn.R;

/**
 * @ClassName: AppCompatButtonActivity
 * @Description:
 * @Author wk
 * @Date 2015/9/2 0002
 */
public class AppCompatButtonActivity extends BaseActivity {
    private android.support.v7.widget.AppCompatButton btncompat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compat_button_layout);
        this.btncompat = (AppCompatButton) findViewById(R.id.btn_compat);

        this.btncompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorStateList lists = getResources().getColorStateList(android.R.color.holo_red_light);
                ViewCompat.setBackgroundTintList(btncompat, lists);
                ViewCompat.setBackgroundTintMode(btncompat, PorterDuff.Mode.SRC_IN);
            }
        });

    }
}
