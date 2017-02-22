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
import cc.minsnail.flood.adapter.PreRecordAdapter;
import cc.minsnail.flood.beans.PreRecord;

/**
 * Created by yg on 2017/2/13.
 */
public class PreRecordActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    private ListView mRecordListView;
    private PreRecordAdapter mPreRecordAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood_pre_record);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setText("防汛预案");
        mTitleView.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mRecordListView = (ListView) findViewById(R.id.flood_pre_record_list);
    }
    private void initEvent(){
        mRecordListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(PreRecordActivity.this,FileReaderActivity.class));
            }
        });
    }
    private void initInfo(){
        mPreRecordAdapter = new PreRecordAdapter(PreRecordActivity.this);
        mRecordListView.setAdapter(mPreRecordAdapter);
        List<PreRecord> recordList = new ArrayList<>();
        recordList.add(new PreRecord("岱山县山洪灾害防御预案"));
        recordList.add(new PreRecord("岱山县山洪灾害防治项目山洪灾害防御预案"));
        mPreRecordAdapter.addAll(recordList);
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
