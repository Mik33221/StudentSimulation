package org.example;
import java.io.*;
import java.io.File;

/**
 * Zapis wyniku symulacji do folderu temp
 */
public class SemesterLogger {
    private static String logFilePath = System.getProperty("java.io.tmpdir") + '/' + "semester.log";

    public static void log(String message) {
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
