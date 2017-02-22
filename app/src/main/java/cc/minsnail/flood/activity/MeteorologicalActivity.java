package cc.minsnail.flood.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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
 * Created by yg on 2017/2/15.
 */
public class MeteorologicalActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mTaskListView;
    private WorkTaskAdapter mTaskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_task);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setText("气象国土");
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
                WorkSubject workSubject = (WorkSubject) mTaskAdapter.getItem(i);
                Intent intent = new Intent(MeteorologicalActivity.this,BrowserActivity.class);
                intent.putExtra("name",workSubject.getInfo());
                intent.putExtra("url",workSubject.getUrl());
                startActivity(intent);
            }
        });
    }
    private void initInfo(){
        mTaskAdapter = new WorkTaskAdapter(MeteorologicalActivity.this);
        mTaskListView.setAdapter(mTaskAdapter);
        List<WorkSubject> items = new ArrayList<>();
        items.add(new WorkSubject("天气预报","http://typhoon.zjwater.gov.cn/wap.htm"));
        items.add(new WorkSubject("一小时降雨预报"));
        items.add(new WorkSubject("三小时降雨预报"));
        items.add(new WorkSubject("卫星云图"));
        items.add(new WorkSubject("气象雷达"));
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
