package cn.hz.iving.viewlibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import cn.hz.iving.java.ITestInterface;
import cn.hz.iving.java.Utils;

/***
 *  @date 2020/3/7
 * 自定义 ViewGroup
 * 此自定义ViewGroup 并带自定义参数
 *
 * 具体操作如下：
 * ①. 大致明确布局容器的需求，初步定义布局属性
 * ②. 继承LayoutParams，定义布局参数类
 * ③. 重写generateLayoutParams()
 * ④. 在布局文件中使用布局属性
 */
public class CustomViewGroupWithLayoutParamsLayoutDemoActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_custom_viewgroup_with_custom_layout_params);
        Log.d("test", ITestInterface.STRING_CONSTENT);

        ITestInterface testInterface = new ITestInterface(){

            @Override
            public void testMethodAccessAttribute() {
                StringBuilder sb= new StringBuilder();
                sb.append("testInterface--testMethodAccessAttribute")
                        .append("接口中的方法默认是public的");
                Log.d("test", sb.toString());
            }
        };
        testInterface.testMethodAccessAttribute();

        testShiftLeft();

    }

    private void testShiftLeft(){

        int intLength= Integer.SIZE;
        int mask=ITestInterface.MODE_MASK;
        int unspecified= ITestInterface.UNSPECIFIED;
        int exactly=ITestInterface.EXACTLY;
        int atMost=ITestInterface.AT_MOST;
        Utils.printIntBinaryInMemory(ITestInterface.MODE_SHIFT);
        Utils.printIntBinaryInMemory(ITestInterface.UNSPECIFIED);
        Utils.printIntBinaryInMemory(ITestInterface.EXACTLY);
        Utils.printIntBinaryInMemory(ITestInterface.AT_MOST);
        Utils.printIntBinaryInMemory(ITestInterface.MODE_MASK);
        Log.d("test","unspecified=" +unspecified);

    }



}
