package com.jeo.customwidget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.jeo.widget.MyButton;
import com.jeo.widget.MyButtonItem;

/**
 * 作者：志文 on 2015/12/3 0003 17:47
 * 邮箱：594485991@qq.com
 */
public class CustomButtonActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_custom_button);

        MyButton myButton = (MyButton)findViewById(R.id.myButton);

        CustomButton btn = new CustomButton();
        btn.setTitle("你好");
        btn.setUrl("此处回调www.baidu.com,可以扩展做其他事情");

        //输入
        myButton.setButton(btn);
        //输出
        myButton.setDoubleClickListener(new MyButton.IMyButtonDoubleClickListener() {
            @Override
            public void onDoubleClick(MyButtonItem button) {
                if(button instanceof CustomButton){
                    CustomButton btn = (CustomButton) button;
                    Toast.makeText(getBaseContext(), btn.getUrl(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
