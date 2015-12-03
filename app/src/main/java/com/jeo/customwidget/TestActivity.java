package com.jeo.customwidget;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 作者：志文 on 2015/12/3 0003 19:00
 * 邮箱：594485991@qq.com
 */
public class TestActivity extends Activity implements GestureDetector.OnGestureListener {
    private LinearLayout main;
    private TextView viewA;
    private GestureDetector gestureScanner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gestureScanner = new GestureDetector(this);
        gestureScanner.setOnDoubleTapListener(new GestureDetector.OnDoubleTapListener() {
            public boolean onDoubleTap(MotionEvent e) {
                viewA.setText("-" + "onDoubleTap" + "-");
                //双击时产生一次
                Log.v("test", "onDoubleTap");
                return false;
            }

            public boolean onDoubleTapEvent(MotionEvent e) {
                //双击时产生两次
                Log.v("test", "onDoubleTapEvent");
                return false;
            }

            public boolean onSingleTapConfirmed(MotionEvent e) {
                viewA.setText("-" + "onSingleTapConfirmed" + "-");
                //短快的点击算一次单击
                Log.v("test", "onSingleTapConfirmed");
                return false;
            }
        });


        main = new LinearLayout(this);
        main.setBackgroundColor(Color.GRAY);
        main.setLayoutParams(new LinearLayout.LayoutParams(320, 480));
        main.setOrientation(LinearLayout.VERTICAL);

        viewA = new TextView(this);
        viewA.setBackgroundColor(Color.YELLOW);
        viewA.setTextColor(Color.BLACK);
        viewA.setTextSize(16);
        viewA.setLayoutParams(new LinearLayout.LayoutParams(320, 50));
        main.addView(viewA);

        setContentView(main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        //viewA.setText("-" + "DOWN" + "-");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        //viewA.setText("-" + "FLING" + "- "+velocityX + "- "+velocityY);
        Log.v("test", "onFling " + e1.getX() + " " + e2.getX());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        //viewA.setText("-" + "LONG PRESS" + "-");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //viewA.setText("-" + "SCROLL" + "- "+distanceX + "- "+distanceY);
        Log.v("test", "onScroll " + e1.getX() + " " + e2.getX());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        //viewA.setText("-" + "SHOW PRESS" + "-");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Log.v("test", "onSingleTapUp");
        //viewA.setText("-" + "SINGLE TAP UP" + "-"+ i++);
        return true;
    }

}