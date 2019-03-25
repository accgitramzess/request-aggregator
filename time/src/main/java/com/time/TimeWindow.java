package com.time;

import java.time.LocalDateTime;

public class TimeWindow {

    private final LocalDateTime localDateTime;

    public TimeWindow(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
