package cc.minsnail.flood.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.R;
import cc.minsnail.flood.beans.ContactGroup;

/**
 * Created by yg on 2017/2/13.
 */
public class ContactGroupAdapter extends BaseAdapter {
    private Context context;
    private List<ContactGroup> items;
    public ContactGroupAdapter(Context context){
        this.context = context;
        items = new ArrayList<>();
    }
    public void add(ContactGroup item){
        if (item!=null){
            items.add(item);
            notifyDataSetChanged();
        }
    }
    public void addAll(List<ContactGroup> items){
        for (ContactGroup item:items){
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
        ContactGroup item = items.get(i);
        if (view == null){
            view = LayoutInflater.from(this.context).inflate(R.layout.simple_list_find_next_item,viewGroup,false);
            holder = new Holder();
            holder.textView_1 = (TextView) view.findViewById(R.id.item_title);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.textView_1.setText(item.getName());
        return view;
    }
    class Holder{
        TextView textView_1;
    }
}
