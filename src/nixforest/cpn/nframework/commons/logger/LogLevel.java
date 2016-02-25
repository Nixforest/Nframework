/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.io.Serializable;

import nixforest.cpn.nframework.commons.exception.GenericRuntimeException;
import android.util.Log;

/**
 * Definition of the class log level.
 * @author Nixforest
 * @date Feb 25, 2016
 */
public class LogLevel implements Serializable {
	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = -1210324799592919841L;
	/** Definition of ERROR level */
    public static final LogLevel ERROR = new LogLevel("ERROR", Log.ERROR);
	/** Definition of WARN level */
    public static final LogLevel WARN  = new LogLevel("WARN", Log.WARN);
	/** Definition of INFO level */
    public static final LogLevel INFO  = new LogLevel("INFO", Log.INFO);
	/** Definition of DEBUG level */
    public static final LogLevel DEBUG = new LogLevel("DEBUG", Log.DEBUG);
	/** Definition of TRACE level */
    public static final LogLevel TRACE = new LogLevel("TRACE", Log.VERBOSE);
    private String mName;
    private int mValue;

    public LogLevel(String name, int value) {
        //TODO-AssertUtil.assertNotEmpty(name, "name");
        mName = name;
        mValue = value;
    }
    public int intValue() {
        return mValue;
    }

    /* (非 Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return mName;
    }
    public String getName() {
        return mName;
    }
    public static LogLevel parse(String name) {
    	//TODO-AssertUtil.assertNotEmpty(name, "name");

        LogLevel lvl = null;
        if (name.equals(LogLevel.ERROR.toString())) {
            lvl = LogLevel.ERROR ;
        } else if (name.equals(LogLevel.WARN.toString())) {
            lvl = LogLevel.WARN ;
        } else if (name.equals(LogLevel.INFO.toString())) {
            lvl = LogLevel.INFO ;
        } else if (name.equals(LogLevel.DEBUG.toString())) {
            lvl = LogLevel.DEBUG ;
        } else if (name.equals(LogLevel.TRACE.toString())) {
            lvl = LogLevel.TRACE ;
        } else {
            throw new GenericRuntimeException(String.format("Unexpected loglevel name.[%s]", name));
        }

        return lvl ;
    }
}
