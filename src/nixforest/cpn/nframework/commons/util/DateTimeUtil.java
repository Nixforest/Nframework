/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import nixforest.cpn.nframework.commons.exception.GenericRuntimeException;

/**
 * @author Nixforest
 * @date Mar 5, 2016
 */
public final class DateTimeUtil {
    public static final String FMT_YYYY_MM_DD_WITH_HYPHEN = "yyyy-MM-dd";
    public static final String FMT_YYYY_MM_DD_HH_MM_SS_WITH_HYPHEN = "yyyy-MM-dd HH:mm:ss";
    public static final String FMT_YYYY_MM_DD_HH_MM_SS_SSS_WITH_HYPHEN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String FMT_YYYY_MM = "yyyy/MM";
    public static final String FMT_MM_DD = "MM/dd";
    public static final String FMT_YYYY_MM_DD = "yyyy/MM/dd";
    public static final String FMT_YYYY_MM_DD_HH_MM_SS = "yyyy/MM/dd HH:mm:ss";
    public static final String FMT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String FMT_HH_MM_SS = "HH:mm:ss";
    public static final String FMT_HH_MM = "HH:mm";
    public static final String FMT_YYYYMM = "yyyyMM";
    public static final String FMT_YYYYMMDD = "yyyyMMdd";
    public static final String FMT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String FMT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String FMT_HHMM = "HHmm";
    public static final String FMT_HHMMSS = "HHmmss";
    public static final String FMT_ELLIPSIS_DAY_OF_WEEK = "E";
    public static final String FMT_DAY_OF_WEEK = "EEEE";
    private DateTimeUtil() {
    }

    public static Date toDate(GregorianCalendar calendar) {
        //TODO-AssertUtil.assertNotNull(calendar, "calendar");

        return calendar.getTime();
    }
    public static GregorianCalendar toGregorianCalendar(Date date) {
    	//TODO-AssertUtil.assertNotNull(date, "date");

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(date);

        return calendar;
    }
    public static Date set(int type, int value, Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        GregorianCalendar calendar = toGregorianCalendar(date);

        calendar.set(type, value);

        return toDate(calendar);
    }
    public static Date setMillisecond(Date date, int millisecond) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(millisecond);

