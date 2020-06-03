import core.TestCase;
import error.GeneralError;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

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
    public static void main(String[] args) throws GeneralError {
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

            System.out.println(MessageFormat.format("Start to test class: {0} ...", aclass.getSimpleName()));
            Method method = null;
            try {
                TestCase testCase = aclass.newInstance();

                Method setUp    =  aclass.getMethod(TestCase.SET_UP_METHOD_NAME);
                Method tearDown = aclass.getMethod(TestCase.TEAR_DOWN_METHOD_NAME);

                // 预先执行方法
                method = setUp;
                method.invoke(testCase);

                Method[] methods = aclass.getDeclaredMethods();
                for (Method m : methods) {
                    method = m;
                    if (TestCase.assertMethod(method.getName())) {
                        method.invoke(testCase);
                        System.out.println(MessageFormat.format("INFO: {0} is pass!", method.getName()));
                    }
                }

                // 结束执行方法
                method = tearDown;
                method.invoke(testCase);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
