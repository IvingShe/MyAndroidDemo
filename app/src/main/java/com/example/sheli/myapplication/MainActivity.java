package com.example.sheli.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.demo.animation.AnimationTweenActivity;
import com.demo.animation.PropertyAnimationActivity;

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

    }
    public void onTest(View view){
        Intent intent = new Intent(this, AnimationTweenActivity.class);
        this.startActivity(intent);
    }
    public void onProperty(View view){
        Intent intent = new Intent(this, PropertyAnimationActivity.class);
        this.startActivity(intent);
    }



}
