package com.example.myapplication2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StackingFragment extends Fragment {
    private BarChart stackingbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_stacking, container, false);
        stackingbar=view.findViewById(R.id.stacking);
        initData();
        return view;
    }
    public BarData initData(){
        List<BarEntry > entries=new ArrayList<>();
        entries.add(new BarEntry(3,new float[]{10,20}));
        entries.add(new BarEntry(4,new float[]{20,30}));
        entries.add(new BarEntry(5,new float[]{30,40}));
        BarDataSet set=new BarDataSet(entries,"京东");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        BarData data=new BarData(set);
        stackingbar.setData(data);
        stackingbar.invalidate();
        return data;
    }
}
