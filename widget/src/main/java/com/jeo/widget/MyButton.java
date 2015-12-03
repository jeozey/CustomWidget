package com.jeo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * 作者：志文 on 2015/12/3 0003 17:41
 * 邮箱：594485991@qq.com
 */
public class MyButton extends TextView implements View.OnTouchListener {
    private static final String TAG = MyButton.class.getName();
    private MyButtonItem button;

    private LearnGestureListener learnGestureListener;
    private GestureDetector gestureDetector;

    public void setButton(MyButtonItem button) {
        this.button = button;
        if (button != null) {
            setText(button.getTitle());
        }
    }

    private IMyButtonDoubleClickListener listener;

    public void setDoubleClickListener(IMyButtonDoubleClickListener listener) {
        this.listener = listener;
        if (listener != null) {
            gestureDetector = new GestureDetector(getContext(), new LearnGestureListener());
            setOnTouchListener(this);
        }
    }

    public interface IMyButtonDoubleClickListener {
        void onDoubleClick(MyButtonItem button);
    }

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public class LearnGestureListener extends GestureDetector.SimpleOnGestureListener {


        @Override
        public boolean onDown(MotionEvent e) {
            Log.e("test", "onDown");
            return true;
        }


        @Override
        public boolean onDoubleTap(MotionEvent e) {
            Log.e("test", "onDoubleTap");
            if (listener != null) {
                listener.onDoubleClick(button);
            }
            return true;
        }

        int i = 0;
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            if(MotionEvent.ACTION_DOWN==e.getAction()){
                Log.e(TAG, "onDoubleTapEvent down");
                setBackgroundColor(0xFFFF0000);
            }else{
                Log.e(TAG, "onDoubleTapEvent up");
                setBackgroundColor(0xFF00FF00);
            }

            return true;
        }
    }
}
