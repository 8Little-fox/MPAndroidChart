package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class Pie1Activity extends AppCompatActivity {
    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar1);
        pieChart=findViewById(R.id.pie1);
        PieData pieData=setpieData();
        pieChart.setData(pieData);
    }
    public PieData setpieData(){
        List<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(50f,"colorAccent"));
        entries.add(new PieEntry(30f,"plue"));

        List<Integer> colors=new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.bule));

        PieDataSet dataSet=new PieDataSet(entries,"数据");
        dataSet.setColors(colors);//将颜色传进PieDataSet中

        dataSet.setValueLinePart1OffsetPercentage(80.f);//设置黄线
        dataSet.setValueLinePart1Length(0.3f);
        dataSet.setValueLinePart2Length(0.4f);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setValueTextSize(10f);


        PieData pieData=new PieData(dataSet);
        pieData.setValueFormatter(new PercentFormatter());//百分号
        Description description=new Description();//取消右下角文字
        description.setText("");
        pieChart.setUsePercentValues(true);

        pieChart.setDescription(description);
        pieChart.invalidate();
        return pieData;
    }
}
