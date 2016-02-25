/**
  * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.util;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * @author Nixforest
 * @date Feb 21, 2016
 */
public final class ValidateUtil {
	/** Number characters */
	private static final String NUMBER_CHAR = "0123456789-";
	/** Replacement code */
	private static final char REPLACEMENT_CHARACTER = '\uFFFD';
	
	/**
	 * Default constructor.
	 */
	private ValidateUtil() {
    }
	
	/**
	 * Check if string is null or empty.
	 * @param text String to check
	 * @return True if null or empty, false otherwise
	 */
	public static boolean isEmpty(String text) {
        if (text == null || text.length() == 0) {
            return true;
        }
        return false;
    }
	
	/**
	 * Check if string is ASCII string.
	 * @param text String to check
	 * @return True if string is ASCII string, false otherwise
	 */
	public static boolean isAscii(String text) {
        if (text == null) {
            return false;
        }
        if (text.length() == 0) {
            return true;
        }

        int length = text.length();
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (!(ch >= 0 && ch <= 0x7F)) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * Make a comparison of the string.
	 * @param text String value
	 * @param consistValue
	 * @return
	 */
    public static boolean isComposedOf(String text, String consistValue) {
        //TODO-AssertUtil.assertNotEmpty(consistValue, "consistValue");

        if (text == null) {
            return false;
        }
        if (text.length() == 0) {
            return true;
        }

        int length = text.length();
        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (consistValue.indexOf(ch) == -1) {
                return false;
            }
        }

        return true;
    }
    public static boolean doesNotContain(String text, String unacceptableValue) {
    	//TODO-AssertUtil.assertNotEmpty(unacceptableValue, "unacceptableValue");

        if (text == null) {
            return false;
        }
        if (text.length() == 0) {
            return true;
        }

        for (int i = 0; i < unacceptableValue.length(); i++) {
            char ch = unacceptableValue.charAt(i);

            if (text.indexOf(ch) != -1) {
                return false;
            }
        }
        return true;
    }
    public static boolean isDouble(String text) {

        if (isEmpty(text)) {
            return false;
        }

        try {
            Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    public static boolean isFloat(String text) {

        if (isEmpty(text)) {
            return false;
        }

        try {
            Float.parseFloat(text);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
    public static boolean isInt(String text) {

        if (isEmpty(text)) {
            return false;
        }

        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }

        return isComposedOf(text, NUMBER_CHAR);
    }
    public static boolean isLong(String text) {

        if (isEmpty(text)) {
            return false;
        }

        try {
            Long.parseLong(text);
        } catch (NumberFormatException e) {
            return false;
        }

        return isComposedOf(text, NUMBER_CHAR);
    }
    public static boolean isSafeText(String text, String encoding) {

    	//TODO-AssertUtil.assertNotEmpty(encoding, "encoding");

        if (text == null) {
            return false;
        }
        if (text.length() == 0) {
            return true;
        }

        if (text.indexOf(REPLACEMENT_CHARACTER) != -1) {
            return false;
        }

        CharsetEncoder encoder = null;
        boolean ret = false;
        try {
            encoder = Charset.forName(encoding).newEncoder();
            ret = encoder.canEncode(text);

        } catch (Exception e) {
            //TODO-throw new GenericRuntimeException("It is invalid encoding.", e);
        }
        return ret;
    }
    public static boolean isMinByteLength(String text, int min, String encoding) {
    	//TODO-AssertUtil.assertNotEmpty(encoding, "encoding");

        if (text == null) {
            return false;
        }
        byte[] byteData = StringUtil.getBytes(text, encoding);
        return byteData.length >= min;
    }
}
