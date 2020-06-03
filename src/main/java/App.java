import core.TestCase;
import core.TestSuite;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

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
     * 第二版需求：
     * 1. 用户可以把多个TestCase添加到一个TestSuite中。
     * 2. 测试框架在运行结束以后，可以报告出，有那些测试用例成功，有哪些测试用例失败，对于失败的用例，报告出是Assert失败，还是出现了异常。
     */
    public static void main(String[] args) {
        System.out.println("Kerwin要搞定Junit!");

        // 扫描所有继承了TestCase的类
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(""))
                .filterInputsBy(input -> {
                    assert input != null;
                    return input.endsWith(".class");
                }));

        // Test集合类
        TestSuite testSuite = new TestSuite();

        Set<Class<? extends TestCase>> classes = reflections.getSubTypesOf(TestCase.class);
        for (Class<? extends TestCase> aclass : classes) {
            testSuite.addTestSuite(aclass);
        }

        // 测试
        testSuite.startToTest();
    }
}
