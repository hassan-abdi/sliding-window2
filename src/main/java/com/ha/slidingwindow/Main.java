package com.ha.slidingwindow;

import java.sql.Timestamp;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {54, 6, 40, 33, 90, 10, 8, 45, 8, 11, 10, 34 };
        PriorityWindowAverage movingAverage = new PriorityWindowAverage(3);
        long time = new Date().getTime();
        for (int value : numbers){
            movingAverage.add(new Point(value, new Timestamp(time + value)));
        }
        movingAverage.averages().forEach(items -> System.out.println("items = " + items));
    }
}
