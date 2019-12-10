# MPAndroidChart


#Grdle配置：
```
repositories {
   maven { url "https://jitpack.io" }
}
dependencies {
          implementation group: 'com.github.PhilJay', name: 'MPAndroidChart', version: 'v3.0.3'
}
```

* x轴轴线
```
xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); 设置x轴线位于底部
xAxis.setTextColor(Color.BLACK); 设置文本颜色
xAxis.setDrawGridLines(false); 不显示网格线
xAxis.setTextSize(10); 字体大小
xAxis.setAxisLineWidth(2); 线宽
xAxis.setGranularity(1); //数据的间隔
xAxis.setLabelCount(5,true);//坐标轴的数据有几个
xAxis.setEnabled(true); 是否显示线
```
#LineChart 线型图 布局:

```
 <com.github.mikephil.charting.charts.LineChart
        android:id="@+id/line"
        android:layout_width="match_parent"
        android:layout_height="400dp">
    </com.github.mikephil.charting.charts.LineChart>
```
#添加数据
```
public LineData initData(){
        List<Entry> entries=new ArrayList<>();
    
        entries.add(new Entry(3f,20));
    
        LineDataSet dataSet=new LineDataSet(entries,"数据一");
       
        LineData data=new LineData(dataSet);
        
        linechart.setData(data);
        
        return lineData;
    }
```
