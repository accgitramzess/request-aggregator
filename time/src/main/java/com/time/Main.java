package com.time;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime toDateTime = LocalDateTime.of(2014, 4, 1, 16, 39, 0);
        LocalDateTime fromDateTime = LocalDateTime.of(2014, 4, 2, 18, 14, 0);
        Duration duration = Duration.between(toDateTime, fromDateTime);
        System.out.println(duration.toHours());
    }
}
