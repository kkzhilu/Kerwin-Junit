package validated;


import exception.GeneralException;
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

    public static void state(boolean expression, String message) throws GeneralException {
        if (!expression) {
            throw new GeneralException(message);
        }
    }

    public static void isTrue(boolean expression, String message) throws GeneralException {
        state(expression, message);
    }

    public static void isNull( Object object, String message) throws GeneralException{
        if (object != null) {
            throw new GeneralException(message);
        }
    }

    public static void notNull( Object object, String message) throws GeneralException{
        if (object == null) {
            throw new GeneralException(message);
        }
    }

    public static void hasLength( String text, String message) throws GeneralException{
        if (StringUtils.isBlank(text)) {
            throw new GeneralException(message);
        }
    }

    public static void hasText( String text, String message) throws GeneralException{
        if (StringUtils.isBlank(text)) {
            throw new GeneralException(message);
        }
    }

    public static void notEmpty( Object[] array, String message) throws GeneralException {
        if (ObjectUtils.isEmpty(array)) {
            throw new GeneralException(message);
        }
    }

    public static void notEmpty(Collection<?> collection, String message) throws GeneralException {
        if (collection == null || collection.size() <= 0) {
            throw new GeneralException(message);
        }
    }

    public static void notEmpty( Map<?, ?> map, String message) throws GeneralException {
        if (map == null || map.size() <= 0) {
            throw new GeneralException(message);
        }
    }

    private static boolean endsWithSeparator(String msg) {
        return msg.endsWith(":") || msg.endsWith(";") || msg.endsWith(",") || msg.endsWith(".");
    }

    private static String messageWithTypeName(String msg, Object typeName) {
        return msg + (msg.endsWith(" ") ? "" : ": ") + typeName;
    }
}
