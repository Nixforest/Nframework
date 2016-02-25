/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * Basic communication exception.
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class BaseComException extends SysException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -7239230139664291291L;

    public BaseComException() {
        super();
    }
    public BaseComException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
    public BaseComException(String detailMessage) {
        super(detailMessage);
    }
    public BaseComException(Throwable throwable) {
        super(throwable);
    }
}
