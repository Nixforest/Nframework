/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.entity;

/**
 * Error entity class.
 * @author Nixforest
 * @date Feb 15, 2016
 */
public class ErrorEntity {
	/**
	 * Error code.
	 */
	private String mErrorCode;
	/**
	 * Error message.
	 */
	private String mErrorMessage;
	
	/**
	 * Default constructor.
	 */
	public ErrorEntity() {
    }

	/**
	 * @return the mErrorCode
	 */
	public String getErrorCode() {
		return mErrorCode;
	}

	/**
	 * @param mErrorCode the mErrorCode to set
	 */
	public void setmErrorCode(String mErrorCode) {
		this.mErrorCode = mErrorCode;
	}

	/**
	 * @return the mErrorMessage
	 */
	public String getErrorMessage() {
		return mErrorMessage;
	}

	/**
	 * @param mErrorMessage the mErrorMessage to set
	 */
	public void setmErrorMessage(String mErrorMessage) {
		this.mErrorMessage = mErrorMessage;
	}
}
