package org.example.events;

import org.example.Student;

import java.util.Random;
/**
 * Zwiększa skille w hashmapie z klasy Person w zakresie Math
 */
public class StudyMath extends Study {  // dodaje punkty w matematyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Math");
        student.decreaseMoney(40);
        student.increaseSocial(new Random().nextInt(2,4));
    }
}
