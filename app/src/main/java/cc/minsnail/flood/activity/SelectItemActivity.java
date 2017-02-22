package cc.minsnail.flood.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.adapter.ContactGroupAdapter;
import cc.minsnail.flood.beans.ContactGroup;

/**
 * Created by yg on 2017/2/13.
 */
public class SelectItemActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mContactGroupListView;
    private ContactGroupAdapter mContactGroupAdapter;
    private String mGroupName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_group);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mGroupName = getIntent().getStringExtra("name");
        mTitle.setText(mGroupName);
        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mContactGroupListView = (ListView) findViewById(R.id.contact_group_list);

    }
    private void initEvent(){
        mContactGroupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SelectItemActivity.this,SortedContactActivity.class);
                intent.putExtra("name",((ContactGroup)mContactGroupAdapter.getItem(i)).getName());
                startActivity(intent);
            }
        });
    }
    private void initInfo(){
        mContactGroupAdapter = new ContactGroupAdapter(SelectItemActivity.this);
        mContactGroupListView.setAdapter(mContactGroupAdapter);
        List<ContactGroup> groupList = new ArrayList<>();
        groupList.add(new ContactGroup("县市本级（10人）"));
        groupList.add(new ContactGroup("高亭镇"));
        groupList.add(new ContactGroup("东沙镇"));
        groupList.add(new ContactGroup("岱东镇"));
        mContactGroupAdapter.addAll(groupList);
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
