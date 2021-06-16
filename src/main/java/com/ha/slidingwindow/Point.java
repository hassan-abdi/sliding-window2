package com.ha.slidingwindow;

import java.sql.Timestamp;

public class Point implements Comparable<Point>{

    private final Integer value;
    private final Timestamp time;

    public Point(Integer value, Timestamp time) {
        this.value = value;
        this.time = time;
    }

    @Override
    public int compareTo(Point o) {
        return this.time.compareTo(o.time);
    }

    public Integer getValue() {
        return value;
    }

    public Timestamp getTime() {
        return time;
    }
}
