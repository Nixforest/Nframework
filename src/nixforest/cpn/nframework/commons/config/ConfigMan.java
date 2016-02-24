/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

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
            LogManager.infoLog(ConfigManager.class, builder.toString());
        }
    }
	private static Properties readProperties(String fileName) {
        Properties prop = new Properties();

        InputStream in = null;
        try {
            AssetManager as = sContext.getResources().getAssets();
            in = as.open(fileName);
            if (in == null) {
                throw new BaseConfigurationException(fileName + " does not exist.");
            }
            prop.load(in);
            // 内容をログ出力
            logContent(fileName, prop);

        } catch (IOException e) {
            throw new BaseConfigurationException("Reading of " + fileName + " went wrong.", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    LogManager.fatalLog(ConfigManager.class, "close() failed.", e);
                }
            }
        }
        return prop;
    }
	public static void reload() {
        sSystemProp = readProperties(SYSTEM_PROP_FILE_NAME);
        sApplicationProp = readProperties(APPLICATION_PROP_FILE_NAME);
        // ViewManagerを更新
        ViewManager.initialize();
    }
	public static void init(Context context) {
        sContext = context;
        reload();
    }
}
