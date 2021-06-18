package com.ha.slidingwindow;

import java.sql.Timestamp;

public class StockPrice implements Comparable<StockPrice>, ChronologicalRecord {

    private final Double value;
    private final Timestamp timestamp;

    public StockPrice(Double value, Timestamp timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    @Override
    public int compareTo(StockPrice o) {
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
    public Double getValue() {
        return value;
    }

    @Override
    public Timestamp getTimestamp() {
        return timestamp;
    }
}
