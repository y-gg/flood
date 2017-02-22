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
public class SMSActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mContactGroupListView;
    private ContactGroupAdapter mContactGroupAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_group);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setText("自定义分组");
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                startActivity(new Intent(SMSActivity.this,ContactActivity.class));
            }
        });
    }
    private void initInfo(){
        mContactGroupAdapter = new ContactGroupAdapter(SMSActivity.this);
        mContactGroupListView.setAdapter(mContactGroupAdapter);
        List<ContactGroup> groupList = new ArrayList<>();
        groupList.add(new ContactGroup("县领导"));
        groupList.add(new ContactGroup("县三防办"));
        groupList.add(new ContactGroup("乡、镇长"));
        groupList.add(new ContactGroup("村主任、书记"));
        groupList.add(new ContactGroup("地质灾害点防治负责人"));
        groupList.add(new ContactGroup("海塘责任人"));
        groupList.add(new ContactGroup("水库巡查员"));
        groupList.add(new ContactGroup("海塘管理员"));
        mContactGroupAdapter.addAll(groupList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact_group,menu);
        return super.onCreateOptionsMenu(menu);
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
