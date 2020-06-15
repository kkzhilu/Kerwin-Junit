package core;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/3 14:16
 * description:  TestCase 核心类
 * version:      V1.0
 * ******************************
 */
public abstract class TestCase {

    /***
     * Set Up 初始化方法
     */
    public abstract void setUp();

    /***
     * Tear Down 结束方法
     */
    public abstract void tearDown();

    public static final String SET_UP_METHOD_NAME = "setUp";

    public static final String TEAR_DOWN_METHOD_NAME = "tearDown";
}
