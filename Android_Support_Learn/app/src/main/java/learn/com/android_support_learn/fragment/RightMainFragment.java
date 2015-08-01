package learn.com.android_support_learn.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import de.greenrobot.event.EventBus;
import learn.com.android_support_learn.R;
import learn.com.android_support_learn.adapter.RightMainAdapter;
import learn.com.android_support_learn.event.MainActivityEvent;

/**
 * @ClassName: RightMainFragment
 * @Description:
 * @Author wk
 * @Date: 2015/7/30 0030
 */
public class RightMainFragment extends BaseFragment {
    private Toolbar toolbar;
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;

    @Override
    protected void init() {
        AppCompatActivity appCompatActivity = ((AppCompatActivity) getActivity());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        appCompatActivity.setSupportActionBar(toolbar);
        ActionBar actionBar = appCompatActivity.getSupportActionBar();
        actionBar.setTitle(R.string.index);
        toolbar.setNavigationIcon(R.mipmap.ic_menu_white);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MainActivityEvent(MainActivityEvent.SlidingPane));
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(layoutManager);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        refreshLayout.setColorSchemeResources(R.color.asl_them_color,
                R.color.asl_them_color, R.color.asl_them_color, R.color.asl_them_color);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        recyclerView.setAdapter(new RightMainAdapter(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.right_main_fragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()) {
            case R.id.action_settings:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
