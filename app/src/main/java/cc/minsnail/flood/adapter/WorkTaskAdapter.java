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
import cc.minsnail.flood.beans.WorkSubject;

/**
 * Created by yg on 2017/2/10.
 */
public class WorkTaskAdapter extends BaseAdapter {
    private Context context;
    private List<WorkSubject> items;
    public WorkTaskAdapter(Context context){
        this.context = context;
        items = new ArrayList<>();
    }
    public void add(WorkSubject item){
        if (item!=null){
            items.add(item);
            notifyDataSetChanged();
        }
    }
    public void addAll(List<WorkSubject> items){
        for (WorkSubject item:items){
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
        WorkSubject item = items.get(i);
        if (view==null){
            view = LayoutInflater.from(this.context).inflate(R.layout.simple_list_flood_sum_item,viewGroup,false);
            holder = new Holder();
            holder.info = (TextView) view.findViewById(R.id.item_title);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.info.setText(item.getInfo());
        return view;
    }
    class Holder{
        TextView info;
    }
}
