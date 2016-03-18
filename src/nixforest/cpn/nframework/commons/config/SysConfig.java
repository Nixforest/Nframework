/**
 * 
 */
package nixforest.cpn.nframework.commons.config;

import java.util.Properties;

import nixforest.cpn.nframework.commons.util.StringUtil;
import nixforest.cpn.nframework.commons.util.ValidateUtil;


/**
 * @author Nixforest
 * @date Mar 16, 2016
 */
public final class SysConfig {
	/** Default constructor */
	private SysConfig() {
		
	}
    public static String getString(String key) {
        Properties prop = ConfigMan.getSystemProperties();
        return StringUtil.nullToEmpty(prop.get(key));
    }
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(getString(key));
    }
    public static long getLong(String key) {
        return Long.parseLong(getString(key));
    }
    public static boolean isDebugMode() {
        return getBoolean(ConfigKeys.DEBUG_MODE);
    }
    public static boolean validMethod() {
        String val = getString(ConfigKeys.VALID_METHOD_FLG);
        if (ValidateUtil.isEmpty(val)) {
            return true;
        } else {
            return Boolean.parseBoolean(val);
        }
    }
    public static boolean isFixedLocale() {
        return getBoolean(ConfigKeys.FIXED_LOCALE);
    }
}
