package cc.minsnail.flood.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yg on 2017/2/14.
 */
public class LettersSideBarView extends View {
    public static String[] INDEX_STRING = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    private OnTouchingLetterChangedListener onTouchingLetterChangedListener;
    private List<String> letterList;
    private int selected = -1;
    private Paint paint = new Paint();
    private int totalHeight;
    public LettersSideBarView(Context context) {
        this(context,null);
    }

    public LettersSideBarView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LettersSideBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        setBackgroundColor(Color.rgb(255,255,255));
        letterList = Arrays.asList(INDEX_STRING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int width = getWidth();
        //int singleHeight = height/letterList.size();
        int singleHeight = height/26;
        totalHeight = singleHeight*letterList.size();
        for (int position=0;position<letterList.size();position++){
            paint.setColor(Color.rgb(100,100,100));
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);
            paint.setTextSize(30);
            if (position == selected){
                paint.setColor(Color.rgb(75,246,209));
                //paint.setFakeBoldText(true);
            }
            float xPos = width/2-paint.measureText(letterList.get(position))/2;
            float yPos = singleHeight * position + singleHeight/2;
            yPos +=(height-totalHeight)/2;
            canvas.drawText(letterList.get(position),xPos,yPos,paint);
            paint.reset();
        }
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction();
        float touchedY = event.getY();
        float touchedX = event.getX();
        int height = getHeight();
        int offset = (height - this.totalHeight)/2;
        int oldSelected = selected;
        int index = (int) ((touchedY-offset)/this.totalHeight*letterList.size());
        switch (action){
            case MotionEvent.ACTION_UP:
                if (oldSelected == index)break;
                if (touchedX>0){
                    if (index>=0&&index<letterList.size()){
                        if (onTouchingLetterChangedListener!=null){
                            onTouchingLetterChangedListener.onTouchingLetterChanged(letterList.get(index));
                        }
                        selected = index;
                        invalidate();
                    }
                }else {
                    selected = -1;
                    invalidate();
                }
                break;
            default:
                break;
        }
        return true;
    }
    public void setSelectText(String s){
        for (int i=0;i<letterList.size();i++){
            if (letterList.get(i).charAt(0)==s.charAt(0)){
                selected = i;
                invalidate();
                return;
            }
        }
    }
    public void setIndexString(List<String> list){
        this.letterList = list;
        invalidate();
    }
    public void setOnTouchingLetterChangedListener(OnTouchingLetterChangedListener onTouchingLetterChangedListener) {
        this.onTouchingLetterChangedListener = onTouchingLetterChangedListener;
    }

    public interface OnTouchingLetterChangedListener{
        void onTouchingLetterChanged(String s);
    }
}
