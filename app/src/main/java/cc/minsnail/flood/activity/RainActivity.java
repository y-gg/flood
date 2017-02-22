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
import cc.minsnail.flood.adapter.RainAdapter;
import cc.minsnail.flood.beans.Rain;
import cc.minsnail.flood.view.TableHorizontalScrollView;

/**
 * Created by yg on 2017/2/16.
 */
public class RainActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    private TableHorizontalScrollView mHeaderScrollView;
    private ListView mListView;
    private RainAdapter mRainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setText("雨情信息");
        mTitleView.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mHeaderScrollView = (TableHorizontalScrollView) findViewById(R.id.scrollView);
        mListView = (ListView) findViewById(R.id.listView);
    }
    private void initEvent(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Rain rain = (Rain) mRainAdapter.getItem(i);
                Intent intent = new Intent(RainActivity.this,RainColumnChartActivity.class);
                intent.putExtra("name",rain.getName());
                startActivity(intent);
            }
        });
    }
    private void initInfo(){
        mRainAdapter = new RainAdapter(RainActivity.this);
        mRainAdapter.getScrollManager().addView(mHeaderScrollView);
        mListView.setAdapter(mRainAdapter);
        List<Rain> rains = new ArrayList<>();
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        rains.add(new Rain("站点名称",1,2,5));
        mRainAdapter.addAll(rains);
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
