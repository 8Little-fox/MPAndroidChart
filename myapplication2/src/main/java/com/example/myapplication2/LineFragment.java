package com.example.myapplication2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LineFragment extends Fragment {
    private LineChart lineChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_line2, container, false);
        lineChart=view.findViewById(R.id.line);
        initData();
        return view;
    }
    public LineData initData(){
        List<Entry> entries=new ArrayList<>();
        entries.add(new Entry(2,100));
        entries.add(new Entry(6,300));
        entries.add(new Entry(7,500));
        LineDataSet set=new LineDataSet(entries,"温度");
        set.setColors(ColorTemplate.COLORFUL_COLORS);
        LineData lineData=new LineData(set);
        lineChart.setData(lineData);
        return lineData;
    }
}
