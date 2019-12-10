package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class Line1Activity extends AppCompatActivity {
    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line1);
        lineChart=findViewById(R.id.lc);

        IMarker marker=new YourMarkerView(this);
        lineChart.setMarker(marker);
        lineChart=setAxis(lineChart);
        LineData lineData=setLine();
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    public LineData setLine(){
        List<Entry> entries=new ArrayList<>();
        List<Entry> entries1=new ArrayList<>();

        entries.add(new Entry(1,4));
        entries.add(new Entry(2,5));
        entries.add(new Entry(3,8));
        entries.add(new Entry(5,4));
        entries.add(new Entry(6,8));

        entries1.add(new Entry(1,8));
        entries1.add(new Entry(2,3));
        entries1.add(new Entry(3,9));
        entries1.add(new Entry(5,7));
        entries1.add(new Entry(6,10));
        LineDataSet dataSet=new LineDataSet(entries,"数据1");
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        LineDataSet dataSet1=new LineDataSet(entries1,"数据二");
        dataSet1.setAxisDependency(YAxis.AxisDependency.LEFT);//指定绘制的轴

        List<ILineDataSet> list=new ArrayList<>();
        list.add(dataSet);
        list.add(dataSet1);
        /*
        分别设置两条线的颜色，和样式
        dataSet
        dataSet1
         */
        dataSet.setValueTextSize(20);
        dataSet.setCircleRadius(6);
        dataSet.setCircleColor(Color.BLACK);
        dataSet.setColor(Color.BLACK);
        dataSet1.setValueTextSize(20);
        dataSet1.setCircleRadius(6);
        dataSet1.setCircleColor(Color.BLACK);
        dataSet1.setColor(Color.BLACK);
        /*
        最后将两条线添加到LineData中
        在lineChart中显示出来
         */
        LineData data=new LineData(list);
//        lineChart.setData(data);
        return data;
    }
    public LineChart setAxis(LineChart lineChart){
        XAxis xAxis=lineChart.getXAxis();
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return String.valueOf((int)value).concat("月份");
            }
        });
        YAxis yAxisLeft=lineChart.getAxisLeft();
        YAxis yAxisRight=lineChart.getAxisRight();
        A(xAxis,yAxisLeft,yAxisRight);
        return lineChart;
    }
    private void A(XAxis xAxis,YAxis yAxisLeft,YAxis yAxisRight){
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(10);
        xAxis.setAxisLineWidth(2);
        xAxis.setGranularity(1); //数据的间隔
        xAxis.setLabelCount(5,true);//坐标轴的数据有几个
        xAxis.setEnabled(true);

        yAxisLeft.setAxisMinimum(0);
        yAxisLeft.setTextSize(10);
        yAxisLeft.setAxisLineWidth(2);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setEnabled(true);

        yAxisRight.setDrawGridLines(false);
        yAxisRight.setEnabled(false);
    }
}
