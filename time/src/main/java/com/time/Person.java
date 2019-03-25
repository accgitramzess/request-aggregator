package com.time;

import java.util.List;

public class Person {

    private final String name;

    private List<TimeWindow> timeWindows;

    public Person(String name, List<TimeWindow> timeWindows) {
        this.name = name;
        this.timeWindows = timeWindows;
    }
}
