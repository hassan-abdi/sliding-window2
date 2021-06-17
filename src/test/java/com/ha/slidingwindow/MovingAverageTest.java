package com.ha.slidingwindow;

import org.junit.jupiter.api.Test;

import static com.ha.utility.DateUtils.toTimestamp;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovingAverageTest {

    @Test
    public void calculateAverageWithSimpleMovingWindow(){
        MovingAverage movingAverage = new MovingAverage(2);
        double average1 = movingAverage.average(new Point(10, toTimestamp("Nov 12, 2018 13:02:56.12345678")));
        double average2 = movingAverage.average(new Point(18, toTimestamp("Nov 12, 2018 13:02:56.12345679")));
        double average3 = movingAverage.average(new Point(12, toTimestamp("Nov 12, 2018 13:02:56.12345677")));
        double average4 = movingAverage.average(new Point(8, toTimestamp("Nov 12, 2018 13:02:56.12345680")));
        double average5 = movingAverage.average(new Point(1, toTimestamp("Nov 12, 2018 13:02:56.12345681")));
        assertEquals(10, average1);
        assertEquals(14, average2);
        assertEquals(15, average3);
        assertEquals(13, average4);
        assertEquals(4.5, average5);
    }
}