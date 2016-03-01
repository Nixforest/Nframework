/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.analysis;

/**
 * Stop Watch
 * @author Nixforest
 * @date Feb 24, 2016
 */
public class SWatch {
    private long mStart;
    private long mStop;
    private boolean mbStop;

    /**
     * Default constructor.
     */
    protected SWatch() {
    }
    
    /**
     * Start new object.
     * @return
     */
    public static SWatch start() {
    	SWatch sw = new SWatch();
        sw.restart();
        return sw;
    }
    
    /**
     * Re-set the measurement start time.
     */
    public void restart() {
        restart(System.currentTimeMillis());
    }
    
    /**
     * Re-set the measurement start time.
     * @param base Creation time
     */
    protected void restart(long base) {
        mStart = base;
        mStop = 0;
        mbStop = false;
    }
    
    /**
     * Get if clock is stopped.
     * @return Stop or not
     */
    protected boolean isStop() {
        return mbStop;
    }
    
    /**
     * Get elapsed time.
     * @return Elapsed time
     */
    public long getElapsedTime() {
        long elapsed = 0;
        if (mbStop) {
            // Get stop time
            elapsed = mStop;
        } else {
            // If clock is running, calculate stop elapsed time
            elapsed = System.currentTimeMillis() - mStart;
        }
        return elapsed;
    }
    
    /**
     * Stop the measurement, to get the processing time.
     * @return Elapsed time
     */
    public long stop() {
        if (!mbStop) {
            // Calculate elapsed time
            mStop = System.currentTimeMillis() - mStart;
            mbStop = true;
        }
        long elapsed = mStop;
        return elapsed;
    }
}
