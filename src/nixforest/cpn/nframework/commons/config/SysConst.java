/**
 * 
 */
package nixforest.cpn.nframework.commons.config;

import java.io.File;

/**
 * @author Nixforest
 * @date Mar 16, 2016
 */
public final class SysConst {
    public static final String FRAMEWORK_NAME		= "nframework";
    public static final String PATH_SEPARATOR		= File.separator;
    public static final String LINE_SEPARATOR		= "\n";
    public static final String TAB					= "\t";
    public static final String COLON				= ":";
    public static final String BUG_REPORT_FILE		= "BugReport";
    public static final String DEFAULT_FONT_SIZE	= "H4";
    public static final String ERR_CD_SYSTEM_ERROR	= "F00001";
    public static final String ERR_CD_INPUT_ERROR	= "F00002";

    public static final String BUNDLE_KEY_CONTAINER_MAP = "bundleKey.containerMap";
    public static final String CONTAINERMAP_FILENAME_PREFIX = "nframework_";

    /** Common strings */
    public static final String CMSTR_CAUSEBY		= "Caused by: ";
    public static final String CMSTR_AT				= "at ";
    public static final String CMSTR_FAILEDWRITELOG = "failed writing log.";
    /**
     * Default constructor
     */
    private SysConst() {
    }
}
