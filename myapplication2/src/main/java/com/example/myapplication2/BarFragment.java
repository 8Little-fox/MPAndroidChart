package com.example.myapplication2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BarFragment extends Fragment {
    private BarChart barChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_line, container, false);
        barChart=view.findViewById(R.id.barChart);
        barChart= setAxis(barChart);
        barChart.invalidate();
        initData();
        return view;
    }
    public BarData initData(){
        List<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(1f,1000f));
        entries.add(new BarEntry(4f,1100f));
        entries.add(new BarEntry(7f,1500f));

        List<BarEntry> entries1=new ArrayList<>();
        entries1.add(new BarEntry(2f,2000f));
        entries1.add(new BarEntry(5f,2100f));
        entries1.add(new BarEntry(8f,2400f));

        List<BarEntry> entries2=new ArrayList<>();
        entries2.add(new BarEntry(3f,3000f));
        entries2.add(new BarEntry(6f,3100f));
        entries2.add(new BarEntry(9f,3500f));

        BarDataSet set=new BarDataSet(entries,"保养支出");
        BarDataSet set1=new BarDataSet(entries1,"维修支出");
        BarDataSet set2=new BarDataSet(entries2,"保险支出");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set1.setColors(ColorTemplate.JOYFUL_COLORS);
        set2.setColors(ColorTemplate.JOYFUL_COLORS);
        List<IBarDataSet> list=new ArrayList<>();
        list.add(set);
        list.add(set1);
        list.add(set2);

        BarData data=new BarData(list);
        barChart.setData(data);
        return data;
    }

    public BarChart setAxis(BarChart barChart){
        XAxis xAxis=barChart.getXAxis();
        YAxis yAxisLeft=barChart.getAxisLeft();
        YAxis yAxisLeftRight=barChart.getAxisRight();
        getAxis(xAxis,yAxisLeft,yAxisLeftRight);
        return barChart;
    }
    public void getAxis(XAxis xAxis,YAxis yAxisLeft,YAxis yAxisLeftRight){
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setEnabled(true);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawAxisLine(true);
        yAxisLeft.setEnabled(true);
        yAxisLeftRight.setEnabled(false);

    }
}
