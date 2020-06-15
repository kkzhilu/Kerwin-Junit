package exception;

import java.text.MessageFormat;

/**
 * ******************************
 * author：      Kerwin
 * createTime:   2020/6/15 10:47
 * description:  断言异常
 * version:      V1.0
 * ******************************
 */
public class AssertException extends RuntimeException{

    public AssertException() { }

    public AssertException(String message) {
        super(MessageFormat.format("Assert:{0}", message));
    }

    public AssertException(String message, Throwable cause) {
        super(MessageFormat.format("Assert:{0}", message), cause);
    }
}
