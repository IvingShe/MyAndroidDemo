package com.demo.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sheli.myapplication.R;


public class PropertyAnimationActivity extends Activity {

    private ImageView mImageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_animation_property_layout);
        mImageView= this.findViewById(R.id.iv);

        mImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(PropertyAnimationActivity.this,"onclick",Toast.LENGTH_LONG).show();
            }
        });
    }


    public void onAlpha(View view){
        Log.d("iving","onAlpha");
//        AlphaAnimation aa = new AlphaAnimation(0.1f,0.6f);
////
////        aa.setRepeatCount(2);//repeat twices ,and playing three times totally
////        aa.setDuration(2*1000);
////        aa.setRepeatMode(AlphaAnimation.REVERSE);
////        aa.setFillAfter(true);//the state of animation end
////        //aa.setFillBefore(true);
////        mImageView.startAnimation(aa);

        //target:set the animation object
        //property animation name;
        //
        ObjectAnimator objectAnimator = new ObjectAnimator().ofFloat(mImageView,
                "alpha",0,0.8f);
        objectAnimator.setDuration(2*1000);
        objectAnimator.setRepeatCount(2);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();

    }
//
//

    /***
     * 通过 onCLick事件可知：属性动画移动的是控件本身；而补间动画移动的是控件的背景图片。
     * @param view
     */
        public void onTranslate(View view){

           ObjectAnimator objectAnimator = new ObjectAnimator().ofFloat(mImageView,"translationX",0,200f);

            objectAnimator.setDuration(2*1000);
            objectAnimator.setRepeatCount(2);
            objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
            objectAnimator.start();


//            TranslateAnimation ta= new TranslateAnimation(0,200f,0,300f);
//            ta.setDuration(2*1000);
//            ta.setRepeatCount(2);
//            ta.setRepeatMode(Animation.RESTART);
//            ta.setFillAfter(true);
//            mImageView.startAnimation(ta);
  }
//
//    public void onScale(View view){
//        Log.d("iving","onScale");
//        ScaleAnimation sa = new ScaleAnimation(1,2,1,3);
//        sa.setDuration(2*1000);
//        sa.setRepeatCount(2);
//        mImageView.startAnimation(sa);
//    }
//
//
//    public void onRotate(View view){
//        Log.d("iving","onRotate");
//        //RotateAnimation ra = new RotateAnimation(0,180);
//        RotateAnimation ra = new RotateAnimation(0,180,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(2*1000);
//        ra.setRepeatCount(2);
//        ra.setRepeatMode(Animation.REVERSE);
//        mImageView.startAnimation(ra);
//    }
//
//    public void onSet(View view){
//        Log.d("iving","onSet");
//        AnimationSet set = new AnimationSet(true);
//        ScaleAnimation sa = new ScaleAnimation(1,2,1,3,
//                Animation.RELATIVE_TO_SELF,0.5f,
//                Animation.RELATIVE_TO_SELF,0.5f);
//        RotateAnimation ra = new RotateAnimation(0,180,
//                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//
//        set.addAnimation(sa);
//        set.addAnimation(ra);
//
//        set.setDuration(2*1000);
//        set.setFillAfter(true);
//        mImageView.startAnimation(set);
//
//    }
}
