/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import nixforest.cpn.nframework.commons.exception.BaseConfigException;
import nixforest.cpn.nframework.commons.util.StringUtil;
import android.content.Context;
import android.content.res.AssetManager;

/**
 * @author Nixforest
 * @date Feb 21, 2016
 */
public final class ConfigMan {
	/** System Properties file name. */
	private static final String SYSTEM_PROP_FILE_NAME = "nframework/system.properties";
	/** Application Properties file name. */
	private static final String APPLICATION_PROP_FILE_NAME = "nframework/application.properties";
	/** Context */
	private static Context sContext;
	/** Hold System Properties */
	private static Properties sSystemProp;
	/** Hold Application Properties */
	private static Properties sApplicationProp;
	
	/**
	 * Default constructor.
	 */
	private ConfigMan() {
    }
	private static void logContent(String fileName, Properties prop) {
        String[] keys = (String[]) prop.keySet().toArray(new String[prop.size()]);
        if (keys != null && keys.length > 0) {
            Arrays.sort(keys);
            StringBuilder builder = new StringBuilder();
            builder.append(fileName);
            builder.append(StringUtil.LF);
            for (int i = 0; i < keys.length; i++) {
                String value = (String) prop.get(keys[i]);
                builder.append("  [" + keys[i] + "] = [" + value + "]" + StringUtil.LF);
            }
            //TODO-LogManager.infoLog(ConfigManager.class, builder.toString());
        }
    }
	private static Properties readProperties(String fileName) {
        Properties prop = new Properties();

        InputStream in = null;
        try {
            AssetManager as = sContext.getResources().getAssets();
            in = as.open(fileName);
            if (in == null) {
                throw new BaseConfigException(fileName + " does not exist.");
            }
            prop.load(in);
            logContent(fileName, prop);

        } catch (IOException e) {
            throw new BaseConfigException("Reading of " + fileName + " went wrong.", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                	//TODO-LogManager.fatalLog(ConfigManager.class, "close() failed.", e);
                }
            }
        }
        return prop;
    }
	public static void reload() {
        sSystemProp = readProperties(SYSTEM_PROP_FILE_NAME);
        sApplicationProp = readProperties(APPLICATION_PROP_FILE_NAME);
        // ViewManagerを更新
        //TODO-ViewManager.initialize();
    }
	public static void init(Context context) {
        sContext = context;
        reload();
    }
    public static void setSystemConfigProperty(String key, String value) {
        if (sContext == null) {
            throw new BaseConfigException("This class is uninitialized yet.");
        }
        //TODO-if (SystemConfig.isDebugMode()) {
            synchronized (sSystemProp) {
                sSystemProp.setProperty(key,  value);
            }
        //}
    }
    public static void setApplicationConfigProperty(String key, String value) {
        if (sContext == null) {
            throw new BaseConfigException("This class is uninitialized yet.");
        }
        //TODO-if (SystemConfig.isDebugMode()) {
            synchronized (sApplicationProp) {
                sApplicationProp.setProperty(key,  value);
            }
        //}
    }
    static Properties getSystemProperties() {
        return sSystemProp;
    }
    static Properties getApplicationProperties() {
        return sApplicationProp;
    }
    //TODO-static Map<String, LogConfig> getLogConfigMap() {
//        String[] keys =
//                (String[]) sApplicationProp.keySet().toArray(new String[sApplicationProp.size()]);
//        Map<String, LogConfig> result = new HashMap<String, LogConfig>();
//        if (keys != null && keys.length > 0) {
//            Arrays.sort(keys);
//            Map<String, String> keyMap = new HashMap<String, String>();
//            Map<String, Map<String, String>> logMaps = new HashMap<String, Map<String, String>>();
//            for (int i = 0; i < keys.length; i++) {
//                if (keys[i].startsWith(ApplicationConfigKeys.LOG_PREFIX)) {
//                    String value = (String) sApplicationProp.get(keys[i]);
//                    String[] keyElement = StringUtil.split(keys[i], "\\.");
//                    if (keyMap.get(keyElement[1]) == null) {
//                        Map<String, String> logMap = new HashMap<String, String>();
//                        logMaps.put(keyElement[1], logMap);
//                        keyMap.put(keyElement[1], "");
//                    }
//                    Map<String, String> logMap = logMaps.get(keyElement[1]);
//                    logMap.put(createKey(keyElement, 2, "."), StringUtil.trim(value));
//                }
//
//            }
//
//            String[] configArray = keyMap.keySet().toArray(new String[keyMap.size()]);
//            for (int i = 0; i < configArray.length; i++) {
//                if (configArray[i].equals(ApplicationConfigKeys.LOG_CATEGORY_KEY)) {
//                    // ログカテゴリ
//                    continue;
//                }
//                LogConfig config = new LogConfig(configArray[i], logMaps.get(configArray[i]));
//                result.put(configArray[i], config);
//            }
//        }
//        return result;
//    }
}
