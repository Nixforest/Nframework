/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class BaseIOException extends SysException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 6135855308086817058L;

    public BaseIOException() {
        super();
    }
    public BaseIOException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
    public BaseIOException(String detailMessage) {
        super(detailMessage);
    }
    public BaseIOException(Throwable throwable) {
        super(throwable);
    }
}
