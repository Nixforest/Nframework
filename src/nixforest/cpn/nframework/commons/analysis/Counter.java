/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.analysis;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Nixforest
 * @date Feb 25, 2016
 */
public class Counter {
	/**
	 * Count.
	 */
    private AtomicLong mCount;
    public Counter() {
        this(0);
    }
    public Counter(long count) {
        mCount = new AtomicLong(count);
    }
    public long getCount() {
        return mCount.get();
    }
    public long increment() {
        return mCount.incrementAndGet();
    }
    public long decrement() {
        return mCount.decrementAndGet();
    }
}
