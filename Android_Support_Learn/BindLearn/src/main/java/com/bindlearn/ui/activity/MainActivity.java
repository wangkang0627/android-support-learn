package com.bindlearn.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.bindlearn.R;
import com.bindlearn.model.ActivityModel;
import com.bindlearn.ui.adapter.recyclerview.MainActivityAdapter;
import com.bindlearn.utils.DataSource;
import com.core.library.activity.BaseToolBarActivity;
import com.core.library.recyclerview.adapter.BaseRecyclerAdapter;

public class MainActivity extends BaseToolBarActivity {
    MainActivityAdapter mainActivityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainActivityAdapter = new MainActivityAdapter(this);
        recyclerView.setAdapter(mainActivityAdapter);
        mainActivityAdapter.setItemSelectListener(new BaseRecyclerAdapter.ItemSelectListener() {
            @Override
            public void onSelect(RecyclerView.ViewHolder viewHolder, int position) {
                ActivityModel activityModel = mainActivityAdapter.getItem(position);
                startActivity(new Intent(MainActivity.this, activityModel.aClass));
            }
        });
        mainActivityAdapter.refreshData(DataSource.getData());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
