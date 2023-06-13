package org.example;

import org.example.events.Event;


public class Exam implements Event {

    private SkillGetter skillGetter;

    public Exam(SkillGetter skillGetter) {
        this.skillGetter = skillGetter;
    }


    @Override
    public void modifyStudent(Student student) {
       if(student.getHealth()>10){
           System.out.print("[Oceny w sesji: Matematyka ");
           if (skillGetter.getSkillValue("Math") > 30) {
               int points = skillGetter.getSkillValue("Math");
               int grade = calGrade(points);
               System.out.print( grade);
           } else {
               System.out.print("niezaliczona ");
           }
           System.out.print(" Fizyka ");
           if (skillGetter.getSkillValue("Physics") > 30) {
               int points = skillGetter.getSkillValue("Physics");
               int grade = calGrade(points);
               System.out.print( grade);
           } else {
               System.out.print(" niezaliczona ");
           }
           System.out.print(" IT: ");
           if (skillGetter.getSkillValue("IT") > 30) {
               int points = skillGetter.getSkillValue("IT");
               int grade = calGrade(points);
               System.out.print(grade);

           } else {
               System.out.print(" niezaliczone");
           }  System.out.println("]");
       }else System.out.println("Student nie byl w stanie przystapic do sesji ze wzgledow zdrowotnych ");
    }
    private int calGrade(int points) {
        if (points >= 50) {
            return 5;
        } else if (points >= 40) {
            return 4;
        } else if (points >= 30) {
            return 3;
        } else {
            return 2;
        }
    }
}
