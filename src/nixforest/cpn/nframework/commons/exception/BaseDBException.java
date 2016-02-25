/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class BaseDBException extends SysException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 5309033875598075681L;

    public BaseDBException() {
        super();
    }
    public BaseDBException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
    public BaseDBException(String detailMessage) {
        super(detailMessage);
    }
    public BaseDBException(Throwable throwable) {
        super(throwable);
    }
}
