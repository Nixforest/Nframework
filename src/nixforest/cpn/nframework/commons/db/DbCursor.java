/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db;

import nixforest.cpn.nframework.commons.exception.BaseDBException;


/**
 * Database connection class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public interface DbCursor {
    void close() throws BaseDBException;
    byte[] getBlob(String columnName) throws BaseDBException;
    int getColumnCount () throws BaseDBException;
    int getColumnIndex(String columnName) throws BaseDBException;
    String getColumnName(int columnIndex) throws BaseDBException;
    String[] getColumnNames () throws BaseDBException;
    int getCount() throws BaseDBException;
    double getDouble(String columnName) throws BaseDBException;
    float getFloat(String columnName) throws BaseDBException;
    int getInt(String columnName) throws BaseDBException;
    long getLong (String columnName) throws BaseDBException;
    String getString (String columnName) throws BaseDBException;
    short getShort (String columnName) throws BaseDBException;
    int getType (String columnName) throws BaseDBException;
    boolean isClosed() throws BaseDBException;
    boolean isFirst() throws BaseDBException;
    boolean isLast() throws BaseDBException;
    boolean isNull(String columnName) throws BaseDBException;
    boolean moveToFirst() throws BaseDBException;
    boolean moveToLast() throws BaseDBException;
    boolean moveToNext() throws BaseDBException;
    boolean moveToPosition(int position) throws BaseDBException;
    boolean moveToPrevious() throws BaseDBException;
    Object getObject(String columnName) throws BaseDBException;
}
