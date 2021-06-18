package com.ha.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ha.slidingwindow.TestDataRepository.getPointsFromTestFile;
import static com.ha.utility.DateUtils.toTimestamp;
import static org.junit.jupiter.api.Assertions.*;

public class ChronologicalMovingAverageTest {

    @Test
    public void calculateAverageWithSimpleMovingWindow(){
        MovingAverage<Point> movingAverage = new ChronologicalMovingAverage<>(2);
        double average1 = movingAverage.next(new Point(10, toTimestamp("Nov 12, 2018 13:02:56.12345678")));
        double average2 = movingAverage.next(new Point(18, toTimestamp("Nov 12, 2018 13:02:56.12345679")));
        double average3 = movingAverage.next(new Point(12, toTimestamp("Nov 12, 2018 13:02:56.12345680")));
        double average4 = movingAverage.next(new Point(8, toTimestamp("Nov 12, 2018 13:02:56.12345681")));
        double average5 = movingAverage.next(new Point(1, toTimestamp("Nov 12, 2018 13:02:56.12345682")));
        assertEquals(10, average1);
        assertEquals(14, average2);
        assertTrue(13.33 - average3 < 1);
        assertEquals(12, average4);
        assertTrue(9.8 - average5 < 1);
    }

    @Test
    public void calculateAverageWithFileMovingWindow(){
        List<Point> points = getPointsFromTestFile();
        assertEquals(36, points.size());
        List<Double> actual = new ArrayList<>();
        MovingAverage<Point> movingAverage = new ChronologicalMovingAverage<>(5);
        points.forEach(point -> actual.add(movingAverage.next(point)));
        assertFalse(actual.isEmpty());
        assertEquals(123, actual.get(0));
        assertEquals(125, actual.get(1));
        assertEquals(157.25, actual.get(3));
        assertEquals(163.4, actual.get(4));
    }
}