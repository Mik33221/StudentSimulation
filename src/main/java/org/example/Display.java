package org.example;

public class Display {
    public static void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void printSkill(int skill){
        for (int i = 0; i < skill; i++) {
            System.out.print("#");
        }
        System.out.println();
    }
    public static void printStudentStatistic(Student student){
        System.out.println(student.getName()+" "+student.getSurName()+" "+student.indexNumber+""+" health: "+student.getHealth()+" money: "+student.getMoney());
        System.out.print("Math   : ");
        Display.printSkill(student.getSkillValue("Math"));
        System.out.print("Physics: ");
        Display.printSkill(student.getSkillValue("Physics"));
        System.out.print("IT     : ");
        Display.printSkill(student.getSkillValue("IT"));
        System.out.println();
    }
}
