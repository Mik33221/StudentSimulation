package org.example;

public class StudyIT extends Study{
    @Override
    public void ModifyStudent(Student student) {
        student.getSkills().merge("IT",1,(oldValue, newValue) -> (int)oldValue + (int)newValue);
    }
}
