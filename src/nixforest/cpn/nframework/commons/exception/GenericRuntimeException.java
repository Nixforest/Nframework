/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * Generic runtime exception
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class GenericRuntimeException extends RuntimeException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -4174459480478920576L;

	/**
	 * Default constructor.
	 */
    public GenericRuntimeException() {
        super();
    }
    public GenericRuntimeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
    public GenericRuntimeException(String detailMessage) {
        super(detailMessage);
    }
    public GenericRuntimeException(Throwable throwable) {
        super(throwable);
    }
}
