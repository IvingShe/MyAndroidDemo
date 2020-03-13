package cn.hz.iving.viewlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @date 2020/3/7
 * 第一个自定义ViewGroup demo; 用于简单演示自定义ViewGroup的使用
 *
 * 自定义ViewGroup操作
 * ①. 继承ViewGroup，覆盖构造方法
 * ②. 重写onMeasure方法测量子控件和自身宽高
 * ③. 实现onLayout方法摆放子控件
 *
 */
public class MyFirstCustomGroupDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView =inflater.inflate(R.layout.activity_my_first_custom_group_demo,null);

        setContentView(rootView);

    }

}
