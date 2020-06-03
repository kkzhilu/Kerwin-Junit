package error;

/**
 * ******************************
 * author：      柯贤铭
 * createTime:   2020/6/3 14:09
 * description:  GeneralError
 * version:      V1.0
 * ******************************
 */
public class GeneralError extends Error {

    public GeneralError() {
    }

    public GeneralError(String message) {
        super(message);
    }

    public GeneralError(String message, Throwable cause) {
        super(message, cause);
    }

    public GeneralError(Throwable cause) {
        super(cause);
    }

    public GeneralError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
