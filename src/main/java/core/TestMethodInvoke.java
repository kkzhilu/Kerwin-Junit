package core;

import collect.CollectInfo;

import java.lang.reflect.Method;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/15 16:12
 * description:  TestMethodInvoke 方法执行类
 * version:      V1.0
 * ******************************
 */
public class TestMethodInvoke {

    /***
     * 反射执行类
     * @param method       方法
     * @param newInstance  反射对象
     */
    public static void invoke(Method method, Object newInstance) {
        CollectInfo.addMethod(method.getName(), method);
        try {
            method.invoke(newInstance);
            CollectInfo.successCountIncrement();
        } catch (Exception e) {
            CollectInfo.failCountIncrement();
            System.out.println("方法调用异常：" + method.getDeclaringClass().getName()+"#"+method.getName());
            e.printStackTrace();
        }
    }
}
