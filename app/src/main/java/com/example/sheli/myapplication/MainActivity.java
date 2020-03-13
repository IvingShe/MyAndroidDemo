package com.example.sheli.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.demo.animation.AnimationTweenActivity;
import com.demo.animation.PropertyAnimationActivity;

import cn.hz.iving.viewlibrary.CustomViewGroupWithLayoutParamsLayoutDemoActivity;
import cn.hz.iving.viewlibrary.MyFirstCustomGroupDemoActivity;

public class MainActivity extends AppCompatActivity {
    /***
     *
     * @param savedInstanceState
     */
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test(9,1,2,1,2,2,48,5 ,65);
    }

    private void test(int max,int... args){
       int size = args.length;
        Log.d("iving","siz="+size);
       for(int i:args){
           if(i>max){
               max=i;
           }
       }
       Log.d("iving","max="+max);

    }

    public void onTest(View view){
        Intent intent = new Intent(this, AnimationTweenActivity.class);
        this.startActivity(intent);
    }


    public void onProperty(View view){
        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        this.startActivity(intent);
    }


    public void onCustomViewGroup(View view){
        Intent intent = new Intent(this, MyFirstCustomGroupDemoActivity.class);
        this.startActivity(intent);
    }

    public void onCustomViewGroupWtihCustomLayoutParams(View view){
        Intent intent = new Intent(this, CustomViewGroupWithLayoutParamsLayoutDemoActivity.class);
        this.startActivity(intent);
    }


}
