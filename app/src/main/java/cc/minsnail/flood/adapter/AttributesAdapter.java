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
import cc.minsnail.flood.beans.Form;

/**
 * Created by yg on 2017/2/10.
 */
public class AttributesAdapter extends BaseAdapter {
    private Context context;
    private List<Form> items;

    public AttributesAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }
    public void add(Form item){
        if (item!=null){
            items.add(item);
            notifyDataSetChanged();
        }
    }
    public void addAll(List<Form> items){
        for (Form item:items){
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
        Form item = items.get(i);
        if (view==null){
            view = LayoutInflater.from(this.context).inflate(R.layout.simple_attribute_item,viewGroup,false);
            holder = new Holder();
            holder.variable = (TextView) view.findViewById(R.id.variable);
            holder.value = (TextView) view.findViewById(R.id.value);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.variable.setText(item.getVariable());
        holder.value.setText(item.getValue().toString());
        return view;
    }
    class Holder{
        TextView variable;
        TextView value;
    }
}
