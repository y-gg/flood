package cc.minsnail.flood.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by yg on 2017/2/16.
 */
public class TableHorizontalScrollView extends HorizontalScrollView {
    private HorizontalScrollListener scrollListener;
    public TableHorizontalScrollView(Context context) {
        this(context,null);
    }

    public TableHorizontalScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TableHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (scrollListener!=null){
            scrollListener.onScrollChanged(this,l,t,oldl,oldt);
        }
    }
    public HorizontalScrollListener getScrollListener() {
        return scrollListener;
    }

    public TableHorizontalScrollView setScrollListener(HorizontalScrollListener scrollListener) {
        this.scrollListener = scrollListener;
        return this;
    }

    public interface HorizontalScrollListener{
        void onScrollChanged(View sender, int l, int t, int oldl, int oldt);
    }
}
