package cc.minsnail.flood.manager;

import android.view.View;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.view.TableHorizontalScrollView;

/**
 * Created by yg on 2017/2/16.
 */
public class HorizontalScrollManager implements TableHorizontalScrollView.HorizontalScrollListener {
    private List<View> views;

    public HorizontalScrollManager() {
        views = new ArrayList<>();
    }
    public void addView(View view){
        if (view instanceof HorizontalScrollView){
            ((TableHorizontalScrollView)view).setScrollListener(this);
            views.add(view);
        }
    }
    public List<View> getViews(){
        return views;
    }
    @Override
    public void onScrollChanged(View sender, int l, int t, int oldl, int oldt) {
        if (l!=oldl){
            for (View view:views){
                if (view!=sender){
                    view.scrollTo(l,t);
                }
            }
        }
    }
}
