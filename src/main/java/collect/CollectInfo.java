package collect;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/4 0:41
 * description:  CollectInfo 数据统计类
 * version:      V1.0
 * ******************************
 */
public class CollectInfo {

    /**
     * 执行成功的数量
     */
    private static final AtomicLong SUCCESS_COUNT = new AtomicLong(0);

    /**
     * 执行失败的数量
     */
    private static final AtomicLong FAIL_COUNT = new AtomicLong(0);

    /**
     * 执行过的方法，排除setUp和tearDown
     */
    private static final Map<String, Method> METHOD_MAP = new HashMap<>(64);

    /**
     * 所有可以执行的 class
     */
    private static final Map<String, Class> CLASS_MAP = new HashMap<>(64);

    public static long successCountIncrement() {
        return SUCCESS_COUNT.incrementAndGet();
    }

    public static long failCountIncrement() {
        return FAIL_COUNT.incrementAndGet();
    }

    public static void addMethod(String key, Method method) {
        METHOD_MAP.put(key, method);
    }

    public static void addClass(String key, Class clazz) {
        CLASS_MAP.put(key, clazz);
    }

    /***
     * 清理数据
     */
    public static void clear() {
        SUCCESS_COUNT.set(0L);
        FAIL_COUNT.set(0L);
        CLASS_MAP.clear();
        METHOD_MAP.clear();
    }

    /**
     * 收集信息打印
     */
    public static void print() {
        long totalMethod = SUCCESS_COUNT.get() + FAIL_COUNT.get();

        System.out.println("-------------------- TestCase result -------------------------");
        format("run test class total: ", CLASS_MAP.size());
        format("run test method total: ", totalMethod);
        format("run test success method total: ", SUCCESS_COUNT.get());
        format("run test fail method total: ", FAIL_COUNT.get());
        System.out.println("-------------------- TestCase result -------------------------");
    }

    private static void format(String title, Object msg) {
        System.out.printf("%-60s", title);
        System.out.print(msg + "\n");
    }
}
