package core;

import collect.CollectInfo;

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

    public TestSuite() {}

    public TestSuite(Class<? extends TestCase> testCase) {
        addTestSuite(testCase);
    }

    private final List<Class<? extends TestCase>> CASE_LIST = new ArrayList<>();

    public void addTestSuite(Class<? extends TestCase> aclass) {
        CASE_LIST.add(aclass);
    }

    public void run() {
        try {
            CollectInfo.clear();
            for (Class<? extends TestCase> aClass : CASE_LIST) {
                TestCoreMethod.startTest(aClass);
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            CollectInfo.print();
        }
    }
}
