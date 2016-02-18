/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.util.Collection;

import nixforest.cpn.nframework.commons.exception.SysException;

/**
 * This appender over interface of the log.
 * @author Nixforest
 * @date Feb 15, 2016
 */
public interface Appender {
	void error(String tag, Object obj) throws SysException;
	void error(String tag, String message) throws SysException;
	void error(String tag, String message, Throwable t) throws SysException;
	void error(String tag, String[] messages) throws SysException;
	void error(String tag, Collection<?> messages) throws SysException;
    void warn(String tag, Object obj) throws SysException;
    void warn(String tag, String message) throws SysException;
    void warn(String tag, String message, Throwable t) throws SysException;
    void warn(String tag, String[] messages) throws SysException;
    void warn(String tag, Collection<?> messages) throws SysException;
    void info(String tag, Object obj) throws SysException;
    void info(String tag, String message) throws SysException;
    void info(String tag, String message, Throwable t) throws SysException;
    void info(String tag, String[] messages) throws SysException;
    void info(String tag, Collection<?> messages) throws SysException;
    void debug(String tag, Object obj) throws SysException;
    void debug(String tag, String message) throws SysException;
    void debug(String tag, String message, Throwable t) throws SysException;
    void debug(String tag, String[] messages) throws SysException;
    void debug(String tag, Collection<?> messages) throws SysException;
    void trace(String tag, Object obj) throws SysException;
    void trace(String tag, String message) throws SysException;
    void trace(String tag, String message, Throwable t) throws SysException;
    void trace(String tag, String[] messages) throws SysException;
    void trace(String tag, Collection<?> messages) throws SysException;
}
