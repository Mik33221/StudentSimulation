package org.example;

public class Study implements Event{
    @Override
    public void ModifyStudent(Student student) {
        student.getSkills().merge("Math",1,(oldValue, newValue) -> (int)oldValue + (int)newValue);
    }
}
