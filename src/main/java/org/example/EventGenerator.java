package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    // kompozycja - Event jest częscią składową klasy EventGenerator
    private final static List<Event> events = Arrays.asList(new Work(), new Party(), new StudyIT(), new StudyMath(), new StudyPhysics());

    public static Event generateRandomEvent() {
        return events.get(new Random().nextInt(events.size()));
    }
}
