/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.analysis;

import java.util.Date;

import nixforest.cpn.nframework.commons.util.DateTimeUtil;



/**
 * @author Nixforest
 * @date Feb 25, 2016
 */
public final class AnalysisUtil {
    public static final int MILLISECOND             = 1000;
    public static final int SECOND_PER_MINUTE       = 60;
    public static final int MINUTE_PER_HOUR         = 60;
    public static final int HOUR_PER_DATE           = 24;
    public static final int SECOND_PER_HOUR         = SECOND_PER_MINUTE * MINUTE_PER_HOUR;
    public static final int SECOND_PER_HALF_DATE    = SECOND_PER_MINUTE * MINUTE_PER_HOUR * HOUR_PER_DATE / 2;
    public static final int SECOND_PER_DATE         = SECOND_PER_MINUTE * MINUTE_PER_HOUR * HOUR_PER_DATE;
    public static final int MILLISECOND_PER_MINUTE  = SECOND_PER_MINUTE * MILLISECOND;
    public static final int MILLISECOND_PER_HOUR    = MINUTE_PER_HOUR * SECOND_PER_MINUTE * MILLISECOND;
    public static final int MILLISECOND_PER_DATE    = HOUR_PER_DATE * MINUTE_PER_HOUR * SECOND_PER_MINUTE * MILLISECOND;
    
    /**
     * Default constructor.
     */
    private AnalysisUtil() {
    }
    public static String formatElapseFromNow(Date date){
        //TODO-AssertUtil.assertNotNull(date);

        SWatch sw = FlexStopWatch.start(date.getTime());
        return formatDaysElapse(sw.stop());
    }
    public static String formatElapseFromNow(String date, String format) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(format);

        return formatElapseFromNow(DateTimeUtil.parse(date, format));
    }
    public static String formatDaysElapse(SWatch sw){
        return formatDaysElapse(sw.getElapsedTime());
    }
    public static String formatDaysElapse(long milli){
        String plus = "";
        long milliValue = milli;
        if (milliValue < 0) {
            plus = "-";
            milliValue *= -1;
        }
        
        long v = milliValue;
        long d = v / MILLISECOND_PER_DATE;
        v = v % MILLISECOND_PER_DATE;
        long h = v / MILLISECOND_PER_HOUR;
        v = v % MILLISECOND_PER_HOUR;
        long m = v / MILLISECOND_PER_MINUTE;
        v = v % MILLISECOND_PER_MINUTE;
        long s = v / MILLISECOND;

        return "[" + plus + d + "days " + String.format("%02d:%02d:%02d", h, m, s) + "]";
    }
    public static String formatTimeElapse(SWatch sw) {
        return formatTimeElapse(sw.getElapsedTime());
    }
    public static String formatTimeElapse(long milli) {
        String plus = "";
        long milliValue = milli;
        if (milliValue < 0) {
            plus = "-";
            milliValue *= -1;
        }
        return "[" + plus + String.format("%dms", milliValue) + "]";
    }
    //TODO-
//    public static long incrementLog(Logger logger, AliveCounter counter) {
//        AssertUtil.assertNotNull(logger);
//        AssertUtil.assertNotNull(counter);
//
//        long ret = counter.increment();
//
//        if (logger.isInfoEnabled()) {
//            logger.info(counter.toString());
//        }
//        return ret;
//    }
//    public static long decrementLog(Logger logger, AliveCounter counter) {
//        AssertUtil.assertNotNull(logger);
//        AssertUtil.assertNotNull(counter);
//        
//        long ret = counter.decrement();
//        
//        if (logger.isInfoEnabled()) {
//            logger.info(counter.toString());
//        }
//        
//        return ret;
//    }
}
