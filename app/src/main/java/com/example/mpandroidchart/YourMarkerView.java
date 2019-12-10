package com.example.mpandroidchart;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;

public class YourMarkerView extends MarkerView {
    private static final int DEFUILT_INDICATOR_COLOR =0xffFF584f ;
    private ImageView imageView;
    private TextView textView;
    public YourMarkerView(Context context) {
        super(context,R.layout.mark_view);
        imageView=findViewById(R.id.img);
        textView=findViewById(R.id.tv);
    }
//每次重绘MarkerView时都会回调，可用于更新
//    //内容（用户界面）
    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        imageView.getResources();
        textView.setText(""+e.getX());
    }
    private MPPointF mOffset;

    @Override
    public MPPointF getOffset() {
        if (mOffset==null){
            mOffset=new MPPointF(-(getWidth()/2),-getHeight());
        }
        return super.getOffset();
    }
    @Override
    public void draw(Canvas canvas, float posX, float posY) {
        Paint bgPaint=new Paint();
        bgPaint.setStyle(Paint.Style.FILL);
        bgPaint.setAntiAlias(true);
        bgPaint.setColor(DEFUILT_INDICATOR_COLOR);

        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(DEFUILT_INDICATOR_COLOR);

        int saveId=canvas.save();
        draw(canvas);
        canvas.restoreToCount(saveId);

    }
}
