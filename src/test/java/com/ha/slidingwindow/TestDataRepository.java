package com.ha.slidingwindow;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.ha.utility.DateUtils.toTimestamp;

public class TestDataRepository {

    public static List<StockPrice> getPricesFromTestFile() {
        String filePath = Objects.requireNonNull(TestDataRepository.class.getClassLoader().getResource("test-data.csv")).getPath();
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            return stream.map(line -> {
                String[] strings = line.split(",", 2);
                return new StockPrice(Double.valueOf(strings[0]), toTimestamp(strings[1]));
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
