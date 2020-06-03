import core.TestCase;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import validated.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Set;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/1 16:15
 * description:  AppInfo
 * version:      V1.0
 * ******************************
 */
public class App {

    /***
     * Junit框架设计要求：
     * https://note.youdao.com/ynoteshare1/index.html?id=7656002faf01ecfbdb9440599b3517f2&type=note
     *
     * 第一版需求：
     * 1.  用户可以通过继承TestCase类 来创建一个测试用例。
     * 2.  框架能自动寻找测试用例中以test为开头的方法，调用执行。
     * 3.  支持setUp, tearDown方法
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("Kerwin要搞定Junit!");

        // 扫描所有继承了TestCase的类
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(""))
                .filterInputsBy(input -> {
                    assert input != null;
                    return input.endsWith(".class");
                }));

        Set<Class<? extends TestCase>> classes = reflections.getSubTypesOf(TestCase.class);
        for (Class<? extends TestCase> aclass : classes) {

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
    }

    private static void print() {
        System.out.println("------------------------------------------------");
    }
}
