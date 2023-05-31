package org.example;

public class StudyMath extends Study{
    @Override
    public void modifyStudent(Student student) {
        student.increaseSkill("Math");
    }
}
