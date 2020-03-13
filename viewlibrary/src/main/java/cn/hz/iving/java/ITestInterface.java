package cn.hz.iving.java;

public interface ITestInterface {
    /**
     * 接口中的变量是public static final 的
     */
    String STRING_CONSTENT="test constant";
    /**
     * 接口中的方法默认是public的
     */
    void testMethodAccessAttribute();


     int MODE_SHIFT = 30;
    int MODE_MASK = 0x3 << MODE_SHIFT;
    /**
     * 父控件不强加任何约束给子控件，它可以是它想要任何大小
     */
   int UNSPECIFIED = 0 << MODE_SHIFT;
    /**
     * 父控件已为子控件确定了一个确切的大小，孩子将被给予这些界限，不管子控件自己希望的是多大
     */
    int EXACTLY = 1 << MODE_SHIFT;
    /**
     * 父控件会给子控件尽可能大的尺寸
     */
    int AT_MOST = 2 << MODE_SHIFT;

}
