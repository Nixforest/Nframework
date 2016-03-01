/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.analysis;

/**
 * @author Nixforest
 * @date Feb 25, 2016
 */
public class FlexCounter {
    private String	mName;
    private SWatch	mStopWatch;
    private long	mCount;
    private Counter	mAlive;
    private long	mMax;
    public FlexCounter() {
        initialize("");
    }
    public FlexCounter(String name) {
        initialize(name);
    }
    public synchronized void initialize(String name){
        mName = name;
        mStopWatch = SWatch.start();
        mCount = 0;
        mAlive = new Counter();
        mMax   = 0;
    }
    public synchronized long increment(){
        //TODO-AssertUtil.assertTrue(mAlive.getCount() >= 0);
    	//TODO-AssertUtil.assertTrue(mCount >= 0);

        mAlive.increment();
        mCount++;

        mMax = Math.max(mAlive.getCount(), mMax);

        return mAlive.getCount();
    }
    public synchronized long decrement(){
    	//TODO-AssertUtil.assertTrue(mAlive.getCount() > 0);
    	//TODO-AssertUtil.assertTrue(mCount > 0);

        mAlive.decrement();

        return mAlive.getCount();
    }
    public synchronized long getAlive(){
        return mAlive.getCount();
    }
    public synchronized long getCount(){
        return mCount;
    }
    public synchronized long getElapseTime(){
        return mStopWatch.getElapsedTime();
    }

    /* (非 Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(mName);
        builder.append(" (alive : max : count) = (");
        builder.append(mAlive.getCount());
        builder.append(" : ");
        builder.append(mMax);
        builder.append(" : ");
        builder.append(mCount);
        builder.append(")");
        return builder.toString();
    }
}
