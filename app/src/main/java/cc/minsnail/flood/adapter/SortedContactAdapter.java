package cc.minsnail.flood.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cc.minsnail.flood.R;
import cc.minsnail.flood.beans.Contact;
import cc.minsnail.flood.utils.PinyinComparator;

/**
 * Created by yg on 2017/2/14.
 */
public class SortedContactAdapter extends BaseAdapter implements SectionIndexer{
    private Context context;
    private List<Contact> items;
    private List<String> indexString;
    private IndexStringChangedListener indexStringListener;
    public SortedContactAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
        indexString = new ArrayList<>();
    }
    public void add(Contact contact){
        if (contact!=null){
            this.items.add(contact);
            Collections.sort(this.items,new PinyinComparator());
            initIndexString();
            notifyDataSetChanged();
        }
    }
    public void addAll(List<Contact> items){
        for (Contact item:items){
            if (item!=null){
                this.items.add(item);
            }
        }
        Collections.sort(this.items,new PinyinComparator());
        initIndexString();
        notifyDataSetChanged();
    }
    private void initIndexString(){
        this.indexString.clear();
        for (Contact item:items){
            if (!this.indexString.contains(item.getFirstWord())){
                this.indexString.add(item.getFirstWord());
            }
        }
        if (indexStringListener!=null){
            indexStringListener.onChanged(this.indexString);
        }
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
        Contact item = this.items.get(i);
        if (view==null){
            view = LayoutInflater.from(this.context).inflate(R.layout.simple_contact_item,viewGroup,false);
            holder = new Holder();
            holder.tag = (TextView) view.findViewById(R.id.group_tag);
            holder.textView_1 = (TextView) view.findViewById(R.id.text_1);
            holder.textView_2 = (TextView) view.findViewById(R.id.text_2);
            holder.textView_3 = (TextView) view.findViewById(R.id.text_3);
            holder.textView_4 = (TextView) view.findViewById(R.id.text_4);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
        int section = getSectionForPosition(i);
        if (i==getPositionForSection(section)){
            holder.tag.setVisibility(View.VISIBLE);
            holder.tag.setText(item.getFirstWord());
        }else {
            holder.tag.setVisibility(View.GONE);
        }
        holder.textView_1.setText(item.getName());
        holder.textView_2.setText(item.getNumber());
        holder.textView_3.setText(item.getRole());
        return view;
    }
    class Holder{
        TextView tag;
        TextView textView_1;
        TextView textView_2;
        TextView textView_3;
        TextView textView_4;
    }
    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int i) {
        for (int position= 0;position<getCount();position++){
            String firstWord = this.items.get(position).getFirstWord();
            char firstChar = firstWord.toUpperCase().charAt(0);
            if (firstChar==i){
                return position;
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int i) {
        Log.i("char",items.get(i).getFirstWord());
        Log.i("i",items.get(i).getFirstWord().charAt(0)+"");
        return items.get(i).getFirstWord().charAt(0);
    }
    public void setIndexStringChangedListener(IndexStringChangedListener listener){
        this.indexStringListener = listener;
    }
    public interface IndexStringChangedListener{
        void onChanged(List<String> newIndex);
    }
}
