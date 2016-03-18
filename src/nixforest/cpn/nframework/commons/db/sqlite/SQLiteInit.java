/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db.sqlite;

/**
 * Database connection class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public interface SQLiteInit {

    /**
     * To get the SQL array to be executed.
     * @return SQL sequences that run
     */
    String[] init();

}
