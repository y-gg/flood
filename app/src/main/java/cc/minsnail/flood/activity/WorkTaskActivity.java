package cc.minsnail.flood.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.adapter.WorkTaskAdapter;
import cc.minsnail.flood.beans.WorkSubject;

/**
 * Created by yg on 2017/2/10.
 */
public class WorkTaskActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mTaskListView;
    private WorkTaskAdapter mTaskAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_task);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setText("工作信息");
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mTaskListView = (ListView) findViewById(R.id.work_task_list);
    }
    private void initEvent(){
        mTaskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(WorkTaskActivity.this,WorkTaskParticularsActivity.class).putExtra("name",((WorkSubject)mTaskAdapter.getItem(i)).getInfo()));
            }
        });
    }
    private void initInfo(){
        mTaskAdapter = new WorkTaskAdapter(WorkTaskActivity.this);
        mTaskListView.setAdapter(mTaskAdapter);
        List<WorkSubject> items = new ArrayList<>();
        items.add(new WorkSubject("水库"));
        items.add(new WorkSubject("山塘"));
        items.add(new WorkSubject("水闸"));
        mTaskAdapter.addAll(items);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
