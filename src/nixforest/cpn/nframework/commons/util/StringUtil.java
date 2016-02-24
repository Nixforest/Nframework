/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;




/**
 * This is a utility class about the string.
 * @author Nixforest
 * @date Feb 21, 2016
 */
public class StringUtil {
	/** CR (0x0D) */
    public static final char CR = '\r';
    /** LF (0x0A) */
    public static final char LF = '\n';
    /** Half-size character */
    private static final String HALF_STRING = " !\"#$%&'()*+,-./"
									            + "0123456789:;<=>?"
									            + "@ABCDEFGHIJKLMNO"
									            + "PQRSTUVWXYZ[\\]^_"
									            + "`abcdefghijklmno"
									            + "pqrstuvwxyz{|}~"
									            + "｡｢｣､･ｦｧｨｩｪｫｬｭｮｯ"
									            + "ｰｱｲｳｴｵｶｷｸｹｺｻｼｽｾｿ"
									            + "ﾀﾁﾂﾃﾄﾅﾆﾇﾈﾉﾊﾋﾌﾍﾎﾏ"
									            + "ﾐﾑﾒﾓﾔﾕﾖﾗﾘﾙﾚﾛﾜﾝﾞﾟ";
    /** Full-size character */
    private static final String WIDE_STRING = "　！”＃＄％＆’（）＊＋，－．／"
									            + "０１２３４５６７８９：；＜＝＞？"
									            + "＠ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯ"
									            + "ＰＱＲＳＴＵＶＷＸＹＺ［￥］＾＿"
									            + "‘ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏ"
									            + "ｐｑｒｓｔｕｖｗｘｙｚ｛｜｝～"
									            + "。「」、・ヲァィゥェォャュョッ"
									            + "ーアイウエオカキクケコサシスセソ"
									            + "タチツテトナニヌネノハヒフヘホマ"
									            + "ミムメモヤユヨラリルレロワン゛゜";
    /** An array of single-byte characters */
    private static final char[] HALF_CHARACTER = HALF_STRING.toCharArray();
    /** An array of double-byte characters */
    private static final char[] WIDE_CHARACTER = WIDE_STRING.toCharArray();
    /** Half-size to full-size conversation */
    private static final String[][] HALF_WIDE_KANA_STRING = {
        {"ｶﾞ", "ｷﾞ", "ｸﾞ", "ｹﾞ", "ｺﾞ",
         "ｻﾞ", "ｼﾞ", "ｽﾞ", "ｾﾞ", "ｿﾞ",
         "ﾀﾞ", "ﾁﾞ", "ﾂﾞ", "ﾃﾞ", "ﾄﾞ",
         "ﾊﾞ", "ﾋﾞ", "ﾌﾞ", "ﾍﾞ", "ﾎﾞ",
         "ﾊﾟ", "ﾋﾟ", "ﾌﾟ", "ﾍﾟ", "ﾎﾟ" },
        {"ガ", "ギ", "グ", "ゲ", "ゴ",
         "ザ", "ジ", "ズ", "ゼ", "ゾ",
         "ダ", "ヂ", "ヅ", "デ", "ド",
         "バ", "ビ", "ブ", "ベ", "ボ",
         "パ", "ピ", "プ", "ペ", "ポ" }
    };
    /** Double quotes */
    private static final String DQ = "\"";
    /** null */
    private static final String NULL_C = "\u0000";
    /** Half-size space */
    private static final char HALF_SPACE = '\u0020';
    /** Full-size space */
    private static final char WIDE_SPACE = '\u3000';
    /** Unicode double mapping character (- ~ ∥- ¢ £ ¬) */
    private static final char[][] DOUBLE_MAPPING_CHARS = {
        {'\u2014', '\u2015'},
        {'\u301c', '\uff5e'},
        {'\u2016', '\u2225'},
        {'\u2212', '\uff0d'},
        {'\u00a2', '\uffe0'},
        {'\u00a3', '\uffe1'},
        {'\u00ac', '\uffe2'}
    };
    /** Random character string generation object character */
    private static final String RANDOM_STRINGS_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
											            + "abcdefghijklmnopqrstuvwxyz"
											            + "0123456789";
    
    /**
     * Default constructor.
     */
    private StringUtil() {
    }
    
