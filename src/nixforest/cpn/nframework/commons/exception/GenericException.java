/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

/**
 * General exception class.
 * @author Nixforest
 * @date Feb 15, 2016
 */
public class GenericException extends Exception {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 8085247660360617625L;
	
	/**
	 * Default constructor.
	 */
	public GenericException() {
        super();
    }
	
	/**
	 * Constructor.
	 * @param detailMessage Message
	 * @param throwable Exception
	 */
	public GenericException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
	
	/**
	 * Constructor.
	 * @param detailMessage Message
	 */
    public GenericException(String detailMessage) {
        super(detailMessage);
    }
	
	/**
	 * Constructor.
	 * @param throwable Exception
	 */
	public GenericException(Throwable throwable) {
        super(throwable);
    }
}
