/**
 * 
 */
package nixforest.cpn.nframework.commons.logger;

import java.io.PrintWriter;

import nixforest.cpn.nframework.commons.config.SysConst;
import nixforest.cpn.nframework.commons.util.StringUtil;

/**
 * @author Nixforest
 * @date Mar 16, 2016
 */
public abstract class BaseAppender implements Appender {
    protected static final String STR_NULL = "NULL";
    private LogConfig mConf;
    private Class<?> mCls;
	/**
	 * @return the mConf
	 */
	public LogConfig getConf() {
		return mConf;
	}
	/**
	 * @param mConf the mConf to set
	 */
	public void setConf(LogConfig mConf) {
		this.mConf = mConf;
	}
	/**
	 * @return the mCls
	 */
	public Class<?> getOutputCls() {
		return mCls;
	}
	/**
	 * @param mCls the mCls to set
	 */
	public void setOutputCls(Class<?> mCls) {
		this.mCls = mCls;
	}

    public static void print(PrintWriter pw, String message) {
        pw.print(StringUtil.nullToString(message, STR_NULL));
    }

    public static void printStackTrace(PrintWriter pw,
                                       Throwable cause,
                                       StringBuilder line,
                                       boolean causeFlg) {
        line.setLength(0);
        if (causeFlg) {
            line.append(SysConst.CMSTR_CAUSEBY);
        }
        line.append(cause.getClass().getName());
        line.append(SysConst.COLON);
        line.append(cause.getMessage());
        line.append(SysConst.LINE_SEPARATOR);
        print(pw, line.toString());
        for (StackTraceElement e : cause.getStackTrace()) {
            line.setLength(0);
            line.append(SysConst.TAB);
            line.append(SysConst.CMSTR_AT);
            line.append(e.toString());
            line.append(SysConst.LINE_SEPARATOR);
            print(pw, line.toString());
        }

        Throwable cause2 = cause.getCause();
        if (cause2 != null) {
            printStackTrace(pw, cause2, line, true);
        }
    }
}
