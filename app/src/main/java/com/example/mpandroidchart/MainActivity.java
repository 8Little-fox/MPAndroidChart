package com.example.mpandroidchart;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity{
    private BarChart barChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        barChart=findViewById(R.id.bar);
        barChart=initBarChart(barChart); //初始化柱状图
        BarData barData=setBarData();//初始化模拟数据
        barChart.setData(barData);//将模拟数据用于柱状图，在柱状图显示
        barChart.invalidate();//填充数据后刷新
    }
    /*
    设置柱状图数据
     */
    public BarData setBarData(){
        List<BarEntry> entries=new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            entries.add(new BarEntry(i,new Random().nextInt(200)));
        }
        BarDataSet barDataSet=new BarDataSet(entries,"测试用数据");//设置数据集
        barDataSet.setColor(Color.rgb(255,0,0));
        List<IBarDataSet> dataSets=new ArrayList<>();
        dataSets.add(barDataSet);
        BarData barData=new BarData(dataSets);
        barData.setValueTextSize(10f);
        barData.setBarWidth(0.9f);
        return barData;//返回柱状图数据
    }
    /*
    初始化柱状图
    */
    public BarChart initBarChart(BarChart barChart){
        barChart.setDrawBarShadow(false); //每一条柱子阴影不显示
        barChart.setDrawValueAboveBar(true);//显示柱子数值
        XAxis xAxis=barChart.getXAxis();//获取x轴
        YAxis yAxisLeft=barChart.getAxisLeft();// 左侧y轴
        YAxis yAxisRight=barChart.getAxisRight();//右侧y轴
        setAxis(xAxis,yAxisLeft,yAxisRight); //调用方法设置柱状图轴线
        return barChart;//返回初始化的柱状图实例
    }
    /*
    设置x 轴 y轴
     */
    public  void setAxis(XAxis xAxis,YAxis yAxisLeft,YAxis yAxisRight){
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//底部显示
        xAxis.setAxisLineWidth(1); //x轴宽度
        xAxis.setAxisMinimum(0); //从0开始
        xAxis.setDrawAxisLine(true); //x轴显示轴线
        xAxis.setDrawGridLines(true); //不显示表格线
        xAxis.setEnabled(true); //x轴显示

        yAxisLeft.setAxisMinimum(0);
        yAxisLeft.setDrawGridLines(false);
        yAxisLeft.setDrawAxisLine(true);
        yAxisLeft.setAxisLineWidth(1);
        yAxisLeft.setEnabled(true);

        yAxisRight.setAxisMinimum(0);
        yAxisRight.setDrawGridLines(false);
        yAxisRight.setDrawAxisLine(true);
        yAxisRight.setAxisLineWidth(1);
        yAxisRight.setEnabled(false);

    }
}
