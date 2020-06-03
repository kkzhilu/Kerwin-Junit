package validated;


import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/6/3 14:09
 * description:  Assert 断言
 * version:      V1.0
 * ******************************
 */
public class Assert {

    public Assert() { }

    private static boolean FLAG = false;

    private static void init() {
        FLAG = false;
    }

    private static void happenError() {
        FLAG = true;
    }

    public static boolean isPass() {
        return !FLAG;
    }

    public static void state(boolean expression, String message) {
        init();
        if (!expression) {
            happenError();
        }
    }

    public static void isTrue(boolean expression, String message) {
        state(expression, message);
    }

    public static void isNull( Object object, String message) {
        init();
        if (object != null) {
            happenError();
        }
    }

    public static void notNull( Object object, String message) {
        init();
        if (object == null) {
            happenError();
        }
    }

    public static void hasLength( String text, String message) {
        init();
        if (StringUtils.isBlank(text)) {
            happenError();
        }
    }

    public static void hasText( String text, String message) {
        init();
        if (StringUtils.isBlank(text)) {
            happenError();
        }
    }

    public static void notEmpty( Object[] array, String message) {
        init();
        if (ObjectUtils.isEmpty(array)) {
            happenError();
        }
    }

    public static void notEmpty(Collection<?> collection, String message) {
        init();
        if (collection == null || collection.size() <= 0) {
            happenError();
        }
    }

    public static void notEmpty( Map<?, ?> map, String message)  {
        init();
        if (map == null || map.size() <= 0) {
            happenError();
        }
    }
}
