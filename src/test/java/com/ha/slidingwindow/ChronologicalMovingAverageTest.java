package com.ha.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.ha.slidingwindow.TestDataRepository.getPricesFromTestFile;
import static com.ha.utility.DateUtils.toTimestamp;
import static org.junit.jupiter.api.Assertions.*;

public class ChronologicalMovingAverageTest {

    @Test
    public void calculateAverageWithSimpleMovingWindow() {
        MovingAverage<Inventory> movingAverage = MovingAverageBuilder
                .newBuilder()
                .chronological()
                .withMonth(1)
                .build();
        double average;
        average = movingAverage.next(new Inventory(1000, toTimestamp("Jan 12, 2018 13:02:56.123")));
        assertEquals(1000, average);
        average = movingAverage.next(new Inventory(1050, toTimestamp("Jan 13, 2018 13:02:56.123")));
        assertEquals(1025, average);
        average = movingAverage.next(new Inventory(1070, toTimestamp("Jan 14, 2018 13:02:56.123")));
        assertEquals(1040, average);
        average = movingAverage.next(new Inventory(1090, toTimestamp("Feb 12, 2018 13:02:56.123")));
        assertEquals(1070, average);
        average = movingAverage.next(new Inventory(1124, toTimestamp("Feb 17, 2018 13:02:56.123")));
        assertEquals(1107, average);
        average = movingAverage.next(new Inventory(1140, toTimestamp("Mar 12, 2018 13:02:56.123")));
        assertEquals(1118, average);
        average = movingAverage.next(new Inventory(1180, toTimestamp("Mar 19, 2018 13:02:56.123")));
        assertEquals(1148, average);
        average = movingAverage.next(new Inventory(1189, toTimestamp("Apr 12, 2018 13:02:56.123")));
        assertEquals(1184.5, average);
        average = movingAverage.next(new Inventory(1191, toTimestamp("Apr 21, 2018 13:02:56.123")));
        assertEquals(1190, average);
        average = movingAverage.next(new Inventory(1120, toTimestamp("Apr 25, 2018 13:02:56.123")));
        assertEquals(1166.66, round(average));
        average = movingAverage.next(new Inventory(1175, toTimestamp("May 01, 2018 13:02:56.123")));
        assertEquals(1168.75, round(average));
        average = movingAverage.next(new Inventory(1190, toTimestamp("May 12, 2018 13:02:56.123")));
        assertEquals(1173.0, round(average));
        average = movingAverage.next(new Inventory(1100, toTimestamp("May 17, 2018 13:02:56.123")));
        assertEquals(1155.2, round(average));
        average = movingAverage.next(new Inventory(1090, toTimestamp("May 24, 2018 13:02:56.123")));
        assertEquals(1135.0, round(average));
    }

    @Test
    public void calculateAverageWithFileMovingWindow() {
        List<StockPrice> stockPrices = getPricesFromTestFile();
        assertEquals(36, stockPrices.size());
        List<Double> actual = new ArrayList<>();
        MovingAverage<StockPrice> movingAverage = MovingAverageBuilder
                .newBuilder()
                .chronological()
                .withMinutes(5)
                .build();
        stockPrices.forEach(stockPrice -> actual.add(movingAverage.next(stockPrice)));
        assertFalse(actual.isEmpty());
        assertEquals(123.5, actual.get(0));
        assertEquals(125.5, actual.get(1));
        assertEquals(157.75, actual.get(3));
        assertEquals(163.9, actual.get(4));
        assertEquals(142.0, actual.get(actual.size() - 1));
    }

    private double round(double value) {
        return Math.floor(value * 100) / 100;
    }
}