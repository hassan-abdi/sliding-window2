package com.ha.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.ha.slidingwindow.TestDataRepository.getPointsFromTestFile;
import static com.ha.utility.DateUtils.toTimestamp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PrioritySlidingWindowTest {

    @Test
    public void slidingShouldSlideData(){
        PrioritySlidingWindow<Point> slidingWindow = new PrioritySlidingWindow<>(5);
        List<Point> points = getPointsFromTestFile();
        assertEquals(36, points.size());
        points.forEach(slidingWindow::add);
        List<List<Point>> slides = slidingWindow.sliding().collect(Collectors.toList());
        assertFalse(slides.isEmpty());
        assertEquals(32, slides.size());
        List<Point> firstSlide = slides.stream().findFirst().get();
        assertFalse(firstSlide.isEmpty());
        assertEquals(5, firstSlide.size());
        assertEquals(119, firstSlide.get(0).getValue());
        assertEquals(toTimestamp("Nov 12, 2018 13:02:56.12245678"), firstSlide.get(0).getTime());
        assertEquals(123, firstSlide.get(1).getValue());
    }
}