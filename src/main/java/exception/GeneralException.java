package exception;

import java.lang.reflect.InvocationTargetException;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/6/3 14:09
 * description:  GeneralException
 * version:      V1.0
 * ******************************
 */
public class GeneralException extends InvocationTargetException {

    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public GeneralException() { }

    public GeneralException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public GeneralException(Throwable target) {
        super(target);
    }

    public GeneralException(Throwable target, String s) {
        super(target, s);
    }
}
