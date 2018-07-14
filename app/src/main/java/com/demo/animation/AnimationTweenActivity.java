package com.demo.animation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.sheli.myapplication.R;


/**
 * 2018.7.10
 */

public class AnimationTweenActivity extends Activity {

    private ImageView mImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_animation_tween_layout);
        mImageView= this.findViewById(R.id.iv);
    }


    public void onAlpha(View view){
        Log.d("iving","onAlpha");
        AlphaAnimation aa = new AlphaAnimation(0.1f,0.6f);

        aa.setRepeatCount(2);//repeat twices ,and playing three times totally
        aa.setDuration(2*1000);
        aa.setRepeatMode(AlphaAnimation.REVERSE);
        aa.setFillAfter(true);//the state of animation end
        //aa.setFillBefore(true);
        mImageView.startAnimation(aa);
    }


    public void onTranslate(View view){
        Log.d("iving","onTranslate");
        //TranslateAnimation ta= new TranslateAnimation(0,100f,0,300f);
        TranslateAnimation ta=new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,0,
                TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
                TranslateAnimation.RELATIVE_TO_PARENT,0,
                TranslateAnimation.RELATIVE_TO_PARENT,0f);
        ta.setDuration(2*1000);
        ta.setRepeatCount(2);
        ta.setRepeatMode(Animation.RESTART);
        ta.setFillAfter(false);
        mImageView.startAnimation(ta);
    }

    public void onScale(View view){
        Log.d("iving","onScale");
        ScaleAnimation sa = new ScaleAnimation(1,2,1,3);
        sa.setDuration(2*1000);
        sa.setRepeatCount(2);
        mImageView.startAnimation(sa);
    }


    public void onRotate(View view){
        Log.d("iving","onRotate");
        //RotateAnimation ra = new RotateAnimation(0,180);
        RotateAnimation ra = new RotateAnimation(0,180,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(2*1000);
        ra.setRepeatCount(2);
        ra.setRepeatMode(Animation.REVERSE);
        mImageView.startAnimation(ra);
    }

    public void onSet(View view){
        Log.d("iving","onSet");
        AnimationSet set = new AnimationSet(true);
        ScaleAnimation sa = new ScaleAnimation(1,2,1,3,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation ra = new RotateAnimation(0,180,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);

        set.addAnimation(sa);
        set.addAnimation(ra);

        set.setDuration(2*1000);
        set.setFillAfter(true);
        mImageView.startAnimation(set);

    }
}