        return set(Calendar.MILLISECOND, millisecond, date);
    }
    public static Date toDate(int year, int month, int day) {
    	//TODO-AssertUtil.assertTrue(year>0);
    	//TODO-AssertUtil.assertTrue(month>0);
    	//TODO-AssertUtil.assertTrue(day>0);

        return toDate(
                    new GregorianCalendar(
                            year,
                            month - 1,
                            day,
                            0,
                            0,
                            0));
    }
    public static Date toDate(int year, int month, int day, int hour, int minute, int second) {
    	//TODO-AssertUtil.assertTrue(year > 0);
    	//TODO-AssertUtil.assertTrue(month > 0);
    	//TODO-AssertUtil.assertTrue(day > 0);
    	//TODO-AssertUtil.assertTrue(hour >= 0);
    	//TODO-AssertUtil.assertTrue(minute >= 0);
    	//TODO-AssertUtil.assertTrue(second >= 0);

        return toDate(
                new GregorianCalendar(
                        year,
                        month - 1,
                        day,
                        hour,
                        minute,
                        second));
    }

	public static Date toDate(int year, int month, int day, int hour,
			int minute, int second, int millisec) {
		//TODO-AssertUtil.assertTrue(year > 0);
		//TODO-AssertUtil.assertTrue(month > 0);
		//TODO-AssertUtil.assertTrue(day > 0);
		//TODO-AssertUtil.assertTrue(hour >= 0);
		//TODO-AssertUtil.assertTrue(minute >= 0);
		//TODO-AssertUtil.assertTrue(second >= 0);
		//TODO-AssertUtil.assertTrue(millisec >= 0);

		Date date = toDate(new GregorianCalendar(year, month - 1, day, hour,
				minute, second));

		date = setMillisecond(date, millisec);

		return date;
	}
    public static Date toDate(long time) {
    	//TODO-AssertUtil.assertTrue(time >= 0);

        Date date = new Date();

        date.setTime(time);

        return date;
    }
    public static GregorianCalendar toGregorianCalendar(long time) {
    	//TODO-AssertUtil.assertTrue(time >= 0);

        return toGregorianCalendar(toDate(time));
    }
    public static String format(Date date, String format, Locale locale) {
    	//TODO-AssertUtil.assertNotNull(date, "date");
    	//TODO-AssertUtil.assertNotEmpty(format, "format");
    	//TODO-AssertUtil.assertNotNull(locale, "locale");

        SimpleDateFormat formatter;
        try {
            formatter = new SimpleDateFormat(format, locale);

        } catch (IllegalArgumentException e) {
            throw new GenericRuntimeException("It is not the date.", e);
        }

        return formatter.format(date);
    }
    public static String format(Date date, String format) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotEmpty(format);

        return format(date, format, Locale.getDefault());
    }
    public static Date parse(String date, String format, Locale locale) {
    	//TODO-AssertUtil.assertNotEmpty(date, "date");
    	//TODO-AssertUtil.assertNotEmpty(format, "format");
    	//TODO-AssertUtil.assertNotNull(locale, "locale");

        SimpleDateFormat formatter;

        try {
            formatter = new SimpleDateFormat(format, locale);

        } catch (IllegalArgumentException e) {
            throw new GenericRuntimeException("It is not the date.", e);
        }

        // Make the strict analysis
        formatter.setLenient(false);

        Date parsedDate = null;
        try {
            parsedDate = formatter.parse(date);
        } catch (ParseException e) {
            throw new GenericRuntimeException("It is not the date.", e);
        }

        return parsedDate;
    }
    public static Date parse(String date, String format) {
    	//TODO-AssertUtil.assertNotEmpty(date);
    	//TODO-AssertUtil.assertNotEmpty(format);

        return parse(date, format, Locale.getDefault());
    }
    public static Date truncDate(Date date, String format) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotEmpty(format);

        String result = format(date, format);

        return parse(result, format);
    }
    public static Date truncDate(Date date, String format, Locale locale){
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotEmpty(format);
    	//TODO-AssertUtil.assertNotNull(locale);

        String result = format(date, format, locale);

        return parse(result, format, locale);
    }
    public static int get(int type, Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        GregorianCalendar calendar = toGregorianCalendar(date);

        return calendar.get(type);
    }
    public static int getYear(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.YEAR, date);
    }
    public static int getMonth(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.MONTH, date) + 1;
    }
    public static int getDay(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.DATE, date);
    }
    public static int getHour(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.HOUR_OF_DAY, date);
    }
    public static int getMinute(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.MINUTE, date);
    }
    public static int getSecond(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.SECOND, date);
    }
    public static int getMillisecond(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return get(Calendar.MILLISECOND, date);
    }
    public static String getDayOfWeek(Date date, Locale locale) {
        SimpleDateFormat format = new SimpleDateFormat(FMT_ELLIPSIS_DAY_OF_WEEK, locale);

        return format.format(date);
    }
    public static String getDayOfWeek(Date date) {
        return getDayOfWeek(date, Locale.getDefault());
    }
    public static Date add(int field, int amount, Date date) {
    	//TODO-AssertUtil.assertNotNull(field);
    	//TODO-AssertUtil.assertNotNull(date);

        GregorianCalendar calendar = toGregorianCalendar(date);

        calendar.add(field, amount);

        return toDate(calendar);
    }
    public static Date addMonth(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.MONTH, amount, date);
    }
    public static Date addDay(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.DATE, amount, date);
    }
    public static int getLastDayOfMonth(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        Date result = truncDate(date, FMT_YYYY_MM);
        result = addMonth(result, 1);
        result = addDay(result, -1);

        return getDay(result);
    }
    public static Date setYear(Date date, int year) {
    	//TODO-AssertUtil.assertNotNull(date);

        return set(Calendar.YEAR, year, date);
    }
    public static Date setMonth(Date date, int month) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(month);

        return set(Calendar.MONTH, month - 1, date);
    }
    public static Date setDay(Date date, int day) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(day);

        return set(Calendar.DATE, day, date);
    }
    public static Date setHour(Date date, int hour) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(hour);

        return set(Calendar.HOUR_OF_DAY, hour, date);
    }
    public static Date setMinute(Date date, int minute) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(minute);

        return set(Calendar.MINUTE, minute, date);
    }
    public static Date setSecond(Date date, int second) {
    	//TODO-AssertUtil.assertNotNull(date);
    	//TODO-AssertUtil.assertNotNull(second);

        return set(Calendar.SECOND, second, date);
    }
    public static Date addYear(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.YEAR, amount, date);
    }
    public static Date addHour(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.HOUR_OF_DAY, amount, date);
    }
    public static Date addMinute(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.MINUTE, amount, date);
    }
    public static Date addSecond(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.SECOND, amount, date);
    }
    public static Date addMillisecond(Date date, int amount) {
    	//TODO-AssertUtil.assertNotNull(date);

        return add(Calendar.MILLISECOND, amount, date);
    }
    public static String toString(Date date) {
    	//TODO-AssertUtil.assertNotNull(date);

        return format(date, FMT_YYYY_MM_DD_HH_MM_SS_SSS);
    }
    public static boolean equalsDate(Date date1, Date date2) {
    	//TODO-AssertUtil.assertNotNull(date1);
    	//TODO-AssertUtil.assertNotNull(date2);

        return truncDate(date1, FMT_YYYY_MM_DD).equals(truncDate(date2, FMT_YYYY_MM_DD));
    }
}
