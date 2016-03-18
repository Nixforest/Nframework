/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A class that summarize the log configuration information.
 * @author Nixforest
 * @date Mar 18, 2016
 */
final class LogConfigHelper {
    /** Log Settings (held in Appender unit, key is appender name) */
    private Map<String, LogConfig> mLogConfigMap = new HashMap<String, LogConfig>();

    /** Root category of log */
    private LogLevel mRootCategory;
    /** Log category (root of the tree structure) */
    private LogCategoryElement mLogCategory;
    /** List of log category settings */
    private Map<String, LogLevel> mLogCategoryMap;

    LogConfigHelper(Map<String, LogLevel> logCategoryMap, LogLevel rootCategory) {
        //TODO-AssertUtil.assertNotNull(logCategoryMap);
    	//TODO-AssertUtil.assertNotNull(rootCategory);
        
        mLogCategoryMap = logCategoryMap;
        mRootCategory = rootCategory;
    
        // Create a log category tree
        mLogCategory = new LogCategoryElement(mRootCategory);
        createLogCategoryTree();
    }
    
    private void createLogCategoryTree() {
        Iterator<Entry<String, LogLevel>> ite = mLogCategoryMap.entrySet().iterator();
        while (ite.hasNext()) {
            Entry<String, LogLevel> entry = ite.next();
            String clsName = entry.getKey();
            LogLevel logLevel = entry.getValue();
            mLogCategory.setNode(clsName, logLevel);
        }
    }

    LogLevel getRootCategory() {
        return mRootCategory;
    }

    void setRootCategory(LogLevel rootCategory) {
        mRootCategory = rootCategory;
    }

    Map<String, LogConfig> getLogConfigMap() {
        return mLogConfigMap;
    }

    void setLogConfigMap(Map<String, LogConfig> logConfigMap) {
        mLogConfigMap = logConfigMap;
    }

    LogCategoryElement getLogCategory() {
        return mLogCategory;
    }

    void setLogCategory(LogCategoryElement logCategory) {
        mLogCategory = logCategory;
    }
}
