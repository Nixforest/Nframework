/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

/**
 * @author Nixforest
 * @date Feb 25, 2016
 */
public interface LogFormat {
	/**
	 * Format log content.
	 * @param cls Log output source of the class
	 * @param logLevel Log level
	 * @param tag Tag
	 * @param message Message
	 * @return String format
	 */
    String format(Class<?> cls, LogLevel logLevel, String tag, String message);
}
