package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

public class PieActivity extends AppCompatActivity {
    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        pieChart=findViewById(R.id.Pie);
        PieData pieData=initData();
        pieChart.setData(pieData);
    }
    public PieData initData(){
        List<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(20f,"数据1"));
        entries.add(new PieEntry(40f,"数据2"));
        entries.add(new PieEntry(40f,"数据3"));

        List<Integer> colors=new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimaryDark));
        colors.add(getResources().getColor(R.color.colorPrimary));
        PieDataSet dataSet=new PieDataSet(entries,"");
        PieData pieData=new PieData(dataSet);
        dataSet.setColors(colors);
        dataSet.setValueTextSize(20f);
        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueFormatter(new PercentFormatter());
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);//连接线在图外
        dataSet.setValueLinePart1Length(0.3f);
        dataSet.setValueLinePart2Length(0.4f);
        dataSet.setValueLineWidth(2f);
        dataSet.setValueLineColor(Color.YELLOW);
        Description description=new Description();//改变Label的方法
        description.setText("");
        pieChart.setDescription(description);
        pieChart.setExtraOffsets(10,20,3,20);//饼图距左右的距离
        return pieData;
    }
}
