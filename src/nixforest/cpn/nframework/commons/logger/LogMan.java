/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.util.HashMap;
import java.util.Map;

import nixforest.cpn.nframework.commons.config.AppConfig;

/**
 * Logger manager class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public final class LogMan {
    /** Instance for Singleton */
    private static LogMan sManager;
    /** Access to the configuration information */
    private static LogConfigHelper mConfigHelper;
    /** Logger (held in the output class unit, key to the class name) */
    private Map<String, Logger> mLoggerMap = new HashMap<String, Logger>();

    /**
     * Default constructor.
     */
    private LogMan() {
        // Get the configuration settings file
        loadConfigFile();
    }

    public static synchronized void reload() {
        createInstance();
        sManager.loadConfigFile();
    }

    private void loadConfigFile() {
        // Setting log category
        LogLevel rootCategory = AppConfig.getLogRootCategory();
        Map<String, LogLevel> logCategoryMap = AppConfig.getLogCategory();
        mConfigHelper = new LogConfigHelper(logCategoryMap, rootCategory);
        
        // Appender setting
        Map<String, LogConfig> logConfigMap = AppConfig.getLogConfig();
        mConfigHelper.setLogConfigMap(logConfigMap);
    }
    
    private LogConfigHelper getConfigHelper() {
        return mConfigHelper;
    }

    static synchronized Map<String, LogConfig> getLogConfig() {
        createInstance();
        return sManager.getConfigHelper().getLogConfigMap();
    }

    static LogConfig getLogConfig(String appenderName) {
        return getLogConfig().get(appenderName);
    }

    static LogLevel getLogCategory(Class<?> cls) {
        return getLogCategory(cls.getName());
    }

    static synchronized LogLevel getLogCategory(String clsName) {
        createInstance();
        return sManager.getConfigHelper().getLogCategory().getCategory(clsName);
    }

    public static String getLogCategoryName(Class<?> cls) {
        //TODO-AssertUtil.assertNotNull(cls, "cls");

        return getLogCategoryName(cls.getName());
    }

    static synchronized String getLogCategoryName(String clsName) {
        createInstance();
        return sManager.getConfigHelper().getLogCategory().getLogCategoryName(clsName);
    }

    static Logger getLogger(Class<?> cls) {
        createInstance();
        return getLogger(cls.getName());
    }

    static Logger getLogger(String clsName) {
        createInstance();
        return sManager.mLoggerMap.get(clsName);
    }

    static void addLogger(Class<?> cls, Logger logger) {
        createInstance();
        sManager.mLoggerMap.put(cls.getName(), logger);
    }

    public static void infoLog(Class<?> cls, String message) {
    	//TODO-AssertUtil.assertNotNull(cls, "cls");
    	//TODO-AssertUtil.assertNotNull(message, "message");

        android.util.Log.i(cls.getSimpleName(), message);
    }

    public static void fatalLog(Class<?> cls, String message, Throwable t) {
    	//TODO-AssertUtil.assertNotNull(cls, "cls");
    	//TODO-AssertUtil.assertNotNull(message, "message");
    	//TODO-AssertUtil.assertNotNull(t, "t");

        android.util.Log.e(cls.getSimpleName(), message, t);
    }

    public static synchronized void setCategory(String clsName, LogLevel logCategory) {
    	//TODO-AssertUtil.assertNotNull(clsName, "clsName");
    	//TODO-AssertUtil.assertNotNull(logCategory, "logCategory");

        if (clsName.equals(LogConst.ROOT)) {
            sManager.getConfigHelper().setRootCategory(logCategory);
            sManager.getConfigHelper().getLogCategory().setLogCategory(logCategory);
        } else {
            sManager.getConfigHelper().getLogCategory().setNode(clsName, logCategory);
        }
    }

    private static void createInstance() {
        if (sManager == null) {
            sManager = new LogMan();
        }
    }
}
