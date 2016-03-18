/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;


/**
 * Log factory class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public final class LogFactory {
    private LogFactory() {
    }
    public static Logger getInstance(Class<?> cls) {
        //TODO-AssertUtil.assertNotNull(cls, "cls");

        Logger instance = LogMan.getLogger(cls);
        if (instance == null) {
            instance = Logger.getInstance(cls);
            LogMan.addLogger(cls, instance);
        }
        return instance;
    }
}
