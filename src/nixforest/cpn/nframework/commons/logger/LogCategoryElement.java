/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.logger;

import java.util.HashMap;

import nixforest.cpn.nframework.commons.util.StringUtil;

/**
 * The element to hold the log category in a tree structure.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public class LogCategoryElement {
    /** ROOT */
    private static final String ROOT_NAME = "ROOT";

    /** Child nodes */
    private HashMap<String, LogCategoryElement> mChildNodes
            = new HashMap<String, LogCategoryElement>();

    /** Category of node */
    private LogLevel mLogCategory;

    LogCategoryElement(LogLevel logCategory) {
        mLogCategory = logCategory;
    }

    void setNode(String className, LogLevel logCategory) {
        setNode(className.split("\\."), logCategory);
    }

    void setNode(String[] className, LogLevel logCategory) {
        setNode(className, logCategory, 0);
    }

    LogLevel getCategory(String className) {
        return getCategory(className.split("\\."));
    }

    LogLevel getCategory(String[] className) {
        return getCategory(className, 0, mLogCategory);
    }

    String getLogCategoryName(String className) {
        int targetIdx = getLogCategoryNameTargetIndex
                (className.split("\\."), 0, mLogCategory, 0, 0);
        if (targetIdx > -1) {
            return StringUtil.left(className, targetIdx);
        } else {
            // root category
            return ROOT_NAME;
        }
    }

    private void setNode(String[] className, LogLevel logCategory, int position) {
        //TODO-AssertUtil.assertStringArrayNotEmpty(className);
    	//TODO-AssertUtil.assertTrue(position >= 0);

        if (position == className.length) {
            mLogCategory = logCategory;
            return;
        } else {
            if (!mChildNodes.containsKey(className[position])) {
                mChildNodes.put(className[position], new LogCategoryElement(null));
            }
            mChildNodes.get(className[position]).setNode(className, logCategory, position + 1);
        }
    }

    private LogLevel getCategory(String[] className, int position, LogLevel logCategory) {
        LogLevel currentLogCategory ;
        if (mLogCategory == null) {
            currentLogCategory = logCategory;
        } else {
            currentLogCategory = mLogCategory;
        }
        if (position == className.length) {
            return currentLogCategory;
        }
        if (!mChildNodes.containsKey(className[position])) {
            return currentLogCategory;
        }
        return mChildNodes.get(className[position])
                .getCategory(className, position + 1, currentLogCategory);
    }

    private int getLogCategoryNameTargetIndex(String[] className, int position,
            LogLevel logCategory, int targetIdxNow, int positionIdx) {
        LogLevel currentLogCategory;
        int targetIdx = targetIdxNow;
        if (mLogCategory == null) {
            currentLogCategory = logCategory;
        } else {
            currentLogCategory = mLogCategory;
            targetIdx = positionIdx - 1;
        }
        if (position == className.length) {
            return targetIdx;
        }
        if (!mChildNodes.containsKey(className[position])) {
            return targetIdx;
        }
        int currentIdx = positionIdx + className[position].length() + 1;
        return mChildNodes.get(className[position])
                .getLogCategoryNameTargetIndex(className, position + 1, currentLogCategory,
                        targetIdx, currentIdx);
    }

    void setLogCategory(LogLevel logCategory) {
        mLogCategory = logCategory;
    }
}
