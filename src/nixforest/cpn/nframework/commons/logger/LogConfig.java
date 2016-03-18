/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.io.File;
import java.util.Date;
import java.util.Map;

import nixforest.cpn.nframework.commons.analysis.SWatch;
import nixforest.cpn.nframework.commons.config.ConfigKeys;
import nixforest.cpn.nframework.commons.exception.BaseConfigException;
import nixforest.cpn.nframework.commons.exception.GenericRuntimeException;
import nixforest.cpn.nframework.commons.util.DateTimeUtil;
import nixforest.cpn.nframework.commons.util.ReflectUtil;
import nixforest.cpn.nframework.commons.util.StringUtil;

/**
 * @author Nixforest
 * @date Mar 01, 2016
 */
public class LogConfig {
    private final LogFormat mLogFormat;
    private SWatch mDailyRotWatch = null;
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

    public LogConfig(String name, Map<String, String> config) {
    	//TODO-AssertUtil.assertNotEmpty(name, "name");
    	//TODO-AssertUtil.assertNotNull(config, "config");

        // Appender name
        mAppenderName = name;
        // Class path of appender
        mAppenderClass = config.get(ConfigKeys.LOG_APPENDER_CLASS_KEY);
        // Output type
        String type =
                StringUtil.nullToString(config.get(ConfigKeys.LOG_OUTPUT_TYPE_KEY), "0");
        mType = Integer.parseInt(type);
        // Output directory
        mDirectory =
                StringUtil.nullToEmpty(config.get(ConfigKeys.LOG_OUTPUT_DIRECOTRY_KEY));
        // Output filename
        mFileName =
                StringUtil.nullToEmpty(config.get(ConfigKeys.LOG_OUTPUT_FILENAME_KEY));

        // Daily rotation decision
        String rotate =
                StringUtil.nullToString(
                        config.get(ConfigKeys.LOG_OUTPUT_ROTATE_DAILY_KEY), "no");
        if (rotate.equals("yes")) {
            mRotDaily = true;
        } else {
            mRotDaily = false;
        }

        // Log rotation settings: the maximum file size (0: not determined, byte)
        String size =
                StringUtil.nullToString(
                        config.get(ConfigKeys.LOG_OUTPUT_MAX_FILE_SIZE_KEY), "0");
        mMaxFileSize = Long.parseLong(size);
        // The maximum number of backup files
        String idx =
                StringUtil.nullToString(
                        config.get(ConfigKeys.LOG_OUTPUT_MAX_BACKUP_INDEX_KEY), "-1");
        mMaxBackupIndex = Integer.parseInt(idx);
        //TODO-AssertUtil.assertTrue(mMaxBackupIndex != 0, "MaxBackupIndex must be other than '0'.");
        
        // Date format to be added to the log file
        mFileDateFormat =
                StringUtil.nullToEmpty(
                        config.get(ConfigKeys.LOG_OUTPUT_FILE_DATE_FORMAT_KEY));

        // Class path of the log layout
        mLogFormatClass = config.get(ConfigKeys.LOG_LAYOUT_CLASS_KEY);
        // Layout conversion pattern
        mConversionPattern = config.get(ConfigKeys.LOG_LAYOUT_CONVERSION_PATTERN_KEY);
        // ログ中の日付フォーマット
        mDateFormat = config.get(ConfigKeys.LOG_LAYOUT_DATE_FORMAT_KEY);

        // Date format in the log
        mLogFormat = createLogFormatInst();

        // 日時ローテーション設定
        if (mRotDaily) {
            setNextRotationTime();
        }
    }
    private LogFormat createLogFormatInst() {
        BaseLogFormat logFormat;
        try {
            logFormat = (BaseLogFormat) ReflectUtil.getInst(getLogFormatClass());
        } catch (GenericRuntimeException e) {
            throw new BaseConfigException("illegal value at layout class.", e);
        }
        logFormat.setPattern(getConversionPattern());
        logFormat.setDateFormat(getDateFormat());
        return logFormat;
    }

