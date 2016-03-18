/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db.sqlite;

/**
 * SQLite update class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public interface SQLiteUpdate {
    String[] update(int oldVersion, int newVersion);
}
