package cc.minsnail.flood.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.adapter.AttributesAdapter;
import cc.minsnail.flood.beans.Form;

/**
 * Created by yg on 2017/2/10.
 */
public class ObjectAttributesActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mAttributeListView;
    private AttributesAdapter mAttributesAdapter;
    private String mtitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_attributes);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mtitle = getIntent().getStringExtra("name");
        mTitle.setText(mtitle);
        initView();
        initInfo();
    }
    private void initView(){
        mAttributeListView = (ListView) findViewById(R.id.attribute_list);
    }
    private void initInfo(){
        mAttributesAdapter = new AttributesAdapter(ObjectAttributesActivity.this);
        mAttributeListView.setAdapter(mAttributesAdapter);
        List<Form> formList = new ArrayList<>();
        formList.add(new Form("名称",mtitle));
        formList.add(new Form("工程规模","小二"));
        formList.add(new Form("主要挡水坝体建筑物类型（结构）","心墙坝"));
        mAttributesAdapter.addAll(formList);
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
