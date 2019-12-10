package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;
public class lineActivity extends AppCompatActivity {
    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        lineChart=findViewById(R.id.line);
        LineData lineData=initData();
        lineChart.setData(lineData);
        setLinChar(lineChart);
        Mark m=new Mark(this);
        lineChart.setMarker(m);
        lineChart.invalidate();
    }
    //数据
    public LineData initData(){
        List<Entry> entries=new ArrayList<>();
        List<Entry> entries1=new ArrayList<>();
        entries.add(new Entry(3f,20));
        entries.add(new Entry(5f,25));
        entries.add(new Entry(6f,30));
        entries1.add(new Entry(5f,30));
        entries1.add(new Entry(6f,35));
        entries1.add(new Entry(7f,30));

        LineDataSet dataSet=new LineDataSet(entries,"数据一");
        LineDataSet dataSet1=new LineDataSet(entries1,"数据二");
        List<ILineDataSet> list=new ArrayList<>();
        list.add(dataSet);
        list.add(dataSet1);
        LineData lineData=new LineData(list);
        return lineData;
    }
    public void setLinChar(LineChart lineChart){
        XAxis xAxis= lineChart.getXAxis();
        YAxis yAxisLeft= lineChart.getAxisLeft();
        YAxis yAxisRight=lineChart.getAxisRight();
        line(xAxis,yAxisLeft,yAxisRight);
    }
    public void line(XAxis xAxis,YAxis yAxisLeft,YAxis yAxisRight){
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setEnabled(true);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setEnabled(true);
        yAxisRight.setEnabled(false);
    }
}
