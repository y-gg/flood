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
import cc.minsnail.flood.adapter.CurrFloodAdapter;
import cc.minsnail.flood.beans.FloodSum;

/**
 * Created by yg on 2017/2/10.
 */
public class CurrentFloodActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    private ListView mFloodSummaryView;
    private CurrFloodAdapter mCurrFloodAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_flood);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setText("当前汛情");
        mTitleView.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mFloodSummaryView = (ListView) findViewById(R.id.flood_summary);
    }
    private void initEvent(){
        mFloodSummaryView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(CurrentFloodActivity.this,FloodParticularsActivity.class));
            }
        });
    }
    private void initInfo(){
        mCurrFloodAdapter = new CurrFloodAdapter(CurrentFloodActivity.this);
        mFloodSummaryView.setAdapter(mCurrFloodAdapter);
        List<FloodSum> items = new ArrayList<>();
        items.add(new FloodSum("雨量超预警0个"));
        items.add(new FloodSum("水位超预警0个"));
        items.add(new FloodSum("单站当日最大降雨量0mm"));
        items.add(new FloodSum("单站当日1小时最大降雨量0mm"));
        items.add(new FloodSum("当日台风0个"));
        mCurrFloodAdapter.addAll(items);
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
