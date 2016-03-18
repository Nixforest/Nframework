/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.db;

import java.util.List;


/**
 * Database parameter class.
 * @author Nixforest
 * @date Mar 18, 2016
 */
public interface DbParam {
    int[] getHeader();
    List<Object[]> getParameterList();
}
