package org.example.events;

import org.example.Student;

import java.util.Random;
/**
 * Zwiększa skille w hashmapie z klasy Person w zakresie IT
 */
public class StudyIT extends Study {    // dodaje punkty w informatyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("IT");
        student.decreaseMoney(40);
        student.increaseSocial(new Random().nextInt(2,4));
    }
}
