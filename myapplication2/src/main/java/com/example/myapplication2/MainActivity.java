package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<Fragment> list=new ArrayList<>();
    private ChartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.vp);
        list.add(new PieFragment());
        list.add(new BarFragment());
        list.add(new LineFragment());
        list.add(new StackingFragment());
        list.add(new HorizontalFragment());
        list.add(new RadarFragment());
        adapter=new ChartAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
    }
}