	/**
	 * @return the mLogFormat
	 */
	public LogFormat getLogFormat() {
		return mLogFormat;
	}

	/**
	 * @return the mAppenderName
	 */
	public String getAppenderName() {
		return mAppenderName;
	}

	/**
	 * @return the mType
	 */
	public int getType() {
		return mType;
	}

	/**
	 * @return the mDirectory
	 */
	public String getDirectory() {
		return mDirectory;
	}

	/**
	 * @return the mFileName
	 */
	public String getFileName() {
		return mFileName;
	}

	/**
	 * @return the mRotDaily
	 */
	public boolean isRotDaily() {
		return mRotDaily;
	}

	/**
	 * @return the mMaxFileSize
	 */
	public long getMaxFileSize() {
		return mMaxFileSize;
	}

	/**
	 * @return the mMaxBackupIndex
	 */
	public int getMaxBackupIndex() {
		return mMaxBackupIndex;
	}

	/**
	 * @return the mFileDateFormat
	 */
	public String getFileDateFormat() {
		return mFileDateFormat;
	}

	/**
	 * @return the mLogFormatClass
	 */
	public String getLogFormatClass() {
		return mLogFormatClass;
	}

	/**
	 * @return the mConversionPattern
	 */
	public String getConversionPattern() {
		return mConversionPattern;
	}

	/**
	 * @return the mDateFormat
	 */
	public String getDateFormat() {
		return mDateFormat;
	}

	/**
	 * @return the mOutputFile
	 */
	public File getOutputFile() {
		return mOutputFile;
	}

	/**
	 * @param mOutputFile the mOutputFile to set
	 */
	public void setOutputFile(File file) {
		//TODO-AssertUtil.assertNotNull(file, "outputFile");
		this.mOutputFile = file;
	}

	/**
	 * @return the mOutputFilePath
	 */
	public String getOutputFilePath() {
		return mOutputFilePath;
	}

	/**
	 * @param mOutputFilePath the mOutputFilePath to set
	 */
	public void setOutputFilePath(String filePath) {
		//TODO-AssertUtil.assertNotEmpty(filePath, "outputFilePath");
		this.mOutputFilePath = filePath;
	}

	/**
	 * @param mDailyRotWatch the mDailyRotWatch to set
	 */
	public void setDailyRotWatch(SWatch dailyRotWatch) {
		this.mDailyRotWatch = dailyRotWatch;
	}
    private void setNextRotationTime() {
        this.mDailyRotWatch = SWatch.start();

        long startTime = System.currentTimeMillis();

        Date rotateDate = DateTimeUtil.addDay(new Date(), 1);
        rotateDate = DateTimeUtil.setHour(rotateDate, 0);
        rotateDate = DateTimeUtil.setMinute(rotateDate, 0);
        rotateDate = DateTimeUtil.setSecond(rotateDate, 0);
        long rotateTime = rotateDate.getTime();

        mRotTime = rotateTime - startTime;
    }
    public boolean checkRotation() {
        if (this.mRotDaily) {
            if (mDailyRotWatch == null) {
                setNextRotationTime();
            }

            if (Long.compare(mDailyRotWatch.getElapsedTime(), mRotTime) > 0) {
                setNextRotationTime();
                return true;
            }
        }

        // Rotation of the file size
        if (mMaxFileSize == 0) {
            // Invalid
            return false;
        }
        if (mOutputFile != null && mOutputFile.length() >= mMaxFileSize) {
            return true;
        }

        return false;
    }
    public Date getDate() {
        return mDate;
    }
    public void setDate(Date date) {
    	//TODO-AssertUtil.assertNotNull(date, "date");

        mDate = date;
    }

	/**
	 * @return the mAppenderClass
	 */
	public String getAppenderClass() {
		return mAppenderClass;
	}
}
