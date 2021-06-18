package com.ha.slidingwindow;

import java.sql.Timestamp;

public class Point implements Comparable<Point>, ChronologicalRecord {

    private final Integer value;
    private final Timestamp timestamp;

    public Point(Integer value, Timestamp timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Point o) {
        return this.timestamp.compareTo(o.timestamp);
    }

    @Override
    public String toString() {
        return "Point{" +
                "value=" + value +
                ", timestamp=" + timestamp +
                '}';
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Timestamp getTimestamp() {
        return timestamp;
    }
}
