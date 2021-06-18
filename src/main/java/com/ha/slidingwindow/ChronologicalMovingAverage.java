package com.ha.slidingwindow;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class ChronologicalMovingAverage<E extends ChronologicalRecord> implements MovingAverage<E> {
    private final Long timeFrameInMilliSeconds;
    private final Queue<E> queue;
    private Double sum;

    public ChronologicalMovingAverage(Long timeFrameInMilliSeconds) {
        this.timeFrameInMilliSeconds = timeFrameInMilliSeconds;
        this.queue = new PriorityBlockingQueue<>();
        this.sum = 0D;
    }

    @Override
    public double next(E record) {
        while ((!queue.isEmpty()) && getActualWindowSize(record) > timeFrameInMilliSeconds) {
            E headRecord = queue.remove();
            sum = sum - headRecord.getValue().doubleValue();
        }
        queue.add(record);
        sum = sum + record.getValue().doubleValue();
        return sum / queue.size();
    }

    private long getActualWindowSize(E record) {
        return record.getTimestamp().getTime() - queue.element().getTimestamp().getTime();
    }
}