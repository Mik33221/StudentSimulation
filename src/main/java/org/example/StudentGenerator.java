package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentGenerator {
    private String allNames = "Kaylen,Jace,Jimmie,Liam,Sidney,Linsey,Leila,Oswaldo,Royce,Willie,Clarissa,Robyn,Kristin,Donte,Maurice,Marquez,Humberto,Julia,Drew,Brayan,Shamar,Cassie,Raekwon,Anita,Trayvon,Ben,Marie,Codey,Beyonce,Erykah,Travion,Lucinda,Jalyn,Tionna,Adam,Jaclyn,Ashlynn,Ruben,Seth,Tristen";
    private String allSurnames = "John,Eggleston,Skinner,Reedy,Serna,Harris,Pate,Bruce,Weems,Crouch,Mireles,Rosenthal,Billings,Chaney,Rupp,Gomez,Keel,Jarrett,Rees,Gerard,Winston,Weston,Santana,Forrest,Barker,Dennis,Kern,Knoll,Houser,Falcon,Sandberg,Zepeda,Mora,Mixon,Bunting,Caron,Goebel,Coronado,Van,Mathews";
    private List<String> names = Arrays.asList(allNames.split(","));
    private List<String> surNames = Arrays.asList(allNames.split(","));

    public List<Student> CreateRandom(int count){

        Random random = new Random();

        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < count; i++) {
            Student newStudent = new Student(names.get(random.nextInt(names.size())),surNames.get(random.nextInt(surNames.size())),random.nextInt(80,101));
            students.add(newStudent);
        }
        return students;
    }

}