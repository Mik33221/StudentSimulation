package org.example.events;

import org.example.Student;

public class StudyPhysics extends Study {   // dodaje punkty w fizyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    /**
     * Zwiększa skille w hashmapie z klasy Person w zakresie Physics
     */
    public void modifyStudent(Student student) {
        student.increaseSkill("Physics");
    }
}
