package com.ha.utility;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String pattern = "MMM dd, yyyy HH:mm:ss.SSSSSSSS";

    public static Timestamp toTimestamp(String value){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(value));
        return Timestamp.valueOf(localDateTime);
    }
}
