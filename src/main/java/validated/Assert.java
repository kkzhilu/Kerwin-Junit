package validated;


import error.GeneralError;
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
public abstract class Assert {

    public Assert() { }

    public static void state(boolean expression, String message) throws GeneralError {
        if (!expression) {
            throw new GeneralError(message);
        }
    }

    public static void isTrue(boolean expression, String message) throws GeneralError {
        state(expression, message);
    }

    public static void isNull( Object object, String message) throws GeneralError {
        if (object != null) {
            throw new GeneralError(message);
        }
    }

    public static void notNull( Object object, String message) throws GeneralError {
        if (object == null) {
            throw new GeneralError(message);
        }
    }

    public static void hasLength( String text, String message) throws GeneralError {
        if (StringUtils.isBlank(text)) {
            throw new GeneralError(message);
        }
    }

    public static void hasText( String text, String message) throws GeneralError {
        if (StringUtils.isBlank(text)) {
            throw new GeneralError(message);
        }
    }

    public static void notEmpty( Object[] array, String message) throws GeneralError {
        if (ObjectUtils.isEmpty(array)) {
            throw new GeneralError(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) throws GeneralError {
        if (collection == null || collection.size() <= 0) {
            throw new GeneralError(message);
        }
    }

    public static void notEmpty( Map<?, ?> map, String message) throws GeneralError {
        if (map == null || map.size() <= 0) {
            throw new GeneralError(message);
        }
    }

    private static boolean endsWithSeparator(String msg) {
        return msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith(".");
    }

    private static String messageWithTypeName(String msg, Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }
}
