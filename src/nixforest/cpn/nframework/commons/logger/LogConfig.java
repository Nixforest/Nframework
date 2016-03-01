/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.io.File;
import java.util.Date;

import nixforest.cpn.nframework.commons.analysis.SWatch;
import nixforest.cpn.nframework.commons.exception.BaseConfigException;
import nixforest.cpn.nframework.commons.exception.GenericRuntimeException;
import nixforest.cpn.nframework.commons.util.ReflectUtil;

/**
 * @author Nixforest
 * @date Mar 01, 2016
 */
public class LogConfig {
    private final LogFormat mLogFormat = null;
    private SWatch mFailyRotWatch = null;
    private long mRotTime = 0;
    private Date mDate = new Date();
    private File mOutputFile = null;
    private String mOutputFilePath = "";
    private String mAppenderName = "";
    private String mAppenderClass = "";
    private int mType = 0;
    private String mDirectory = "";
    private String mFileName = "";
    private boolean mRotDaily = false;
    private long mMaxFileSize = 0;
    private int mMaxBackupIndex = 0;
    private String mFileDateFormat = "";
    private String mLogFormatClass = "";
    private String mConversionPattern = "";
    private String mDateFormat = "";
    
    private LogFormat createLogFormatInst() {
        BaseLogFormat logFormat;
        try {
            logFormat = (BaseLogFormat) ReflectUtil.getInst(mLogFormatClass);
        } catch (GenericRuntimeException e) {
            throw new BaseConfigException("illegal value at layout class.", e);
        }
        logFormat.setPattern(mConversionPattern);
        logFormat.setDateFormat(mDateFormat);
        return logFormat;
    }
}
