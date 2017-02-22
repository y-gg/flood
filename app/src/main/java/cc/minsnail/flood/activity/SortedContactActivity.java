package cc.minsnail.flood.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.BaseActivity;
import cc.minsnail.flood.R;
import cc.minsnail.flood.adapter.SortedContactAdapter;
import cc.minsnail.flood.beans.Contact;
import cc.minsnail.flood.utils.PinyinUtils;
import cc.minsnail.flood.view.LettersSideBarView;

/**
 * Created by yg on 2017/2/14.
 */
public class SortedContactActivity extends BaseActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private String mGroupName;
    private ListView mContactListView;
    private LettersSideBarView mSideBarView;
    private SortedContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorted_contact);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setBackgroundColor(Color.rgb(0, 0, 0));
        mToolbar.setTitle("");
        mTitle = (TextView) mToolbar.findViewById(R.id.center_title);
        mTitle.setTextColor(Color.rgb(255, 255, 255));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mGroupName = getIntent().getStringExtra("name");
        mTitle.setText(mGroupName);
        initView();
        initEvent();
        initInfo();
    }

    private void initView() {
        mContactListView = (ListView) findViewById(R.id.item_list);
        mSideBarView = (LettersSideBarView) findViewById(R.id.side_bar);
    }

    private void initEvent() {
        mSideBarView.setOnTouchingLetterChangedListener(new LettersSideBarView.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int position = mAdapter.getPositionForSection(s.charAt(0));
                if (position != -1) {
                    mContactListView.setSelection(position);
                }
            }
        });
        mContactListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Contact contact = (Contact) mAdapter.getItem(i);
                final String number = contact.getNumber();
                if (number != null && !number.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SortedContactActivity.this);
                    builder.setTitle("拨打电话？");
                    builder.setMessage(number);
                    builder.setPositiveButton("拨打", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (ActivityCompat.checkSelfPermission(SortedContactActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    ActivityCompat#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for ActivityCompat#requestPermissions for more details.
                                //startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number)));
                                Toast toast = Toast.makeText(SortedContactActivity.this,"没有拨打电话权限！",Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP,0,200);
                                toast.show();
                                return;
                            }
                            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number)));
                        }
                    });
                    builder.setNegativeButton("取消",null);
                    builder.create().show();
                }
            }
        });
        mContactListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int position = -1;
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i==0){
                    int oldPos = position;
                    int currPos = mContactListView.getFirstVisiblePosition();
                    if (oldPos != currPos){
                        position = currPos;
                        mSideBarView.setSelectText(((Contact)mAdapter.getItem(currPos)).getFirstWord());
                    }
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
            }
        });
    }
    private void initInfo(){
        mAdapter = new SortedContactAdapter(SortedContactActivity.this);
        mAdapter.setIndexStringChangedListener(new SortedContactAdapter.IndexStringChangedListener() {
            @Override
            public void onChanged(List<String> newIndex) {
                if (newIndex!=null){
                    mSideBarView.setIndexString(newIndex);
                }
            }
        });
        mContactListView.setAdapter(mAdapter);
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("aa","10086").setRole("水库巡查员"));
        contactList.add(new Contact("bbb","10086").setRole("水库巡查员"));
        contactList.add(new Contact("杨广","10086").setRole("水库巡查员"));
        contactList.add(new Contact("李恒","10086").setRole("水库巡查员"));
        contactList.add(new Contact("ww","10086").setRole("水库巡查员"));
        contactList.add(new Contact("wu","10086").setRole("水库巡查员"));
        contactList.add(new Contact("xx","15988829204").setRole("水库巡查员"));
        contactList.add(new Contact("杨广","15988829204").setRole("水库巡查员"));
        contactList.add(new Contact("1545"));
        mAdapter.addAll(contactList);
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
