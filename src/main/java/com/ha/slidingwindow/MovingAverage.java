package com.ha.slidingwindow;

import java.io.Serializable;

public interface MovingAverage<E extends Serializable> {
    double next(E record);
}