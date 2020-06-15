package core;

import anotation.Test;
import collect.CollectInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/4 0:41
 * description:  TestCoreMethod
 * version:      V1.0
 * ******************************
 */
public class TestCoreMethod {

    public static void startTest(Class<? extends TestCase> aclass) throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        // Begin To Test
        CollectInfo.addClass(aclass.getName(), aclass);
        System.out.println(MessageFormat.format("Start to test class: {0} ...", aclass.getSimpleName()));

        // Build newInstance
        TestCase testCase = aclass.newInstance();

        // 预先执行方法
        methodInvoke(testCase, aclass.getMethod(TestCase.SET_UP_METHOD_NAME));

        Method[] methods = aclass.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Test.class)) {
                TestMethodInvoke.invoke(method, testCase);
            }
        }

        // 结束执行方法
        methodInvoke(testCase, aclass.getMethod(TestCase.TEAR_DOWN_METHOD_NAME));
    }

    /***
     * 初始化及清理方法
     */
    private static void methodInvoke(TestCase testCase, Method method) {
        try {
            method.invoke(testCase);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("方法调用异常：" + method.getDeclaringClass().getName()+"#"+method.getName());
            e.printStackTrace();
        }
    }
}
