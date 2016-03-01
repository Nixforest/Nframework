/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

import nixforest.cpn.nframework.commons.exception.GenericException;

/**
 * System exception class.
 * @author Nixforest
 * @date Feb 15, 2016
 */
public class SysException extends GenericException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 999463009682851552L;

	/**
	 * Default constructor.
	 */
    public SysException() {
        super();
    }
	
	/**
	 * Constructor.
	 * @param detailMessage Message
	 * @param throwable Exception
	 */
    public SysException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
	
	/**
	 * Constructor.
	 * @param detailMessage Message
	 */
    public SysException(String detailMessage) {
        super(detailMessage);
    }
	
	/**
	 * Constructor.
	 * @param throwable Exception
	 */
    public SysException(Throwable throwable) {
        super(throwable);
    }
}
