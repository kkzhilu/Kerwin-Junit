package core;

import validated.Assert;

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

    public static void testClass(Class<? extends TestCase> aclass) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        // Begin To Test
        System.out.println(MessageFormat.format("Start to test class: {0} ...", aclass.getSimpleName()));
        print();

        // Build Method
        TestCase testCase = aclass.newInstance();
        Method setUp      =  aclass.getMethod(TestCase.SET_UP_METHOD_NAME);
        Method tearDown   = aclass.getMethod(TestCase.TEAR_DOWN_METHOD_NAME);

        // 预先执行方法
        setUp.invoke(testCase);

        Method[] methods = aclass.getDeclaredMethods();
        for (Method method : methods) {
            if (TestCase.assertMethod(method.getName())) {
                try {
                    method.invoke(testCase);
                    if(Assert.isPass()) {
                        System.out.println(MessageFormat.format("INFO: {0} is pass!", method.getName()));
                    } else {
                        System.out.println(MessageFormat.format("ERROR: {0} is no pass!", method.getName()));
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    System.out.println(MessageFormat.format("ERROR: {0} happen exception.", method.getName()));
                    e.printStackTrace();
                }
            }
        }

        // 结束执行方法
        tearDown.invoke(testCase);
        print();
    }

    private static void print() {
        System.out.println("------------------------------------------------");
    }
}
