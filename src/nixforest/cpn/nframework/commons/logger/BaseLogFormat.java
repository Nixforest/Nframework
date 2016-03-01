/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

/**
 * @author Nixforest
 * @date Mar 01, 2016
 */
public abstract class BaseLogFormat implements LogFormat {
    private String pattern = "";
    private String dateFormat = "";
    public String getPattern() {
        return pattern;
    }
    public void setPattern(String pattern) {
        // TODO-AssertUtil.assertNotNull(pattern, "pattern");
        this.pattern = pattern;
    }
    public String getDateFormat() {
        return dateFormat;
    }
    public void setDateFormat(String dateFormat) {
     // TODO-AssertUtil.assertNotNull(dateFormat, "dateFormat");
        this.dateFormat = dateFormat;
    }
    
}
