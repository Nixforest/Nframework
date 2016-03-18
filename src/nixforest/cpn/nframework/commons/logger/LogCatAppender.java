/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.util.Collection;

import nixforest.cpn.nframework.commons.util.StringUtil;
import android.util.Log;

/**
 * LogCat is appender to perform the log output to.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public class LogCatAppender extends BaseAppender {
    private String getFormattedMessage(LogLevel logLevel, String tag, String message) {
        return super.getConf().getLogFormat().format(super.getOutputCls(),
                logLevel, tag, message);
    }

    @Override
    public void error(String tag, Object obj) {
        error(tag, StringUtil.nullToString(obj, STR_NULL));
    }

    @Override
    public void error(String tag, String message) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.e(tTag, getFormattedMessage
                (LogLevel.ERROR, tTag, StringUtil.nullToString(message, STR_NULL)));
    }

    @Override
    public void error(String tag, String message, Throwable t) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.e(tTag, getFormattedMessage
                (LogLevel.ERROR, tTag, StringUtil.nullToString(message, STR_NULL)), t);
    }

    @Override
    public void error(String tag, String[] messages) {
        for (String message : messages) {
            error(tag, message);
        }
    }

    @Override
    public void error(String tag, Collection<?> messages) {
        for (Object message : messages) {
            error(tag, message);
        }
    }

    @Override
    public void warn(String tag, Object obj) {
        warn(tag, StringUtil.nullToString(obj, STR_NULL));
    }

    @Override
    public void warn(String tag, String message) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.w(tTag, getFormattedMessage
                (LogLevel.WARN, tTag, StringUtil.nullToString(message, STR_NULL)));
    }

    @Override
    public void warn(String tag, String message, Throwable t) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.w(tTag, getFormattedMessage
                (LogLevel.WARN, tTag, StringUtil.nullToString(message, STR_NULL)), t);
    }

    @Override
    public void warn(String tag, String[] messages) {
        for (String message : messages) {
            warn(tag, message);
        }
    }

    @Override
    public void warn(String tag, Collection<?> messages) {
        for (Object message : messages) {
            warn(tag, message);
        }
    }

    @Override
    public void info(String tag, Object obj) {
        info(tag, StringUtil.nullToString(obj, STR_NULL));
    }

    @Override
    public void info(String tag, String message) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.i(tTag, getFormattedMessage
                (LogLevel.INFO, tTag, StringUtil.nullToString(message, STR_NULL)));
    }

    @Override
    public void info(String tag, String message, Throwable t) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.i(tTag, getFormattedMessage
                (LogLevel.INFO, tTag, StringUtil.nullToString(message, STR_NULL)), t);
    }

    @Override
    public void info(String tag, String[] messages) {
        for (String message : messages) {
            info(tag, message);
        }
    }

    @Override
    public void info(String tag, Collection<?> messages) {
        for (Object message : messages) {
            info(tag, message);
        }
    }

    @Override
    public void debug(String tag, Object obj) {
        debug(tag, StringUtil.nullToString(obj, STR_NULL));
    }

    @Override
    public void debug(String tag, String message) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.d(tTag, getFormattedMessage
                (LogLevel.DEBUG, tTag, StringUtil.nullToString(message, STR_NULL)));
    }

    @Override
    public void debug(String tag, String message, Throwable t) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.d(tTag, getFormattedMessage
                (LogLevel.DEBUG, tTag, StringUtil.nullToString(message, STR_NULL)), t);
    }

    @Override
    public void debug(String tag, String[] messages) {
        for (String message : messages) {
            debug(tag, message);
        }
    }

    @Override
    public void debug(String tag, Collection<?> messages) {
        for (Object message : messages) {
            debug(tag, message);
        }
    }

    @Override
    public void trace(String tag, Object obj) {
        trace(tag, StringUtil.nullToString(obj, STR_NULL));
    }

    @Override
    public void trace(String tag, String message) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.v(tTag, getFormattedMessage
                (LogLevel.TRACE, tTag, StringUtil.nullToString(message, STR_NULL)));
    }

    @Override
    public void trace(String tag, String message, Throwable t) {
        String tTag = StringUtil.nullToString(tag, STR_NULL);
        Log.v(tTag, getFormattedMessage
                (LogLevel.TRACE, tTag, StringUtil.nullToString(message, STR_NULL)), t);
    }

    @Override
    public void trace(String tag, String[] messages) {
        for (String message : messages) {
            trace(tag, message);
        }
    }

    @Override
    public void trace(String tag, Collection<?> messages) {
        for (Object message : messages) {
            trace(tag, message);
        }
    }
}
