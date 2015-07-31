package learn.com.android_support_learn;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;

import de.greenrobot.event.EventBus;

/**
 * @ClassName: BaseActivity
 * @Description: 基础activity
 * @Author wk
 * @Date: 2015/7/30 0030
 */
public class BaseActivity extends AppCompatActivity {
    public Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(R.layout.base_layout_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getLayoutInflater().inflate(layoutResID, (ViewGroup
                ) findViewById(R.id.base_content));
    }

    /**
     * @param layoutResID 设置没有actionbar的view
     */
    public void setContentViewNoActionBar(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
    }


}
