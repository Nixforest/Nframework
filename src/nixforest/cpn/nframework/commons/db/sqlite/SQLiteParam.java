/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db.sqlite;

import java.util.ArrayList;
import java.util.List;

import nixforest.cpn.nframework.commons.db.DbParam;
import nixforest.cpn.nframework.commons.exception.BaseDBException;

/**
 * SQLite parameter class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public class SQLiteParam implements DbParam {

    /** Parameter type - Blob */
    public static final int TYPE_BLOB = 0;

    /** Parameter type - Long */
    public static final int TYPE_LONG = 1;

    /** Parameter type - Double */
    public static final int TYPE_DOUBLE = 2;

    /** Parameter type - Null */
    public static final int TYPE_NULL = 3;

    /** Parameter type - String */
    public static final int TYPE_STRING = 4;

    /** Header array */
    private int[] mHeader;

    /** Parameter list */
    private List<Object[]> mParamList;

    public SQLiteParam(Object[] params) throws BaseDBException {
        List<Object[]> paramList = new ArrayList<Object[]>();
        paramList.add(params);
        init(null, paramList);
    }

    public SQLiteParam(List<Object[]> paramList) throws BaseDBException {
        //TODO-AssertUtil.assertNotNull(paramList, "paramList");
    	//TODO-AssertUtil.assertTrue(paramList.size() > 0, "paramList size is larger than 0");
        init(null, paramList);
    }
    
    public SQLiteParam(int[] type, Object[] params) throws BaseDBException {
    	//TODO-AssertUtil.assertNotNull(params, "params");
        List<Object[]> paramList = new ArrayList<Object[]>();
        paramList.add(params);
        init(type, paramList);
    }

    public SQLiteParam(int[] type, List<Object[]> paramList)
            throws BaseDBException {
    	//TODO-AssertUtil.assertNotNull(paramList, "paramList");
    	//TODO-AssertUtil.assertTrue(paramList.size() > 0, "paramList size is larger than 0");
        init(type, paramList);
    }

    private void init(int[] type, List<Object[]> paramList) throws BaseDBException {
        int olen = paramList.get(0).length;

        // Make sure that the sequence number of parameters is the same on all the lines.
        for(Object[] o : paramList) {
        	//TODO-AssertUtil.assertTrue(olen == o.length, "paramList is not same columns");
        }
        if (type != null) {
        	//TODO-AssertUtil.assertTrue(type.length == olen, "type.length = ["
//                    + Integer.toString(type.length) + "] param.length = ["
//                    + Integer.toString(olen) + "]");
            for (int t : type) {
                if (t != TYPE_BLOB && t != TYPE_DOUBLE && t != TYPE_LONG
                        && t != TYPE_NULL & t != TYPE_STRING) {
                    throw new BaseDBException("cannot use type : "
                            + Integer.toString(t));
                }
            }
        }

        mHeader = type;
        mParamList = paramList;
    }

    @Override
    public int[] getHeader() {
        return mHeader;
    }

    @Override
    public List<Object[]> getParameterList() {
        return mParamList;
    }

}
