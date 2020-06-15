package validated;


import exception.AssertException;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Collection;
import java.util.Map;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/3 14:09
 * description:  Assert 断言
 * version:      V1.0
 * ******************************
 */
public class Assert {

    public Assert() { }

    public static void state(boolean expression, String message) {
        if (!expression) {
            throw new AssertException(msgBuilder(expression, !expression));
        }
    }

    public static void isTrue(boolean expression, String message) {
        state(expression, message);
    }

    public static void notNull( Object object, String message) {
        if (object == null) {
            throw new AssertException(msgBuilder("not null", "null"));
        }
    }

    public static void notEmpty( Object[] array, String message) {
        if (ObjectUtils.isEmpty(array)) {
            throw new AssertException(msgBuilder("not empty", "empty"));
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        if (collection == null || collection.size() <= 0) {
            throw new AssertException(msgBuilder("not empty", "empty"));
        }
    }

    public static void notEmpty( Map<?, ?> map, String message)  {
        if (map == null || map.size() <= 0) {
            throw new AssertException(msgBuilder("not empty", "empty"));
        }
    }

    private static String msgBuilder(Object expect, Object result) {
        return String.format("expect is %s, result is %s", expect, result);
    }

    private static void exception(String msg) {
        throw new AssertException("TestCase Exception: " + msg);
    }
}
