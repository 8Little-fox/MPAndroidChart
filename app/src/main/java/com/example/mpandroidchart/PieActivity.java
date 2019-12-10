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

import java.util.ArrayList;
import java.util.List;

public class PieActivity extends AppCompatActivity {
    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        pieChart=findViewById(R.id.pie);
        PieData pieData=initPie();
        pieChart.setData(pieData);
        setPieChar();
    }
    /*
    设置饼图数据
     */
    public PieData initPie(){
        List<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(18f,"Green"));
        entries.add(new PieEntry(26.7f,"Yellow"));
        entries.add(new PieEntry(24.0f,"Red"));
        entries.add(new PieEntry(30.8f,"Blue"));

        List<Integer> colors=new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorPrimary));
        colors.add(getResources().getColor(R.color.yellow));
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.bule));
        PieDataSet set=new PieDataSet(entries,"Election Results");
        set.setColors(colors);
        //设置黄线
        set.setValueLinePart1OffsetPercentage(80f);
        set.setValueLinePart1Length(0.3f);
        set.setValueLinePart2Length(0.4f);
        set.setValueLineColor(Color.YELLOW);
        set.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data=new PieData(set);
        data.setValueFormatter(new PercentFormatter());//百分比
        data.setValueTextSize(20f);
        data.setValueTextColor(Color.DKGRAY);
        pieChart.setData(data);
        pieChart.invalidate();
        return data;
    }
    public void setPieChar(){
        /*
        去除右下角的 label
        .setHoleRadius 半径设置为0
        setTransparentCircleRadius 内圈半透明为0
         */
        Description description=new Description();
        description.setText("");
        pieChart.setDescription(description);
//        pieChart.setHoleRadius(0);
//        pieChart.setTransparentCircleRadius(0);
    }
}
