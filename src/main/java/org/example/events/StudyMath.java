package org.example.events;

import org.example.Student;

public class StudyMath extends Study {
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Math");
    }
}
