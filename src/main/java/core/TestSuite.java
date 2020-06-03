package core;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/4 0:43
 * description:  TestCase 集合类
 * version:      V1.0
 * ******************************
 */
public class TestSuite {

    private final List<Class<? extends TestCase>> CASE_LIST = new ArrayList<>();

    public void addTestSuite(Class<? extends TestCase> aclass) {
        CASE_LIST.add(aclass);
    }

    public void startToTest() {
        try {
            for (Class<? extends TestCase> aClass : CASE_LIST) {
                TestCoreMethod.testClass(aClass);
            }
        } catch (InvocationTargetException | IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
