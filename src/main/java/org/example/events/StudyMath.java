package org.example.events;

import org.example.Student;

public class StudyMath extends Study {  // dodaje punkty w matematyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    /**
     * Zwiększa skille w hashmapie z klasy Person w zakresie Math
     */
    public void modifyStudent(Student student) {
        student.increaseSkill("Math");
    }
}
