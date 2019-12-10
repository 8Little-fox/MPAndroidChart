package com.example.myapplication2;


import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PieFragment extends Fragment {
    private PieChart pieChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_pie, container, false);
        pieChart=view.findViewById(R.id.pie);
        initData();
        return view;
    }
    /*
    数据
     */
    private PieData initData(){
        List<PieEntry> entries=new ArrayList<>();
        entries.add(new PieEntry(12.0f,"未违规"));
        entries.add(new PieEntry(88.0f,"违规"));

        List<Integer> colors=new ArrayList<>();
        colors.add(getResources().getColor(R.color.colorAccent));
        colors.add(getResources().getColor(R.color.colorPrimary));
        PieDataSet set=new PieDataSet(entries,"违规情况");
        set.setColors(colors);
        //设置黄线
        set.setValueLinePart1Length(80.0f);
        set.setValueLinePart1Length(0.3f);
        set.setValueLinePart2Length(0.4f);
        set.setValueLineColor(Color.YELLOW);
        set.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        set.setValueFormatter(new PercentFormatter());   //百分号
        PieData data=new PieData(set);
        pieChart.setDrawHoleEnabled(true);  //中心空洞

        pieChart.setData(data);
        //设置黄线
        Description description=new Description();
        description.setText("平台上有违规车辆和没违规车辆的统计");
        pieChart.setDescription(description);


        return data;
    }
}
