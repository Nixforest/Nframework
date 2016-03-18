/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db;

import java.util.List;
import java.util.Map;

import nixforest.cpn.nframework.commons.exception.BaseDBException;


/**
 * Database connection class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public interface DbCon {
	DbCon connect(boolean readOnlyFlg) throws BaseDBException;
    void close() throws BaseDBException;
    void startTransaction() throws BaseDBException;
    void commit() throws BaseDBException;
    void rollback() throws BaseDBException;
    List<Map<String, Object>> select(String sql) throws BaseDBException;
    List<Map<String, Object>> select(String sql, String[] param) throws BaseDBException;
    List<Map<String, Object>> select(String sql, List<String> param) throws BaseDBException;
    List<Map<String, Object>> select(String sql, int limit, int offset) throws BaseDBException;
    List<Map<String, Object>> select(String sql, String[] param, int limit,
            int offset) throws BaseDBException;
    List<Map<String, Object>> select(String sql, List<String> param, int limit,
            int offset) throws BaseDBException;
    //TODO-DBCursor openCursor(String sql) throws BaseDBException;
    //TODO-DBCursor openCursor(String sql, String[] param) throws BaseDBException;
    //TODO-DBCursor openCursor(String sql, List<String> param) throws BaseDBException;
    long executeUpdate(String sql) throws BaseDBException;
    //TODO-long executeUpdate(String sql, DBParameter parameter) throws BaseDBException;
    void executeDDL(String sql) throws BaseDBException;
    boolean inTransaction() throws BaseDBException;
    boolean isClosed() throws BaseDBException;
    //TODO-void initialize(String name, boolean isReadOnly, DBConfig dbConfig) throws BaseDBException;
    String getName();
    boolean isReadOnly();
}
