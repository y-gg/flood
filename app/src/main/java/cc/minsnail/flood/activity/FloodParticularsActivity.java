package cc.minsnail.flood.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;

/**
 * Created by yg on 2017/2/10.
 */
public class FloodParticularsActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood_particulars);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setText("详情");
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
