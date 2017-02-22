package cc.minsnail.flood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.R;
import cc.minsnail.flood.beans.WorkSum;

/**
 * Created by yg on 2017/2/10.
 */
public class WorkSumAdapter extends BaseAdapter {
    private Context context;
    private List<WorkSum> items;
    public WorkSumAdapter(Context context){
        this.context = context;
        items = new ArrayList<>();
    }
    public void add(WorkSum item){
        if (item!=null){
            items.add(item);
            notifyDataSetChanged();
        }
    }
    public void addAll(List<WorkSum>items){
        for (WorkSum item:items){
            if (item!=null){
                this.items.add(item);
            }
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        WorkSum item = items.get(i);
        if (view==null){
            view = LayoutInflater.from(this.context).inflate(R.layout.work_list_sum_item,viewGroup,false);
            holder = new Holder();
            holder.textView_1 = (TextView) view.findViewById(R.id.text_1);
            holder.textView_2 = (TextView) view.findViewById(R.id.text_2);
            holder.textView_3 = (TextView) view.findViewById(R.id.text_3);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.textView_1.setText(item.getName());
        holder.textView_2.setText(item.getBasin());
        holder.textView_3.setText(item.getRegion());
        return view;
    }
    class Holder{
        TextView textView_1;
        TextView textView_2;
        TextView textView_3;
    }
}
