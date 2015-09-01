package learn.com.android_support_learn;

import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import de.greenrobot.event.EventBus;
import learn.com.android_support_learn.event.MainActivityEvent;

/**
 * @ClassName: MainActivity
 * @Description: 主activity
 * @Author wk
 * @Date: 2015/7/30 0030
 */
public class MainActivity extends BaseActivity {
    private SlidingPaneLayout slidingPaneLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentViewNoActionBar(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        slidingPaneLayout = (SlidingPaneLayout) findViewById(R.id.sp);
    }

    public void onEventMainThread(MainActivityEvent event) {
        switch (event.code) {
            //打开关闭侧边菜单
            case MainActivityEvent.SlidingPane:
                if (slidingPaneLayout.isOpen()) {
                    slidingPaneLayout.closePane();
                } else {
                    slidingPaneLayout.openPane();
                }
                break;

        }
    }

}
