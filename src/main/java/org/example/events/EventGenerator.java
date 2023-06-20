package org.example.events;

import org.example.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Klasa odpowiedzialna za wybór eventów na podstawie predyspozycji studenta
 */
public class EventGenerator {
    // kompozycja - Event jest częscią składową klasy EventGenerator
    private final static List<Event> events = Arrays.asList(new StudyMath(), new StudyPhysics(), new StudyIT(), new Party(), new Work(), new Rest());

    public static Event generateRandomEvent(Student student) {  // losuje akcję studenta na podstawie jego potrzeb
        int[] pred = student.getAllPredispositions();
        int random = new Random().nextInt(student.getSumPredispositions());
        int choice = 0;
        int i = 0;

        if (student.getHealth()<20) {           // przy zbyt małym życiu odpoczywa
            choice = 5;
        } else if (student.getMoney()<40) {     // przy zbyt małej ilości pieniędzy pracuje
            choice = 4;
        } else if (random < (i += pred[0])) {   // losuje akcje na podstawie sumy predyspozycji i chęci na imprezę (social)
            choice = 0;                         // matematyka
        } else if (random < (i += pred[1])) {
            choice = 1;                         // fizyka
        } else if (random < (i += pred[2])) {
            choice = 2;                         // informatyka
        } else if (random < (i += pred[3])) {
            choice = 3;                         // impreza
        }

        return events.get(choice);
    }
}
