package cc.minsnail.flood.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.adapter.ContactAdapter;
import cc.minsnail.flood.beans.Contact;

/**
 * Created by yg on 2017/2/13.
 */
public class ContactActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private ListView mContactListView;
    private ContactAdapter mContactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0,0,0));
        mToolbar.setTitle("");
        mToolbar.setSubtitle("取消");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setText("人员确认");
        mTitle.setTextColor(Color.rgb(255,255,255));
        setSupportActionBar(mToolbar);

        initView();
        initEvent();
        initInfo();
    }
    private void initView(){
        mContactListView = (ListView) findViewById(R.id.contact_list);
    }
    private void initEvent(){
        initSubtitleOnClick();
    }
    private void initInfo(){
        mContactAdapter = new ContactAdapter(ContactActivity.this);
        mContactListView.setAdapter(mContactAdapter);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("薛鹏举"));
        contactList.add(new Contact("夏吴"));
        mContactAdapter.addAll(contactList);
    }
    private void initSubtitleOnClick(){
        View subtitle = null;
        try {
            Field field = mToolbar.getClass().getDeclaredField("mSubtitleTextView");
            field.setAccessible(true);
            subtitle = (View) field.get(mToolbar);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (subtitle!=null){
            subtitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contact,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//
//        }
        return super.onOptionsItemSelected(item);
    }
}
