package com.ha.utility;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {
    @Test
    public void toTimestampShouldParsStringSuccessfully() {
        Timestamp timestamp = DateUtils.toTimestamp("Nov 12, 2018 13:02:56.123");
        assertEquals("2018-11-12 13:02:56.123", timestamp.toString());
    }
}