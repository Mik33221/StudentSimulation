package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    // kompozycja - Event jest częscią składową klasy EventGenerator
    private final static List<Event> events = Arrays.asList(new Work(), new Party(), new StudyIT(), new StudyMath(), new StudyPhysics());

    public static Event generateRandomEvent(Student student) {
        Event event = getRandomEvent();

        if (event instanceof Work && student.getHealth() < 20) {
            event = generateRandomEvent(student); // Rekurencyjnie generuj nowe wydarzenie, jeśli warunek jest spełniony
        }

        return event;
    }

    private static Event getRandomEvent() {
        return events.get(new Random().nextInt(events.size()));
    }
}
