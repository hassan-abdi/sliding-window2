package com.ha.slidingwindow;

import java.io.Serializable;

public interface MovingAverage<E extends Serializable> {
    /**
     * Returns moving average in double.
     * In statistics, a moving average is a calculation used to analyze
     * data points by creating a series of averages of different subsets
     * of the full data set. In finance, a moving average (MA)
     * is a stock indicator that is commonly used in technical analysis.
     * <p>
     * This method always returns immediately, whether or not the
     * data exists.
     *
     * @param  record  a real-time number record
     * @return      Returns moving average in double
     */
    double next(E record);
}