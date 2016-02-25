/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class BaseConfigException extends GenericRuntimeException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -1930655047874224375L;

    public BaseConfigException() {
        super();
    }
    public BaseConfigException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
    public BaseConfigException(String detailMessage) {
        super(detailMessage);
    }
    public BaseConfigException(Throwable throwable) {
        super(throwable);
    }
}
