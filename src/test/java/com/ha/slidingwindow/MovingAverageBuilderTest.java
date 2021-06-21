package com.ha.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovingAverageBuilderTest {

    @Test
    public void createNewBuilderWithTimeFrame(){
        MovingAverage<ChronologicalRecord> build = MovingAverageBuilder
                .newBuilder()
                .chronological()
                .withTimeFrame(1000)
                .build();
        assertNotNull(build);
    }

}