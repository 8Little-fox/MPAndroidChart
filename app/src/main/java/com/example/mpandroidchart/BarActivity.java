package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

public class BarActivity extends AppCompatActivity {
    private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        barChart=findViewById(R.id.bar_Chart);
        barChart.setScaleEnabled(true);
        barChart.setDoubleTapToZoomEnabled(true);//双击放大图表
        barChart.setPinchZoom(true);//启动缩放

        barChart=initBarChart(barChart);
        BarData barData=setData();
        barChart.setData(barData);
        barChart.invalidate();
    }
    /*
    添加数据
     */
    public BarData setData(){
        List<BarEntry> entries=new ArrayList<>();
        List<BarEntry> entries1=new ArrayList<>();
        entries.add(new BarEntry(1,20));
        entries.add(new BarEntry(3,30));
        entries.add(new BarEntry(5,50));
        entries.add(new BarEntry(7,70));
        entries.add(new BarEntry(9,80));

//        BarData barData=new BarData(barDataSet);

        entries1.add(new BarEntry(2,80));
        entries1.add(new BarEntry(4,70));
        entries1.add(new BarEntry(6,50));
        entries1.add(new BarEntry(8,30));
        entries1.add(new BarEntry(10,20));
//        一个DataSet对象代表Entry图表内属于在一起的一组条目
        //        一个DataSet对象代表Entry图表内属于在一起的一组条目
        BarDataSet barDataSet=new BarDataSet(entries,"数据");
        barDataSet.setColor(Color.rgb(255,0,0));

        BarDataSet barDataSet1=new BarDataSet(entries1,"数据1");
        barDataSet1.setColor(Color.rgb(0,255,0));

        List<IBarDataSet> dataSets=new ArrayList<>();
        dataSets.add(barDataSet);
        dataSets.add(barDataSet1);
        BarData bdata=new BarData(dataSets);
        barChart.setData(bdata);
//        data.setValueTextSize(10f);
//        data.setBarWidth(0.9f);
        return bdata;
    }
    /*
    初始化柱状图
     */
    public BarChart initBarChart(BarChart barChart){
        barChart.setDrawBarShadow(false);
        barChart.setDrawValueAboveBar(true);
        XAxis xAxis=barChart.getXAxis();
        YAxis yAxisleft=barChart.getAxisLeft();
        YAxis yAxisRight=barChart.getAxisRight();
        Barchart(xAxis,yAxisleft,yAxisRight);
        return barChart;
    }
    public void Barchart(XAxis xAxis,YAxis yAxisleft,YAxis yAxisright){
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(20f);
        xAxis.setTextColor(Color.RED);
        xAxis.setAxisLineWidth(1);
        xAxis.setAxisMinimum(0);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setEnabled(true);

        yAxisleft.setTextSize(20f);
        yAxisleft.setTextColor(Color.RED);
        yAxisleft.setGridLineWidth(1);
        yAxisleft.setAxisMinimum(0);
        yAxisleft.setDrawAxisLine(true);
        yAxisleft.setEnabled(true);

        yAxisright.setGridLineWidth(1);
        yAxisright.setAxisMinimum(0);
        yAxisright.setDrawAxisLine(true);
        yAxisright.setEnabled(false);
    }
}
