package org.example;

import java.util.*;

/**
 * Klasa konieczna do wygenerowania studentów biorących udział w symulacji
 * Generuje studenta nadając mu cechy z klasy Person jak i Student
 */
public class StudentGenerator {
    static private final List<String> names = Arrays.asList("Kaylen", "Jace", "Jimmie", "Liam", "Sidney", "Linsey", "Leila", "Oswaldo", "Royce", "Willie", "Clarissa", "Robyn", "Kristin", "Donte", "Maurice", "Marquez", "Humberto", "Julia", "Drew", "Brayan", "Shamar", "Cassie", "Raekwon", "Anita", "Trayvon", "Ben", "Marie", "Codey", "Beyonce", "Erykah", "Travion", "Lucinda", "Jalyn", "Tionna", "Adam", "Jaclyn", "Ashlynn", "Ruben", "Seth", "Tristen");
    static private final List<String> surNames = Arrays.asList("John", "Eggleston", "Skinner", "Reedy", "Serna", "Harris", "Pate", "Bruce", "Weems", "Crouch", "Mireles", "Rosenthal", "Billings", "Chaney", "Rupp", "Gomez", "Keel", "Jarrett", "Rees", "Gerard", "Winston", "Weston", "Santana", "Forrest", "Barker", "Dennis", "Kern", "Knoll", "Houser", "Falcon", "Sandberg", "Zepeda", "Mora", "Mixon", "Bunting", "Caron", "Goebel", "Coronado", "Van", "Mathews");
    static int indexNumber = 270000;
    /**
     *
     * @param type pobieramy informacje czy humanista czy ścisłowiec
     * @return zwraca hashmapę predyspozycji dla pojedyńczego studenta
     */
    static HashMap<String, Integer> RollPredispositions(boolean type) {
        Random random = new Random();
        HashMap<String, Integer> pred = new HashMap<>();

        if (type == true) { //Student jako ścisłowiec
            pred.put("Math", random.nextInt(80) + 1);
            pred.put("Physics", random.nextInt(40) + 1);
            pred.put("IT", random.nextInt(30) + 1);
            pred.put("InitialSocialization", random.nextInt(11) + 1);
        } else {            //Student jako humanista
            pred.put("Math", random.nextInt(30) + 1);
            pred.put("Physics", random.nextInt(50) + 1);
            pred.put("IT", random.nextInt(20) + 1);
            pred.put("InitialSocialization", random.nextInt(21) + 1);
        }
        return pred;
    }
    /**
     *
     * @param count liczba studentów do wygenerowania
     * @return lista wszystkich studentów
     */
    public static List<Student> createRandomStudent(int count) {
        Random random = new Random();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Student newStudent =
                    new Student(
                            names.get(random.nextInt(names.size())),
                            surNames.get(random.nextInt(surNames.size())),
                            random.nextInt(80, 100),
                            random.nextInt(10,2000),
                            indexNumber++,
                            RollPredispositions(random.nextBoolean()),
            new int[]{0,0,0},
                    "Aktywny");
            students.add(newStudent);
        }
        return students;
    }

}