/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.analysis;

/**
 * @author Nixforest
 * @date Feb 25, 2016
 */
public final class FlexStopWatch extends SWatch {
	/**
	 * The start of the measurement, to get the StopWatch object.
	 * @param base Creation time
	 * @return StopWatch object
	 */
	public static SWatch start(long base) {
		SWatch sw = new FlexStopWatch();
		sw.restart(base);
		return sw;
	}
}
