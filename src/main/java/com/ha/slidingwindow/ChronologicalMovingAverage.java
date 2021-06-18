package com.ha.slidingwindow;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ChronologicalMovingAverage<E extends ChronologicalRecord> implements MovingAverage<E> {
    private final int windowLength;
    private final Queue<E> queue;
    private Double sum;

    public ChronologicalMovingAverage(int windowLength) {
        this.windowLength = windowLength;
        this.queue = new PriorityBlockingQueue<>();
        this.sum = 0D;
    }

    @Override
    public double next(E record) {
        if (!queue.isEmpty()) {
            while (getActualWindowSize(record) > windowLength) {
                E headRecord = queue.remove();
                sum = sum - headRecord.getValue().doubleValue();
            }
        }
        queue.offer(record);
        sum = sum + record.getValue().doubleValue();
        return sum / queue.size();
    }

    private long getActualWindowSize(E record) {
        return record.getTimestamp().getTime() - Objects.requireNonNull(queue.peek()).getTimestamp().getTime();
    }
}