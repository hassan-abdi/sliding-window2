package com.ha.slidingwindow;

import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class MovingAverage {
    private final int length;
    private final Queue<Point> queue;
    private double sum;

    public MovingAverage(int length) {
        this.length = length;
        queue = new PriorityBlockingQueue<>();
        sum = 0;
    }

    public double average(Point point){
        if (length == queue.size()){
            Point last = queue.remove();
            sum = sum - last.getValue();
        }
        queue.add(point);
        sum = sum + point.getValue();
        return sum / queue.size();
    }
}