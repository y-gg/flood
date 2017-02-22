package cc.minsnail.flood.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;

/**
 * Created by yg on 2017/2/13.
 */
public class FileReaderActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_reader);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("");
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mTitleView = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitleView.setText("阅读");
        mTitleView.setTextColor(Color.rgb(255,255,255));
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
