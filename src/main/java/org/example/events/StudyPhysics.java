package org.example.events;

import org.example.Student;

import java.util.Random;
/**
 * Zwiększa skille w hashmapie z klasy Person w zakresie Physics
 */
public class StudyPhysics extends Study {   // dodaje punkty w fizyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Physics");
        student.decreaseMoney(40);
        student.increaseSocial(new Random().nextInt(2,4));
    }
}
