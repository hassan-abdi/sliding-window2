package com.ha.slidingwindow;

import java.sql.Timestamp;

public class Inventory implements Comparable<Inventory>, ChronologicalRecord {

    private final Integer value;
    private final Timestamp timestamp;

    public Inventory(Integer value, Timestamp timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(Inventory o) {
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
