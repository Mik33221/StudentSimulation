package org.example;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class StudentGenerator {

    private static int generateUniqueIndexNumber(Set<Integer> usedNumbers) {
        Random random = new Random();
        int number;

        do {
            number = random.nextInt(9000) + 1000; // Losuje wartość od 1000 do 9999
        } while (usedNumbers.contains(number));

        usedNumbers.add(number);
        return number;
    }


    static private final List<String> names = Arrays.asList("Kaylen", "Jace", "Jimmie", "Liam", "Sidney", "Linsey", "Leila", "Oswaldo", "Royce", "Willie", "Clarissa", "Robyn", "Kristin", "Donte", "Maurice", "Marquez", "Humberto", "Julia", "Drew", "Brayan", "Shamar", "Cassie", "Raekwon", "Anita", "Trayvon", "Ben", "Marie", "Codey", "Beyonce", "Erykah", "Travion", "Lucinda", "Jalyn", "Tionna", "Adam", "Jaclyn", "Ashlynn", "Ruben", "Seth", "Tristen");
    static private final List<String> surNames = Arrays.asList("John", "Eggleston", "Skinner", "Reedy", "Serna", "Harris", "Pate", "Bruce", "Weems", "Crouch", "Mireles", "Rosenthal", "Billings", "Chaney", "Rupp", "Gomez", "Keel", "Jarrett", "Rees", "Gerard", "Winston", "Weston", "Santana", "Forrest", "Barker", "Dennis", "Kern", "Knoll", "Houser", "Falcon", "Sandberg", "Zepeda", "Mora", "Mixon", "Bunting", "Caron", "Goebel", "Coronado", "Van", "Mathews");


    public static List<Student> createRandomStudents(int count) {
        Random random = new Random();
        List<Student> students = new ArrayList<>();
        Set<Integer> usedNumbers = new HashSet<>();


        for (int i = 0; i < count; i++) {
            String name = names.get(random.nextInt(names.size()));
            String surName = surNames.get(random.nextInt(surNames.size()));
            int health = random.nextInt(80) + 20; // Losuje wartość od 20 do 100
            int mathSkills;
            int physicalSkills;
            int computerSkills;
            int socializationDesire;

            if (random.nextBoolean()) {
                // Student jako matematyk
                mathSkills = random.nextInt(80) + 1;
                physicalSkills = random.nextInt(40) + 1;
                computerSkills = random.nextInt(30) + 1;
                socializationDesire = random.nextInt(11) + 1;

            } else {
                // Student jako humanista
                mathSkills = random.nextInt(30) + 1;
                physicalSkills = random.nextInt(50) + 1;
                computerSkills = random.nextInt(20) + 1;
                socializationDesire = random.nextInt(21) + 1;

            }

            Student newStudent = new Student(name, surName, health, generateUniqueIndexNumber(usedNumbers), mathSkills, physicalSkills, computerSkills, socializationDesire);
            students.add(newStudent);
        }

        return students;
    }
}