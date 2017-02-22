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
import cc.minsnail.flood.adapter.WorkSumAdapter;
import cc.minsnail.flood.beans.WorkSum;

/**
 * Created by yg on 2017/2/10.
 */
public class WorkTaskParticularsActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mWorkSumListView;
    private WorkSumAdapter mWorkSumAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_task_particulars);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getStringExtra("name");
        mTitle.setText(title);
        initView();
        initEvent();
        iniInfo();
    }
    private void initView(){
        mWorkSumListView = (ListView) findViewById(R.id.work_sum_list);
    }
    private void initEvent(){
        mWorkSumListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(WorkTaskParticularsActivity.this,ObjectAttributesActivity.class).putExtra("name",((WorkSum)mWorkSumAdapter.getItem(i)).getName()));
            }
        });
    }
    private void iniInfo(){
        mWorkSumAdapter = new WorkSumAdapter(WorkTaskParticularsActivity.this);
        mWorkSumListView.setAdapter(mWorkSumAdapter);
        List<WorkSum> items = new ArrayList<>();
        items.add(new WorkSum("大河水库","- -","长涂镇"));
        items.add(new WorkSum("大河水库","- -","长涂镇"));
        mWorkSumAdapter.addAll(items);
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
