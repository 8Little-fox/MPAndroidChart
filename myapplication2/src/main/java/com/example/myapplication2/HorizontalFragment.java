package com.example.myapplication2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HorizontalFragment extends Fragment {
    private HorizontalBarChart horizontalBarChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_horizontal, container, false);
        horizontalBarChart=view.findViewById(R.id.Horizontal);
        initData();
        return view;
    }
    public BarData initData(){
        List<BarEntry> entries=new ArrayList<>();
        entries.add(new BarEntry(3,30));
        entries.add(new BarEntry(6,40));
        entries.add(new BarEntry(9,50));
        entries.add(new BarEntry(10,60));
        BarDataSet set=new BarDataSet(entries,"成本");
        set.setColors(ColorTemplate.MATERIAL_COLORS);
        BarData data=new BarData(set);
        horizontalBarChart.setData(data);
        horizontalBarChart.invalidate();
        return data;
    }
}
