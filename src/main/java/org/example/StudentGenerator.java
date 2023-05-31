package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentGenerator {
    static private final List<String> names = Arrays.asList("Kaylen", "Jace", "Jimmie", "Liam", "Sidney", "Linsey", "Leila", "Oswaldo", "Royce", "Willie", "Clarissa", "Robyn", "Kristin", "Donte", "Maurice", "Marquez", "Humberto", "Julia", "Drew", "Brayan", "Shamar", "Cassie", "Raekwon", "Anita", "Trayvon", "Ben", "Marie", "Codey", "Beyonce", "Erykah", "Travion", "Lucinda", "Jalyn", "Tionna", "Adam", "Jaclyn", "Ashlynn", "Ruben", "Seth", "Tristen");
    static private final List<String> surNames = Arrays.asList("John", "Eggleston", "Skinner", "Reedy", "Serna", "Harris", "Pate", "Bruce", "Weems", "Crouch", "Mireles", "Rosenthal", "Billings", "Chaney", "Rupp", "Gomez", "Keel", "Jarrett", "Rees", "Gerard", "Winston", "Weston", "Santana", "Forrest", "Barker", "Dennis", "Kern", "Knoll", "Houser", "Falcon", "Sandberg", "Zepeda", "Mora", "Mixon", "Bunting", "Caron", "Goebel", "Coronado", "Van", "Mathews");

    static int indexNumber = 1;

    public static List<Student> createRandomStudent(int count) {
        Random random = new Random();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Student newStudent =
                    new Student(
                            names.get(random.nextInt(names.size())),
                            surNames.get(random.nextInt(surNames.size())),
                            random.nextInt(80, 100),
                            indexNumber++
                    );
            students.add(newStudent);
        }
        return students;
    }

}