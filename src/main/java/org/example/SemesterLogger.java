package org.example;
import java.io.*;
import java.io.File;

public class SemesterLogger {
    private String logFilePath;

    public SemesterLogger(String logFilePath) {
        String tempDir = System.getProperty("java.io.tmpdir");
        this.logFilePath = tempDir + File.separator + "semester.log";
    }

    public void log(String message) {
        // Wyświetlanie w konsoli
        System.out.print(message);

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
