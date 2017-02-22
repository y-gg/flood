package cc.minsnail.flood.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.R;
import cc.minsnail.flood.activity.WaterLineChartActivity;
import cc.minsnail.flood.adapter.WorkSumAdapter;
import cc.minsnail.flood.beans.WorkSum;

/**
 * Created by yg on 2017/2/20.
 */
public class ReservoirFragment extends Fragment {
    private View mView;
    private ListView mListView;
    private WorkSumAdapter mWorkSumAdapter;
    public ReservoirFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_reservoir,container,false);
        mListView = (ListView) mView.findViewById(R.id.listView);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        initEvent();
        iniInfo();
    }
    private void initEvent(){
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                WorkSum item = (WorkSum) mWorkSumAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), WaterLineChartActivity.class);
                intent.putExtra("name",item.getName());
                startActivity(intent);
            }
        });
    }
    private void iniInfo(){
        mWorkSumAdapter = new WorkSumAdapter(getActivity());
        mListView.setAdapter(mWorkSumAdapter);
        List<WorkSum> items = new ArrayList<>();
        items.add(new WorkSum("站点名称",String.valueOf(0),String.valueOf(0)));
        items.add(new WorkSum("站点名称",String.valueOf(0),String.valueOf(0)));
        items.add(new WorkSum("站点名称",String.valueOf(0),String.valueOf(0)));
        items.add(new WorkSum("站点名称",String.valueOf(0),String.valueOf(0)));
        items.add(new WorkSum("站点名称",String.valueOf(0),String.valueOf(0)));
        items.add(new WorkSum("站点名称",String.valueOf(0),String.valueOf(0)));
        mWorkSumAdapter.addAll(items);
    }
}
