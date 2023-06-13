package org.example.events;

import org.example.Student;

public class StudyMath extends Study {  // dodaje punkty w matematyce i chęć na imprezę, zmniejsza pieniądze
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Math");
    }
}
