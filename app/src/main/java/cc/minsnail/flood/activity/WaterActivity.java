package cc.minsnail.flood.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.fragment.OtherFragment;
import cc.minsnail.flood.fragment.ReservoirFragment;
import cc.minsnail.flood.fragment.RiverFragment;

/**
 * Created by yg on 2017/2/20.
 */
public class WaterActivity extends BaseActivity {
    private static final int RESERVOIR_TAG = 0;
    private static final int RIVER_TAG = 1;
    private static final int OTHER_TAG = 2;
    private Toolbar mToolbar;
    private ReservoirFragment mReservoirFragment;
    private RiverFragment mRiverFragment;
    private OtherFragment mOtherFragment;

    private TextView mReservoirBtn;
    private TextView mRiverBtn;
    private TextView mOtherBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        //mToolbar.setSubtitle("取消");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mReservoirBtn = (TextView) mToolbar.findViewById(R.id.text_1);
        mRiverBtn = (TextView) mToolbar.findViewById(R.id.text_2);
        mOtherBtn = (TextView) mToolbar.findViewById(R.id.text_3);
    }
    private void initEvent(){
        mReservoirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(RESERVOIR_TAG);
            }
        });
        mRiverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(RIVER_TAG);
            }
        });
        mOtherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(OTHER_TAG);
            }
        });
    }
    private void initInfo(){
        showFragment(RESERVOIR_TAG);
    }
    private void clearAllBackground(){
        mReservoirBtn.setBackgroundColor(Color.BLACK);
        mReservoirBtn.setTextColor(Color.WHITE);
        mRiverBtn.setBackgroundColor(Color.BLACK);
        mRiverBtn.setTextColor(Color.WHITE);
        mOtherBtn.setBackgroundColor(Color.BLACK);
        mOtherBtn.setTextColor(Color.WHITE);
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
    private void showFragment(int tag){
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideAllFragment(transaction);
        clearAllBackground();
        switch (tag){
            case RESERVOIR_TAG:
                mReservoirBtn.setTextColor(Color.BLACK);
                mReservoirBtn.setBackgroundColor(Color.WHITE);
                if (mReservoirFragment==null){
                    mReservoirFragment = new ReservoirFragment();
                    transaction.add(R.id.frameLayout,mReservoirFragment);
                }else {
                    transaction.show(mReservoirFragment);
                }
                break;
            case RIVER_TAG:
                mRiverBtn.setTextColor(Color.BLACK);
                mRiverBtn.setBackgroundColor(Color.WHITE);
                if (mRiverFragment==null){
                    mRiverFragment = new RiverFragment();
                    transaction.add(R.id.frameLayout,mRiverFragment);
                }else {
                    transaction.show(mRiverFragment);
                }
                break;
            case OTHER_TAG:
                mOtherBtn.setTextColor(Color.BLACK);
                mOtherBtn.setBackgroundColor(Color.WHITE);
                if (mOtherFragment==null){
                    mOtherFragment = new OtherFragment();
                    transaction.add(R.id.frameLayout,mOtherFragment);
                }else {
                    transaction.show(mOtherFragment);
                }
                break;
        }
        transaction.commit();
    }
    private void hideAllFragment(FragmentTransaction transaction){
        if (mReservoirFragment!=null){
            transaction.hide(mReservoirFragment);
        }
        if (mRiverFragment!=null){
            transaction.hide(mRiverFragment);
        }
        if (mOtherFragment!=null){
            transaction.hide(mOtherFragment);
        }
    }
}
