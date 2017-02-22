package cc.minsnail.flood.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.fragment.DayRainFallFragment;
import cc.minsnail.flood.fragment.HourRainFallFragment;

/**
 * Created by yg on 2017/2/16.
 */
public class RainColumnChartActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    private String mTitle;
    private DayRainFallFragment mDayRainFallFragment;
    private HourRainFallFragment mHourRainFallFragment;
    private int showTag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_columnchart);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle = getIntent().getStringExtra("name");
        mTitleView.setText(mTitle+"雨情柱状图");
        initView();
        initEvent();
        initInfo();
    }

    private void initView() {
    }
    private void initEvent() {
    }
    private void initInfo(){
        showFragment(showTag);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_histogram,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.change:
                showTag =(showTag+1)%2;
                showFragment(showTag);
                break;
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    private void showFragment(int tag){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideAllFragment(transaction);
        switch (tag){
            case 0:
                if (mDayRainFallFragment==null){
                    mDayRainFallFragment = new DayRainFallFragment();
                    transaction.add(R.id.frameLayout,mDayRainFallFragment);
                }else {
                    transaction.show(mDayRainFallFragment);
                }
                break;
            case 1:
                if (mHourRainFallFragment==null){
                    mHourRainFallFragment = new HourRainFallFragment();
                    transaction.add(R.id.frameLayout,mHourRainFallFragment);
                }else {
                    transaction.show(mHourRainFallFragment);
                }
                break;
        }
        transaction.commit();
    }
    private void hideAllFragment(FragmentTransaction transaction){
        if (mDayRainFallFragment!=null){
            transaction.hide(mDayRainFallFragment);
        }
        if (mHourRainFallFragment!=null){
            transaction.hide(mHourRainFallFragment);
        }
    }
}
