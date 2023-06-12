package org.example.events;

import org.example.Student;

public class StudyPhysics extends Study {
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Physics");
    }
}
