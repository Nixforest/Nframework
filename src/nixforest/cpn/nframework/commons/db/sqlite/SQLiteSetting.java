/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db.sqlite;

import nixforest.cpn.nframework.commons.db.DbConfig;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Database connection class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
class SQLiteSetting {
    /** Database distinguished name */
    private String mName;
    
    /** Read-only file */
    private boolean mIsReadOnly;
    
    /** Context */
    private Context mContext;
    
    /** Database name */
    private String mDBName;
    
    /** Database version */
    private int mDBVersion;
    
    /** Cursor Factory */
    private CursorFactory mCursorFactory;
    
    /**
     * Constructor,
     * @param name Database distinguished name
     * @param dbConfig Database config
     */
    public SQLiteSetting(String name, DbConfig dbConfig) {
        //TODO-AssertUtil.assertNotEmpty(name, "name");
    	//TODO-AssertUtil.assertNotNull(dbConfig, "dbConfig");
        
        mName = name;
        mDBName = dbConfig.getDBName();
        mDBVersion = dbConfig.getDBVersion();
    }
    
    public String getName() {
        return mName;
    }

    public boolean isReadOnly() {
        return mIsReadOnly;
    }

    public void setReadOnly(boolean isReadOnly) {
        this.mIsReadOnly = isReadOnly;
    }

    public Context getContext() {
        return mContext;
    }

    public void setContext(Context context) {
        mContext = context;
    }

    public String getDBName() {
        return mDBName;
    }

    public int getDBVersion() {
        return mDBVersion;
    }

    public CursorFactory getCursorFactory() {
        return mCursorFactory;
    }

    public void setCursorFactory(CursorFactory cursorFactory) {
        mCursorFactory = cursorFactory;
    }
}
