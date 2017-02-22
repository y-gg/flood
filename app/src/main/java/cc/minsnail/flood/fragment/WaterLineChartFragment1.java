package cc.minsnail.flood.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cc.minsnail.flood.R;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by yg on 2017/2/20.
 */
public class WaterLineChartFragment1 extends Fragment {
    private List<String> mXLabel;
    private View mView;
    private LineChartView mLineChartView;
    public WaterLineChartFragment1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_linechart,container,false);
        mLineChartView = (LineChartView) mView.findViewById(R.id.lineChartView);
        mLineChartView.setZoomType(ZoomType.HORIZONTAL);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mXLabel = new ArrayList<>();
        for (int i = 0;i<12;i++){
            mXLabel.add(i+"时");
        }
        drawLineChartView();
    }
    private void drawLineChartView(){
        List<PointValue> values = new ArrayList<>();
        for (int i=0;i<12;i++){
            values.add(new PointValue(i, (float) (Math.random()*50)));
        }
        Line line = new Line();
        line.setFilled(true);
        line.setColor(ChartUtils.COLOR_BLUE);
        //line.setHasLabels(true);
        line.setHasLabelsOnlyForSelected(true);
        line.setValues(values);

        List<Line> lines = new ArrayList<>();
        lines.add(line);

        LineChartData lineChartData = new LineChartData();
        Axis axisY = new Axis();
        axisY.setHasLines(true);
        axisY.setTextColor(Color.BLACK);
        axisY.setHasTiltedLabels(true);
        lineChartData.setAxisYLeft(axisY);

        Axis axisX = new Axis();
        axisX.setHasLines(true);
        axisX.setTextColor(Color.BLACK);
        List<AxisValue> axisXValues = new ArrayList<>();
        for (int i=0;i<mXLabel.size();i++){
            axisXValues.add(new AxisValue(i).setLabel(mXLabel.get(i)));
        }
        axisX.setValues(axisXValues);
        lineChartData.setAxisXBottom(axisX);

        lineChartData.setLines(lines);
        //lineChartData.setBaseValue(60);
        mLineChartView.setLineChartData(lineChartData);
        Viewport viewport = new Viewport();
        viewport.top = 100;
        viewport.left = 0;
        viewport.right= 8;
        viewport.bottom = 0;
        mLineChartView.setCurrentViewport(viewport);
    }
}
