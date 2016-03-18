/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db;

import java.util.Map;

import nixforest.cpn.nframework.commons.config.ConfigKeys;

/**
 * Database connection class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public class DbConfig {
	/** Memory within the database file name setting */
    private static final String IN_MEMORY_DB_FILE_NAME = "null";
    /** Connection implementation class */
    private String mConnection;
    /** Database name */
    private String mDBName;
    /** Database version */
    private int mDBVersion = -1;
    /** ISOLATION LEVEL (transaction isolation level) */
    private String mIsolationLevel;
    /** Lock mode */
    private String mLockMode;
    /** SQL-defined classes when the application is first operation */
    private String mInitializeClass;
    /** SQL-defined classes at the DB version up */
    private String mUpdateClass;
    
    /**
     * Constructor.
     * @param config DB configuration map
     */
    public DbConfig(Map<String, String> config) {
        mConnection = config.get(ConfigKeys.DB_CONNECTION_KEY);
        
        if (!config.get(ConfigKeys.DB_NAME_KEY).equals(
                IN_MEMORY_DB_FILE_NAME)) {
            mDBName = config.get(ConfigKeys.DB_NAME_KEY);
        }

        if (config.containsKey(ConfigKeys.DB_VERSION_KEY)) {
            mDBVersion = Integer.parseInt(config.get(ConfigKeys.DB_VERSION_KEY));
        }

        // ISORATION LEVEL
        mIsolationLevel = config.get(ConfigKeys.DB_ISOLATION_LEVEL_KEY);

        mLockMode = config.get(ConfigKeys.DB_LOCK_MODE_KEY);

        mInitializeClass = config.get(ConfigKeys.DB_INITIALIZE_CLASS_KEY);

        mUpdateClass = config.get(ConfigKeys.DB_UPDATE_CLASS_KEY);

    }

    public String getConnection() {
        return mConnection;
    }

    public String getDBName() {
        return mDBName;
    }

    public int getDBVersion() {
        return mDBVersion;
    }

    public String getIsolationLevel() {
        return mIsolationLevel;
    }

    public String getLockMode() {
        return mLockMode;
    }

    public String getInitializeClass() {
        return mInitializeClass;
    }

    public String getUpdateClass() {
        return mUpdateClass;
    }
}
