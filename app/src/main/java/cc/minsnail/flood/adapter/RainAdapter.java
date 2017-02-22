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
import cc.minsnail.flood.beans.Rain;
import cc.minsnail.flood.manager.HorizontalScrollManager;
import cc.minsnail.flood.view.TableHorizontalScrollView;

/**
 * Created by yg on 2017/2/16.
 */
public class RainAdapter extends BaseAdapter {
    private Context context;
    private List<Rain> items;
    private HorizontalScrollManager scrollManager;
    public RainAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
        scrollManager = new HorizontalScrollManager();
    }
    public void add(Rain rain){
        if (rain!=null){
            this.items.add(rain);
            notifyDataSetChanged();
        }
    }
    public void addAll(List<Rain> items){
        for (Rain item:items){
            if (item!=null){
                this.items.add(item);
            }
        }
        notifyDataSetChanged();
    }
    public HorizontalScrollManager getScrollManager(){
        return scrollManager;
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
        Rain item = items.get(i);
        if (view==null){
            view = LayoutInflater.from(this.context).inflate(R.layout.fix_column_scroll_item,viewGroup,false);
            holder = new Holder();
            holder.textView_1 = (TextView) view.findViewById(R.id.text_1);
            holder.textView_2 = (TextView) view.findViewById(R.id.text_2);
            holder.textView_3 = (TextView) view.findViewById(R.id.text_3);
            holder.textView_4 = (TextView) view.findViewById(R.id.text_4);
            holder.scrollView = (TableHorizontalScrollView) view.findViewById(R.id.scrollView);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        holder.textView_1.setText(item.getName());
        holder.textView_2.setText(String.valueOf(item.getOneHRainfall()));
        holder.textView_3.setText(String.valueOf(item.getThreeHRainfall()));
        holder.textView_4.setText(String.valueOf(item.getTodayRainfall()));
        scrollManager.addView(holder.scrollView);
        return view;
    }
    class Holder{
        TextView textView_1;
        TextView textView_2;
        TextView textView_3;
        TextView textView_4;
        TableHorizontalScrollView scrollView;
    }
}
