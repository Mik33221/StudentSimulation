package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentGenerator {

    public List<Student> CreateRandom(int count){

        Random random = new Random();

        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < count; i++) {
            Student newStudent = new Student(random.nextInt(11), random.nextInt(11), random.nextInt(11));
            students.add(newStudent);
        }
        return students;
    }
}