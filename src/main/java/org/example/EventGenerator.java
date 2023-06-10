package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventGenerator {
    // kompozycja - Event jest częscią składową klasy EventGenerator
    private final static List<Event> events = Arrays.asList(new StudyMath(), new StudyPhysics(), new StudyIT(), new Party(), new Work());

    public static Event generateRandomEvent(Student student) {  // losuje akcję studenta na podstawie jego potrzeb
        int[] pred = student.getAllPredispositions();
        int random = new Random().nextInt(student.getSumPredispositions());
        int choice = 0;
        int i = 0;

        if ( student.getPredisposition("Wealth")>50 &&student.getHealth()>20) {
            //jezeli studenta stac na dzien nauki oraz jest zdrowy
            // to się uczy
            if (random < (i += pred[0])) {
            choice = 0;
        } else if (random < (i += pred[1])) {
            choice = 1;
        } else if (random < (i += pred[2])) {
            choice = 2;
        } else if (random < (i += pred[3])) {
            choice = 3;
            }
        }else if (student.getPredisposition("Wealth")<=50 && student.getHealth()>20) choice =4;


        return events.get(choice);
    }
}
