package com.jeo.customwidget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jeo.widget.SlideItem;
import com.jeo.widget.SlideTitle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<SlideItem> list = new ArrayList<>();
        CustomBtn btn = new CustomBtn();
        btn.setName("张三");
        btn.setEvent("Hello 张三");
        list.add(btn);

        btn = new CustomBtn();
        btn.setName("李四");
        btn.setEvent("Hello 李四");
        btn.setIsCheck(true);
        list.add(btn);

        btn = new CustomBtn();
        btn.setName("王五");
        btn.setEvent("Hello 王五");
        list.add(btn);

        SlideTitle slideTitle = (SlideTitle)findViewById(R.id.slideTitle);
        // 标题点击监听
        slideTitle
                .setSlideTitleOnClickListener(new SlideTitle.SlideTitleOnClickListener() {
                    @Override
                    public void slideTitleOnClick(SlideItem item) {
                        if (item instanceof CustomBtn){
                            CustomBtn btn = (CustomBtn)item;
                            Toast.makeText(getBaseContext(), btn.getEvent(),1).show();
                        }

                    }
                });
        slideTitle.setMidChildTitleFlow(list);
    }
}
