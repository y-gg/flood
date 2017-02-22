package cc.minsnail.flood;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cc.minsnail.flood.activity.AddressGroupActivity;
import cc.minsnail.flood.activity.BrowserActivity;
import cc.minsnail.flood.activity.CurrentFloodActivity;
import cc.minsnail.flood.activity.FloodReliefActivity;
import cc.minsnail.flood.activity.MeteorologicalActivity;
import cc.minsnail.flood.activity.PreRecordActivity;
import cc.minsnail.flood.activity.RainActivity;
import cc.minsnail.flood.activity.SMSActivity;
import cc.minsnail.flood.activity.SettingActivity;
import cc.minsnail.flood.activity.WaterActivity;
import cc.minsnail.flood.activity.WorkTaskActivity;

public class MainActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    private View mOne;
    private View mTwo;
    private View mThree;
    private View mFour;
    private View mFive;
    private View mSix;
    private View mSeven;
    private View mEight;
    private View mNine;
    private View mTen;
    private View mEleven;
    private View mTwelve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0, 0, 0));
        mToolbar.setTitle("");
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setText("山洪防治移动平台");
        mTitleView.setTextColor(Color.rgb(255, 255, 255));
        setSupportActionBar(mToolbar);
        initView();
        initEvent();
    }

    private void initView() {
        mOne = findViewById(R.id.items_one);
        mTwo = findViewById(R.id.items_two);
        mThree = findViewById(R.id.items_three);
        mFour = findViewById(R.id.items_four);
        mFive = findViewById(R.id.items_five);
        mSix = findViewById(R.id.items_six);
        mSeven = findViewById(R.id.items_seven);
        mEight = findViewById(R.id.items_eight);
        mNine = findViewById(R.id.items_nine);
        mTen = findViewById(R.id.items_ten);
        mEleven = findViewById(R.id.items_eleven);
        mTwelve = findViewById(R.id.items_twelve);
    }

    private void initEvent() {
        mOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CurrentFloodActivity.class));
            }
        });
        mTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RainActivity.class));
            }
        });
        mThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WaterActivity.class));
            }
        });
        mFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, WorkTaskActivity.class));
            }
        });
        mFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowserActivity.class);
                intent.putExtra("name", "台风路径");
                intent.putExtra("url", "http://typhoon.zjwater.gov.cn/wap.htm");
                startActivity(intent);
            }
        });
        mSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FloodReliefActivity.class));
            }
        });
        mSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MeteorologicalActivity.class));
            }
        });
        mEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BrowserActivity.class);
                intent.putExtra("name", "GIS应用");
                intent.putExtra("url", "http://typhoon.zjwater.gov.cn/wap.htm");
                startActivity(intent);
            }
        });
        mNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddressGroupActivity.class));
            }
        });
        mTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PreRecordActivity.class));
            }
        });
        mEleven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SMSActivity.class));
            }
        });
        mTwelve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });
    }
}
