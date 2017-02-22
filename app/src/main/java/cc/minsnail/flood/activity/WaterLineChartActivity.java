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
import cc.minsnail.flood.fragment.WaterLineChartFragment1;
import cc.minsnail.flood.fragment.WaterLineChartFragment2;

/**
 * Created by yg on 2017/2/20.
 */
public class WaterLineChartActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    private String mTitle;
    private WaterLineChartFragment1 mWaterLineChartFragment1;
    private WaterLineChartFragment2 mWaterLineChartFragment2;
    private int showTag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_linechart);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTitle = getIntent().getStringExtra("name");
        mTitleView.setText(mTitle+"水位折线图");
        initView();
        initEvent();
        initInfo();
    }
    private void initView(){}
    private void initEvent(){}
    private void initInfo(){
        showFragment(0);
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
                if (mWaterLineChartFragment1==null){
                    mWaterLineChartFragment1 = new WaterLineChartFragment1();
                    transaction.add(R.id.frameLayout,mWaterLineChartFragment1);
                }else {
                    transaction.show(mWaterLineChartFragment1);
                }
                break;
            case 1:
                if (mWaterLineChartFragment2==null){
                    mWaterLineChartFragment2 = new WaterLineChartFragment2();
                    transaction.add(R.id.frameLayout,mWaterLineChartFragment2);
                }else {
                    transaction.show(mWaterLineChartFragment2);
                }
                break;
        }
        transaction.commit();
    }
    private void hideAllFragment(FragmentTransaction transaction){
        if (mWaterLineChartFragment1!=null){
            transaction.hide(mWaterLineChartFragment1);
        }
        if (mWaterLineChartFragment2!=null){
            transaction.hide(mWaterLineChartFragment2);
        }
    }
}
