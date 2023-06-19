package org.example;
import java.io.*;
import java.nio.file.*;

public class SemesterLogger {
    private String logFilePath;

    public SemesterLogger(String logFilePath) {
        String userHome = System.getProperty("user.home");
        this.logFilePath = "C:\\\\Users\\\\kbarc\\\\OneDrive\\\\Pulpit\\\\semester.log";
    }

    public void log(String message) {
        // Wyświetlanie w konsoli
        System.out.println(message);

        // Zapis do pliku
        try {
            FileWriter fileWriter = new FileWriter(logFilePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisywania do pliku logu: " + e.getMessage());
        }
    }
}
