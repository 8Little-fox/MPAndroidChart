package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class lineActivity extends AppCompatActivity {
    private LineChart lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        lineChart=findViewById(R.id.line);
        /*
        创建描述信息
        -setDescription 设置图标描述信息
        -setDrawBorders(false); 禁止描绘图标边框的线

         */
//        Description description=new Description();
//        description.setText("测试图表");
//        description.setTextColor(Color.RED);
//        description.setTextSize(20);
//        lineChart.setDescription(description);
        lineChart.setDrawBorders(false);
        LineData Data=setlineData();
        lineChart.setData(Data);
        lineChart.invalidate();
    }
    public LineData setlineData(){
        List<Entry> entries=new ArrayList<>();
        List<Entry> entries1=new ArrayList<>();
        entries.add(new Entry(1,10));
        entries.add(new Entry(2,20));
        entries.add(new Entry(3,30));
        entries.add(new Entry(4,40));

        entries1.add(new Entry(4,10));
        entries1.add(new Entry(3,20));
        entries1.add(new Entry(2,30));
        entries1.add(new Entry(1,40));
        /*
        每一个对象就是一条连接线
         */
        LineDataSet set;
        LineDataSet set1;
        /*
        获取数据
         */
        set= (LineDataSet) lineChart.getLineData().getDataSetByIndex(0);
        set.setValues(entries);
        set1= (LineDataSet)lineChart.getLineData().getDataSetByIndex(1);
        set1.setValues(entries1);
        /*
        刷新数据
        setCircleRadius(3f);圆点大小
        enableDashedHighlightLine 点击后的高亮线的显示样式
         */
        lineChart.getData().notifyDataChanged();
        lineChart.notifyDataSetChanged();
        set=new LineDataSet(entries,"数据1");
        set.setColor(Color.BLACK);
        set.setLineWidth(1f);
        set.setCircleRadius(3f);
        set.enableDashedHighlightLine(10f,5f,0f);
        set.setValueTextSize(9f);

        set1=new LineDataSet(entries,"数据2");
        set1.setColor(Color.GRAY);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setValueTextSize(9f);

        /*
        保存 lineDataSet集合
         */
        List<ILineDataSet> dataSets=new ArrayList<>();
        dataSets.add(set);
        dataSets.add(set1);
         /*
         创建 LineData 对象属于LineChart折线图的数据集合
          */
         LineData data=new LineData(dataSets);
         return data;
    }
}
