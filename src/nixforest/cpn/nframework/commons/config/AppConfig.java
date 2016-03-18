/**
 * 
 */
package nixforest.cpn.nframework.commons.config;

import java.util.Map;
import java.util.Properties;

import nixforest.cpn.nframework.commons.logger.LogConfig;
import nixforest.cpn.nframework.commons.logger.LogLevel;
import nixforest.cpn.nframework.commons.util.StringUtil;


/**
 * @author Nixforest
 * @date Mar 16, 2016
 */
public final class AppConfig {
	/** Default constructor */
	private AppConfig() {
		
	}

    public static String getString(String key) {
        Properties prop = ConfigMan.getApplicationProperties();
        return StringUtil.nullToEmpty(prop.get(key));
    }
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(getString(key));
    }
    public static long getLong(String key) {
        return Long.parseLong(getString(key));
    }
    public static Map<String, LogConfig> getLogConfig() {
        return ConfigMan.getLogConfigMap();
    }
    public static Map<String, LogLevel> getLogCategory() {
        return ConfigMan.getLogCategoryMap();
    }
    public static LogLevel getLogRootCategory() {
        return ConfigMan.getLogRootCategory();
    }
    //TODO-public static Map<String, DBConfig> getDBConfig() {
//        return ConfigManager.getDBConfigMap();
//    }
    //TODO-Not finish
}
