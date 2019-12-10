package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class BarActivity extends AppCompatActivity {
    private BarChart barChart;
    protected String[] mMonths=new String[]{
      "1月","2月","3月","4月","5月"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart=findViewById(R.id.bar);
        BarData barData=initData();
        barChart.setData(barData);
        barData.setValueTextSize(20f);
        setBarChart(barChart);
        barChart.invalidate();
    }
    //数据
    public BarData initData() {
        List<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(1f,10));
        entries.add(new BarEntry(2f,20));
        entries.add(new BarEntry(3f,30));
        List<Integer> colors=new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimary));
        colors.add(getResources().getColor(R.color.colorPrimaryDark));
        BarDataSet barDataSet=new BarDataSet(entries,"柱形数据");
        barDataSet.setColors(colors);
        BarData barData=new BarData(barDataSet);
        return barData;
    }
    public void setBarChart(final BarChart barChart){
        XAxis xAxis= barChart.getXAxis();
//        xAxis.setValueFormatter(new ValueFormatter() {
//            @Override
//            public String getAxisLabel(float value, AxisBase axis) {
//                return String.valueOf((int)value).concat("月");
//            }
//        });
       xAxis.setValueFormatter(new ValueFormatter() {
           @Override
           public String getAxisLabel(float value, AxisBase axis) {
               return mMonths[(int) value% mMonths.length];
           }
       });
        YAxis yAxisLeft= barChart.getAxisLeft();
        YAxis yAxisRight= barChart.getAxisRight();
        Bar_chart(xAxis,yAxisLeft,yAxisRight);
    }
    public void Bar_chart(XAxis xAxis,YAxis yAxisLeft,YAxis yAxisRight){
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisLineWidth(3f);
        xAxis.setTextSize(15f);

        xAxis.setDrawGridLines(false);
//        xAxis.setAxisMinimum(0);
        xAxis.setEnabled(true);
        yAxisLeft.setTextSize(15f);
        yAxisLeft.setAxisLineWidth(3f);
        yAxisLeft.setAxisMinimum(0f);
        yAxisLeft.setEnabled(true);
        yAxisRight.setEnabled(false);
    }
}
