/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.exception;

import nixforest.cpn.nframework.commons.entity.ErrorEntity;
import nixforest.cpn.nframework.commons.exception.GenericException;

/**
 * Application exception class.
 * @author Nixforest
 * @date Feb 15, 2016
 */
public class AppException extends GenericException {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 3848605776768399196L;
	/**
	 * Error entity.
	 */
	private ErrorEntity mErrorEntity;
	
	/**
	 * Default constructor.
	 */
	public AppException() {
        super();
    }
	
	/**
	 * Constructor.
	 * @param detailMessage Message
	 * @param throwable Exception
	 */
	public AppException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
	
	/**
	 * Constructor.
	 * @param detailMessage Message
	 */
    public AppException(String detailMessage) {
        super(detailMessage);
    }
    
    /**
	 * Constructor.
	 * @param throwable Exception
     */
    public AppException(Throwable throwable) {
        super(throwable);
    }
    
    /**
     * Constructor.
     * @param errorEntity Error entity
     */
    public AppException(ErrorEntity errorEntity) {
        super();
        mErrorEntity = errorEntity;
    }
    
    /**
	 * Constructor.
	 * @param detailMessage Message
	 * @param throwable Exception
     * @param errorEntity Error entity
     */
    public AppException(String detailMessage, Throwable throwable,
            ErrorEntity errorEntity) {
        super(detailMessage, throwable);
        mErrorEntity = errorEntity;
    }
    
    /**
	 * Constructor.
	 * @param detailMessage Message
     * @param errorEntity Error entity
     */
    public AppException(String detailMessage, ErrorEntity errorEntity) {
        super(detailMessage);
        mErrorEntity = errorEntity;
    }
    
    /**
	 * Constructor.
	 * @param throwable Exception
     * @param errorEntity Error entity
     */
    public AppException(Throwable throwable, ErrorEntity errorEntity) {
        super(throwable);
        mErrorEntity = errorEntity;
    }
    
    /**
     * Get error code
     * @return Error code
     */
    public String getErrorCode() {
        if (mErrorEntity == null) {
            return null;
        }
        return mErrorEntity.getErrorCode();
    }
    
    /**
     * Get error message.
     * @return Error message
     */
    public String getErrorMessage() {
        if (mErrorEntity == null) {
            return null;
        }
        return mErrorEntity.getErrorMessage();
    }
}
