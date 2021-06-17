package com.ha.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class PriorityWindowAverage {
    private final PrioritySlidingWindow<Point> slidingWindow;

    public PriorityWindowAverage(int window) {
        this.slidingWindow = new PrioritySlidingWindow<>(window);
    }

    public void add(Point point) {
        slidingWindow.add(point);
    }

    public List<Double> averages() {
        List<Double> result = new ArrayList<>();
        slidingWindow.sliding()
                .forEach(points -> result.add(points.stream().mapToDouble(Point::getValue).average().orElse(Double.NaN)));
        return result;
    }
}
