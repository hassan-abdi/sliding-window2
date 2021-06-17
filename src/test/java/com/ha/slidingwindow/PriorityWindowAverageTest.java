package com.ha.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.ha.slidingwindow.TestDataRepository.getPointsFromTestFile;
import static org.junit.jupiter.api.Assertions.*;

class PriorityWindowAverageTest {

    @Test
    void averagesShouldCalculateAverageAccurately() {
        PriorityWindowAverage windowAverage = new PriorityWindowAverage(5);
        List<Point> points = getPointsFromTestFile();
        assertEquals(36, points.size());
        points.forEach(windowAverage::add);
        List<Double> averages = windowAverage.averages();
        assertFalse(averages.isEmpty());
        assertEquals(32, averages.size());
        assertEquals(149.6, averages.get(0));
        assertEquals(163.4, averages.get(1));
    }
}