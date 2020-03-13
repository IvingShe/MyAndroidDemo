package cn.hz.iving.viewlibrary;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
/***
 * ⑤. 在onMeasure和onLayout中使用布局参数
 */

public class CustomViewGroupLayoutWithCustomLayoutParams extends ViewGroup {
    private static final String TAG = "CustomLayoutParams";

    public CustomViewGroupLayoutWithCustomLayoutParams(Context context) {
        super(context);
    }

    public CustomViewGroupLayoutWithCustomLayoutParams(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomViewGroupLayoutWithCustomLayoutParams(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 要求所有的孩子测量自己的大小，然后根据这些孩子的大小完成自己的尺寸测量
     * SL:父控件(此例中为DcorView中contentView)告诉子控件(CustomViewGroupLayoutWithCustomLayoutParams)
     * 可获得的空间以及关于这个空间的约束条件
     */
    @SuppressLint("NewApi")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.d(TAG,"---onMeasure----");
        //获得此ViewGroup上级容器为其推荐的宽和高，以及计算模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        /**
         * SL:获取ViewGroup实际的高度和宽度
         */
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        StringBuilder sb= new StringBuilder();
        sb.append("onMeasure---widthMode=").append(widthMode)
                .append(",heightMode=").append(heightMode)
                .append(",sizeWidth=").append(sizeWidth)
                .append(",sizeHeight=").append(sizeHeight);
        Log.d(TAG,"---onMeasure----sb="+sb);
        int layoutWidth = 0;
        int layoutHeight = 0;
        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int cWidth = 0;
        int cHeight = 0;
        int count = getChildCount();

        if(widthMode == MeasureSpec. EXACTLY){
            //如果布局容器的宽度模式是确定的（具体的size或者match_parent），直接使用父窗体建议的宽度
            layoutWidth = sizeWidth;
        } else{
            //如果是未指定或者wrap_content，我们都按照包裹内容做，宽度方向上只需要拿到所有子控件中宽度做大的作为布局宽度
            for ( int i = 0; i < count; i++)  {
                View child = getChildAt(i);
                cWidth = child.getMeasuredWidth();
                //获取子控件最大宽度
                layoutWidth = cWidth > layoutWidth ? cWidth : layoutWidth;
            }
        }
        //高度很宽度处理思想一样
        if(heightMode == MeasureSpec. EXACTLY){
            layoutHeight = sizeHeight;
        } else{
            for ( int i = 0; i < count; i++)  {
                View child = getChildAt(i);
                cHeight = child.getMeasuredHeight();
                layoutHeight = cHeight > layoutHeight ? cHeight : layoutHeight;
            }
        }

        // 测量并保存layout的宽高
        setMeasuredDimension(layoutWidth, layoutHeight);

    }

    /**
     * 为所有的子控件摆放位置.
     * SL: 入参：(1)左上(left,top)，右下（right,bottom）;
     * （2） 入参的值均为相对于终端屏幕绝对位置的值
     * 特别说明：
     *  （1）a.通过 childview的getLayoutParams()方法，获取自定义布局（MyFirstCustomLayoutParams）
     *      b.在onLayout 参数中通过自定义布局参数MyFirstCustomLayoutParams属性值对子View进行设置；
     * （2）getWidth() 和getHeight()获取当前viewGroup(CustomViewLayout)的实际宽度与高度；
     *
     *
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.d(TAG,"---onLayout----");
        StringBuilder sb = new StringBuilder();
        sb.append("onLayout---").append(",left=").append(left)
                .append(",top=").append(top)
                .append(",right=").append(right)
                .append(",bottom=").append(bottom);
        Log.d(TAG,"---onLayout----sb="+sb);
        final int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        MyFirstCustomLayoutParams params = null;
        for ( int i = 0; i < count; i++) {
            View child = getChildAt(i);
            // 注意此处不能使用getWidth和getHeight，这两个方法必须在onLayout执行完，才能正确获取宽高
            childMeasureWidth = child.getMeasuredWidth();
            childMeasureHeight = child.getMeasuredHeight();
            /**SL：获取chlidView的自定义属性值 ***/
            params = (MyFirstCustomLayoutParams) child.getLayoutParams();
            switch (params.position) {
                case MyFirstCustomLayoutParams. POSITION_MIDDLE:    // 中间
                    left = (getWidth()-childMeasureWidth)/2;
                    top = (getHeight()-childMeasureHeight)/2;
                    break;
                case MyFirstCustomLayoutParams.POSITION_LEFT:      // 左上方
                    left = 0;
                    top = 0;
                    break;
                case MyFirstCustomLayoutParams.POSITION_RIGHT:     // 右上方
                    left = getWidth()-childMeasureWidth;
                    top = 0;
                    break;
                case MyFirstCustomLayoutParams.POSITION_BOTTOM:    // 左下角
                    left = 0;
                    top = getHeight()-childMeasureHeight;
                    break;
                case MyFirstCustomLayoutParams.POSITION_RIGHTANDBOTTOM:// 右下角
                    left = getWidth()-childMeasureWidth;
                    top = getHeight()-childMeasureHeight;
                    break;
                default:
                    break;
            }

            //SL:重要方法，确定子控件的位置，四个参数分别代表（左上右下）点的坐标值
            child.layout(left, top, left+childMeasureWidth, top+childMeasureHeight);
        }

    }

    /***
     *
     * ②. 定义布局参数类：继承LayoutParams，定义布局参数类 MyFirstCustomLayoutParams
     *
     * SL:获取自定义属性值；
     */
    public static class MyFirstCustomLayoutParams extends ViewGroup.MarginLayoutParams {

        public static final int POSITION_MIDDLE = 0; // 中间
        public static final int POSITION_LEFT = 1; // 左上方
        public static final int POSITION_RIGHT = 2; // 右上方
        public static final int POSITION_BOTTOM = 3; // 左下角
        public static final int POSITION_RIGHTANDBOTTOM = 4; // 右下角

        /**SL：自定义布局属性值*/
        public int position = POSITION_LEFT;  // 默认我们的位置就是

        /**
        generateLayoutParams (AttributeSet attrs)是在布局文件被填充为对象的时候调用的，
         这个方法是下面几个方法中最重要的，如果不重写它，我么布局文件中设置的布局参数都不能拿到
        */
        public MyFirstCustomLayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            Log.d(TAG,"MyFirstCustomLayoutParams--AttributeSet");
            /**
             * SL：获取自定义属性集（Attribute Set:名称为CustomLayoutParams，参见attr中定义declare-styleable定义）
            * */
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.CustomLayoutParams);
            //获取设置在子控件上的位置属性
            /**
             * SL：获取自定义参数布局类属性值
             * */
            position = a.getInt(R.styleable.CustomLayoutParams_layout_position, position);
            Log.d(TAG,"MyFirstCustomLayoutParams--AttributeSet:position="+position);
            a.recycle();
        }

        public MyFirstCustomLayoutParams(int width, int height) {
            super(width, height);
            Log.d(TAG,"MyFirstCustomLayoutParams-width-");
        }

        public MyFirstCustomLayoutParams(LayoutParams source) {
            super(source);
            Log.d(TAG,"MyFirstCustomLayoutParams-source-");
        }
    }

    /***
     * ③. 重写generateLayoutParams()     *
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        Log.d(TAG,"generateLayoutParams-AttributeSet-");
        return new MyFirstCustomLayoutParams(getContext(), attrs);

    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        Log.d(TAG,"generateDefaultLayoutParams-LayoutParams-");
        return new MyFirstCustomLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        Log.d(TAG,"generateDefaultLayoutParams--");
        return new MyFirstCustomLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof MyFirstCustomLayoutParams;
    }
    /**********③. 重写generateLayoutParams()  end***********/


}