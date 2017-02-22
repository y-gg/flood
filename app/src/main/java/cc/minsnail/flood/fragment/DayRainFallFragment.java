package cc.minsnail.flood.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.R;
import lecho.lib.hellocharts.formatter.ColumnChartValueFormatter;
import lecho.lib.hellocharts.formatter.SimpleColumnChartValueFormatter;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.ColumnChartView;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by yg on 2017/2/16.
 */
public class DayRainFallFragment extends Fragment {
    private List<String> mXLabel;
    private List<String> mYLabel;
    private int mSubColumnCount=1;
    private int mColumnCount=12;
    private View mView;
    private ColumnChartView mColumnChartView;

    public DayRainFallFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_rainfall,container,false);
        mColumnChartView = (ColumnChartView) mView.findViewById(R.id.columnChartView);
        mColumnChartView.setZoomType(ZoomType.HORIZONTAL);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mXLabel = new ArrayList<>();
        for (int i=1;i<=12;i++){
            mXLabel.add(i+"日8时");
        }
        drawColumnChart();
    }
    private void drawColumnChart(){
        List<Column> columns = new ArrayList<>();
        for (int i=0;i<mColumnCount;i++){
            Column column = new Column();
            column.setHasLabels(true);
            List<SubcolumnValue> subcolumnValues = new ArrayList<>();
            for (int j=0;j<mSubColumnCount;j++){
                SubcolumnValue subcolumnValue = new SubcolumnValue((float) (Math.random()*300f),Color.parseColor("#FF43B6EC"));
                subcolumnValues.add(subcolumnValue);
            }
            column.setValues(subcolumnValues);
            columns.add(column);
        }
        ColumnChartData columnChartData = new ColumnChartData(columns);

        Axis axisX = new Axis();
        axisX.setName("2月").setHasLines(true);
        axisX.setTextColor(Color.BLACK);
        List<AxisValue> axisXValues = new ArrayList<>();
        for (int i=0;i<mXLabel.size();i++){
            axisXValues.add(new AxisValue(i).setLabel(mXLabel.get(i)));
        }
        axisX.setValues(axisXValues);
        columnChartData.setAxisXBottom(axisX);

        Axis axisY = new Axis();
        axisY.setTextColor(Color.BLACK);
        axisY.setName("降雨量（mm）").setHasLines(true);
        List<AxisValue> axisYValues = new ArrayList<>();
        for (int i=0;i<500;i+=25){
            axisYValues.add(new AxisValue(i).setLabel(String.valueOf(i)));
        }
        axisY.setValues(axisYValues);
        columnChartData.setAxisYLeft(axisY);

        mColumnChartView.setColumnChartData(columnChartData);
        Viewport viewport = new Viewport();
        viewport.left = -1;
        viewport.top = 300;
        viewport.right= 5;
        viewport.bottom = 0;
        mColumnChartView.setCurrentViewport(viewport);
    }
}
