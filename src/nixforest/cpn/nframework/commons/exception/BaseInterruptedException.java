/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class BaseInterruptedException extends GenericRuntimeException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -8784893435948012462L;

    public BaseInterruptedException() {
        super();
    }
    public BaseInterruptedException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
    public BaseInterruptedException(String detailMessage) {
        super(detailMessage);
    }
    public BaseInterruptedException(Throwable throwable) {
        super(throwable);
    }
}
