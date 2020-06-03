package core;

/**
 * ******************************
 * author：      柯贤铭
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

    /**
     * 是否执行方法
     */
    public static boolean assertMethod(String name) {
        boolean a = !SET_UP_METHOD_NAME.equals(name);
        boolean b = !TEAR_DOWN_METHOD_NAME.equals(name);
        return a && b && name.startsWith("test");
    }

    public static final String SET_UP_METHOD_NAME = "setUp";

    public static final String TEAR_DOWN_METHOD_NAME = "tearDown";
}