    /**
     * It gets a string of the specified number of characters from 
     * the beginning of the string.
     * @param text String (null is not allowed)
     * @param len Get the number of characters
     * 				(a negative number is not allowed)
     * @return Number of characters of the character
     * 		 string specified from the end
     */
    public static String right(String text, int len) {
        //TODO-AssertUtil.assertNotNull(text, "text");
        //TODO-AssertUtil.assertTrue(len >= 0, "len");

        int length = text.length();
        if (length <= len) {
            return text;
        }
        char[] chars = text.toCharArray();

        return new String(chars, length - len, len);
    }
    
    /**
     * It gets a string of number of characters that have been specified
     * from the beginning of the string
     * @param text String (null is not allowed)
     * @param len Get the number of characters
     * 				(a negative number is not allowed)
     * @return Number of characters of the character string
     * 			specified at the beginning
     */
    public static String left(String text, int len) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertTrue(len >= 0, "len");

        int length = text.length();

        if (length <= len) {
            return text;
        }

        char[] chars = text.toCharArray();

        return new String(chars, 0, Math.min(len, length));
    }
    
    /**
     * From a designated place of the string (0 counting) gets a string of behind.
     * @param text String (null is not allowed)
     * @param pos Acquisition start position (negative number is not allowed)
     * @return String return from a designated place
     */
    public static String mid(String text, int pos) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertTrue(pos >= 0, "pos");

        int length = text.length();

        if (pos >= length) {
            return "";
        }

        char[] chars = text.toCharArray();

        return new String(chars, pos, Math.min(length - pos, length));
    }
    
    /**
     * Character specified location (0 counting) of the column to get the string
     * of the specified number of characters from.
     * @param text String (null is not allowed)
     * @param pos Acquisition start position (negative number is not allowed)
     * @param len Get the number of characters (a negative number is not allowed)
     * @return String of number of characters from the specified location
     */
    public static String mid(String text, int pos, int len) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertTrue(pos >= 0, "pos");
    	//TODO-AssertUtil.assertTrue(len >= 0, "len");

        int length = text.length();
        if (pos >= length) {
            return "";
        }

        char[] chars = text.toCharArray();

        return new String(chars, pos, Math.min(length - pos, len));
    }
    
    /**
     * Both ends of the tab of the string, remove the spaces and control characters.
     * @param text String (null is not allowed)
     * @return Text is removed tab, space and control characters
     */
    public static String trim(String text) {
    	//TODO-AssertUtil.assertNotNull(text, "text");

        String s =text.replace('\t', ' ').trim();

        return s;
    }
    
    /**
     * From a string, to remove the specified character.
     * @param text String (null is not allowed)
     * @param removeText Character to be removed (null and empty is not allowed)
     * @return String after removal of the characters in removeText
     */
    public static String removeChars(String text, String removeText) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertNotEmpty(removeText, "removeText");

        List<Character> list = new ArrayList<Character>();

        // Analyze remove text
        int remLen = removeText.length();
        for (int remIdx = 0; remIdx < remLen; remIdx++) {
            char ch = removeText.charAt(remIdx);

            // Double-mapping characters both letters subject to removal.
            for (int dblMpgIdx = 0; dblMpgIdx < DOUBLE_MAPPING_CHARS.length; dblMpgIdx++) {
                if (ch == DOUBLE_MAPPING_CHARS[dblMpgIdx][0]) {
                    list.add(Character
                            .valueOf(DOUBLE_MAPPING_CHARS[dblMpgIdx][1]));
                }
                if (ch == DOUBLE_MAPPING_CHARS[dblMpgIdx][1]) {
                    list.add(Character
                            .valueOf(DOUBLE_MAPPING_CHARS[dblMpgIdx][0]));
                }
            }
            list.add(Character.valueOf(ch));
        }

        char[] chars = new char[list.size()];

        for (int rmvLstIdx = 0; rmvLstIdx < list.size(); rmvLstIdx++) {
            chars[rmvLstIdx] = ((Character) list.get(rmvLstIdx)).charValue();
        }

        // To remove the object character
        StringBuffer retValBuf = new StringBuffer();
        boolean flg;

        for (int ii = 0; ii < text.length(); ii++) {
            flg = false;

            for (int i = 0; i < chars.length; i++) {
                if (text.charAt(ii) == chars[i]) {
                    flg = true;
                    break;
                }
            }

            if (!flg) {
                retValBuf.append(text.charAt(ii));
            }
        }
        String retVal = retValBuf.toString();
        return retVal;
    }
    
    /**
     * Replace text.
     * @param text String (null is not allowed)
     * @param before Before the replacement string (null and empty is not allowed)
     * @param after After the replacement string (null is not allowed)
     * @return String after replace
     */
    public static String replace(String text, String before, String after) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertNotEmpty(before, "before");
    	//TODO-AssertUtil.assertNotNull(after, "after");

        int pos = 0;
        int afterLen = after.length();
        int idx = text.indexOf(before, pos);

        String result = text;

        while (idx >= 0) {
            result = result.substring(0, idx) + after
                    + result.substring(idx + before.length());

            pos = idx + afterLen;
            idx = result.indexOf(before, pos);
        }
        String retVal = result;
        return retVal;
    }
    
    /**
     * If the specified value is null, the empty ("").
     * @param value Value
     * @return If the value is null, return empty
     * 			Otherwise, the value of the toString ()
     */
    public static String nullToEmpty(Object value) {
        String s1;

        if (value == null) {
            s1 = "";
            return s1;
        }
        s1 = value.toString();
        return s1;
    }
    
    /**
     * If the specified value is null, the specified string
     * @param value Value
     * @param defaultValue String to return if value the null
     * @return If the value is null, return the specified string
     * 			Otherwise, the value of the toString ()
     */
    public static String nullToString(Object value, String defaultValue) {
    	//TODO-AssertUtil.assertNotEmpty(defaultValue);
        String s1;

        if (value == null) {
            s1 = defaultValue;
            return s1;
        }
        s1 = value.toString();
        return s1;
    }
    
    /**
     * It converts the double quote marks, as can be recognized.
     * @param text Before the conversion string (null is not allowed)
     * @param separator Delimiter
     * @return String after conversion
     */
    public static String escapeDQ(String text, char separator) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertNotNull(separator);
        String retVal;

        String result = text;

        if (result.indexOf(DQ) != -1) {
            // If double quotes are exist, replace by null
            // Replace all null characters by 2 double quotes
            result = StringUtil.replace(result, DQ, NULL_C);
            result = StringUtil.replace(result, NULL_C, DQ + DQ);
            result = DQ + result + DQ;

        } else if ((result.indexOf(separator) != -1)
                || (result.indexOf(CR) != -1)
                || (result.indexOf(LF) != -1)) {
            result = DQ + result + DQ;
        }
        retVal = result;
        return retVal;
    }
    
    /**
     * Using the specified character encoding, to get the bytes of the string.
     * @param text String (null is not allowed)
     * @param encoding Character encoding name (null or empty is not allowed)
     * @return Byte string that has been converted from a string
     */
    public static byte[] getBytes(String text, String encoding) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertNotEmpty(encoding, "encoding");
        byte[] by;

        //TODO-if (!ValidatorUtil.isSafeText(text, encoding)) {
        //TODO-    throw new GenericRuntimeException("It is invalid encoding.");
        //TODO-}

        byte[] bytes = null;

        try {
            bytes = text.getBytes(encoding);
        } catch (UnsupportedEncodingException e) {
            // isSafeText()で対応済の為、実際にはこのExceptionは発生しない
        	//TODO-throw new GenericRuntimeException("It is invalid encoding.", e);
        }
        by = bytes;
        return by;
    }
    
    /**
     * Present in the string, and then calculate the number of the specified character.
     * @param text String (null is not allowed)
     * @param search Search character
     * @return The number of search characters in a string
     */
    public static int countChar(String text, char search) {
    	//TODO-AssertUtil.assertNotNull(text, "text");
    	//TODO-AssertUtil.assertNotNull(search);
        int c;

        int charCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (search == ch) {
                charCount++;
            }
        }
        c = charCount;
        return c;
    }
    
    /**
     * The string to get the results that were carved by delim.
     * @param target String (null is not allowed) 
     * @param delim String isolate
     * @return A result of cut
     */
    public static String[] split(String target, String delim){
    	//TODO-AssertUtil.assertNotNull(target);
    	//TODO-AssertUtil.assertNotNull(delim);

        String[] st = target.split(delim, -1);
        return st;
    }
}
