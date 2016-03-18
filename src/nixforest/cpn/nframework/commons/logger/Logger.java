/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import nixforest.cpn.nframework.commons.config.SysConst;
import nixforest.cpn.nframework.commons.exception.BaseConfigException;
import nixforest.cpn.nframework.commons.exception.GenericRuntimeException;
import nixforest.cpn.nframework.commons.exception.SysException;
import nixforest.cpn.nframework.commons.util.ReflectUtil;
import nixforest.cpn.nframework.commons.util.StringUtil;

/**
 * Logger class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public final class Logger {
    /** Tag length maximum value*/
    private static final int LIMIT_TAG_LENGTH = 23;

    /** Log Settings (held in appender units) */
    private Map<String, LogConfig> mLogConfigMap;

    /** List of Appender */
    private Appender[] mAppenderArray;

    /** Log output source of the class */
    private final Class<?> mCls;

    /** Tag */
    private final String mTag;

    private Logger(Class<?> cls){
        //TODO-AssertUtil.assertNotNull(cls, "cls");

        // Log output source of the class
        mCls = cls;
        // Tag
        mTag = getTagName(cls);
        // Log Settings
        mLogConfigMap = LogMan.getLogConfig();
        // Create an instance of the appender
        if (mLogConfigMap == null || mLogConfigMap.size() == 0) {
            mAppenderArray = new Appender[0];
        } else {
            mAppenderArray = new Appender[mLogConfigMap.size()];
            Iterator<Entry<String, LogConfig>> ite = mLogConfigMap.entrySet().iterator();
            int idx = 0;
            while (ite.hasNext()) {
                // Read setting
                LogConfig conf = ite.next().getValue();
                // Instantiation
                BaseAppender appender = createAppenderInstance(conf, cls);
                // Store
                mAppenderArray[idx++] = appender;
            }
        }
    }
    
    private static String getTagName(Class<?> cls){
    	//TODO-AssertUtil.assertNotNull(cls);

        String  s;
        s = cls.getSimpleName();
        s = StringUtil.right(s, LIMIT_TAG_LENGTH);

      //TODO-AssertUtil.assertNotNull(s);
        return s;
    }

    private BaseAppender createAppenderInstance(LogConfig conf, Class<?> outputCls) {
        BaseAppender appender;
        try {
            appender = (BaseAppender) ReflectUtil.getInst(conf.getAppenderClass());
            appender.setConf(conf);
            appender.setOutputCls(outputCls);
        } catch (GenericRuntimeException e) {
            throw new BaseConfigException("illegal value at appender class.", e);
        }
        return appender;
    }

    static Logger getInstance(Class<?> cls) {
    	//TODO-AssertUtil.assertNotNull(cls);
        return new Logger(cls);
    }

    public void error(Object obj) {
        error(mTag, obj);
    }

    public void error(String message) {
        error(mTag, message);
    }

    public void error(String message, Throwable t) {
        error(mTag, message, t);
    }

    public void error(String[] messages) {
        error(mTag, messages);
    }

    public void error(Collection<?> messages) {
        error(mTag, messages);
    }

    public void error(String tag, Object obj) {
        if (!isErrorEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.error(tag, obj);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void error(String tag, String message) {
        if (!isErrorEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.error(tag, message);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    /**
     * <b>ERRORレベルでログを出力します。</b><br>
     * <br>
     * 作成日 : 2014/06/16
     * @author YSD K.Kinoshita
     *
     * @param tag タグ
     * @param message メッセージ
     * @param t ログ出力する例外
     */
    public void error(String tag, String message, Throwable t) {
        if (!isErrorEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.error(tag, message, t);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void error(String tag, String[] messages) {
        if (!isErrorEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.error(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void error(String tag, Collection<?> messages) {
        if (!isErrorEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.error(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public boolean isErrorEnabled() {
        boolean ret = LogMan.getLogCategory(mCls).intValue() <= LogLevel.ERROR.intValue();
        return ret;
    }

    public void warn(Object obj) {
        warn(mTag, obj);
    }

    public void warn(String message) {
        warn(mTag, message);
    }

    public void warn(String message, Throwable t) {
        warn(mTag, message, t);
    }

    public void warn(String[] messages) {
        warn(mTag, messages);
    }

    public void warn(Collection<?> messages) {
        warn(mTag, messages);
    }

    public void warn(String tag, Object obj) {
        if (!isWarnEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.warn(tag, obj);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void warn(String tag, String message) {
        if (!isWarnEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.warn(tag, message);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void warn(String tag, String message, Throwable t) {
        if (!isWarnEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.warn(tag, message, t);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void warn(String tag, String[] messages) {
        if (!isWarnEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.warn(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void warn(String tag, Collection<?> messages) {
        if (!isWarnEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.warn(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public boolean isWarnEnabled() {
        boolean ret = LogMan.getLogCategory(mCls).intValue() <= LogLevel.WARN.intValue();
        return ret;
    }

    public void info(Object obj) {
        info(mTag, obj);
    }

    public void info(String message) {
        info(mTag, message);
    }

    public void info(String message, Throwable t) {
        info(mTag, message, t);
    }

    public void info(String[] messages) {
        info(mTag, messages);
    }

    public void info(Collection<?> messages) {
        info(mTag, messages);
    }

    public void info(String tag, Object obj) {
        if (!isInfoEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.info(tag, obj);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void info(String tag, String message) {
        if (!isInfoEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.info(tag, message);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void info(String tag, String message, Throwable t) {
        if (!isInfoEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.info(tag, message, t);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void info(String tag, String[] messages) {
        if (!isInfoEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.info(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void info(String tag, Collection<?> messages) {
        if (!isInfoEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.info(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public boolean isInfoEnabled() {
        boolean ret = LogMan.getLogCategory(mCls).intValue() <= LogLevel.INFO.intValue();
        return ret;
    }

    public void debug(Object obj) {
        debug(mTag, obj);
    }

    public void debug(String message) {
        debug(mTag, message);
    }

    public void debug(String message, Throwable t) {
        debug(mTag, message, t);
    }

    public void debug(String[] messages) {
        debug(mTag, messages);
    }

    public void debug(Collection<?> messages) {
        debug(mTag, messages);
    }

    public void debug(String tag, Object obj) {
        if (!isDebugEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.debug(tag, obj);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void debug(String tag, String message) {
        if (!isDebugEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.debug(tag, message);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void debug(String tag, String message, Throwable t) {
        if (!isDebugEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.debug(tag, message, t);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void debug(String tag, String[] messages) {
        if (!isDebugEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.debug(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void debug(String tag, Collection<?> messages) {
        if (!isDebugEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.debug(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public boolean isDebugEnabled() {
        boolean ret = LogMan.getLogCategory(mCls).intValue() <= LogLevel.DEBUG.intValue();
        return ret;
    }

    public void trace(Object obj) {
        trace(mTag, obj);
    }

    public void trace(String message) {
        trace(mTag, message);
    }

    public void trace(String message, Throwable t) {
        trace(mTag, message, t);
    }

    public void trace(String[] messages) {
        trace(mTag, messages);
    }

    public void trace(Collection<?> messages) {
        trace(mTag, messages);
    }

    public void trace(String tag, Object obj) {
        if (!isTraceEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.trace(tag, obj);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void trace(String tag, String message) {
        if (!isTraceEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.trace(tag, message);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void trace(String tag, String message, Throwable t) {
        if (!isTraceEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.trace(tag, message, t);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void trace(String tag, String[] messages) {
        if (!isTraceEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.trace(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public void trace(String tag, Collection<?> messages) {
        if (!isTraceEnabled()) {
            return;
        }
        for (Appender appender : mAppenderArray) {
            try {
                appender.trace(tag, messages);
            } catch (SysException e) {
                LogMan.fatalLog(this.getClass(), SysConst.CMSTR_FAILEDWRITELOG, e);
            }
        }
    }

    public boolean isTraceEnabled() {
        boolean ret = LogMan.getLogCategory(mCls).intValue() <= LogLevel.TRACE.intValue();
        return ret;
    }
}
