package com.example.myapplication2;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class RadarFragment extends Fragment {
    private RadarChart radarChart;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_radar, container, false);
        radarChart=view.findViewById(R.id.Radar);
        initData();
        return view;
    }
    public RadarData initData(){
        //x轴数据
//        final List<String> xdata=new ArrayList<>();
//        xdata.add("1");
//        xdata.add("2");
//        xdata.add("3");
//        xdata.add("4");
//        xdata.add("5");
       // return xdata.get((int)value % xdata.size());
        XAxis xAxis=radarChart.getXAxis();
        final String[] x=new String[]{"团队","贡献","对外","质量","数量"};
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return x[(int) value];
            }
        });
        YAxis yAxis=radarChart.getYAxis();
        yAxis.setAxisMinimum(0f);
        yAxis.setLabelCount(5,false);// Y坐标值标签个数
        yAxis.setEnabled(false);

        List<RadarEntry> entries=new ArrayList<>();
        entries.add(new RadarEntry(12));
        entries.add(new RadarEntry(9));
        entries.add(new RadarEntry(11));
        entries.add(new RadarEntry(16));
        entries.add(new RadarEntry(10));
        RadarDataSet set=new RadarDataSet(entries,"研发成本");
        set.setColors(ColorTemplate.JOYFUL_COLORS);
        set.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);     //实心填充区域颜色
        set.setDrawFilled(true);    //是否实心填充
        RadarData data=new RadarData(set);
        radarChart.setData(data);
        radarChart.invalidate();
        return data;
    }
}
