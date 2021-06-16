package com.ha.slidingwindow;

import java.sql.Timestamp;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        int[] numbers = {54, 6, 40, 33, 90, 10, 8, 45, 8, 11, 10, 34 };
        int[] numbers = {1, 10, 3, 5};
        MovingAverage movingAverage = new MovingAverage(3);
        long time = new Date().getTime();
        for (int value : numbers){
            double average = movingAverage.calc(new Point(value, new Timestamp(time + value)));
            System.out.println("average = " + average);
        }

    }
}
