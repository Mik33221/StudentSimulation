package org.example.GUI;

import org.example.StudentGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener, Observer {
    private final JTextArea consoleArea;
    private final JButton simulateButton;
    private final JPanel panel;
    private final TextField numberStudents;
    private final TextField semesterDays;

    public MainGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

        JLabel numberStudentsLabel = new JLabel("Students count:");
        numberStudentsLabel.setBounds(10, 10, 80, 20);
        TextField numberStudents = new TextField();
        numberStudents.setBounds(90, 10, 30, 20);
        numberStudents.setText("5");
        this.numberStudents = numberStudents;

        JLabel semesterDaysLabel = new JLabel("Semester days:");
        semesterDaysLabel.setBounds(140, 10, 80, 20);
        TextField semesterDays = new TextField();
        semesterDays.setBounds(230, 10, 30, 20);
        semesterDays.setText("105");
        this.semesterDays = semesterDays;

        JButton simulateButton = new JButton("Start simulation...");
        simulateButton.addActionListener(this);
        simulateButton.setVisible(true);
        this.simulateButton = simulateButton;

        JTextArea consoleArea = new JTextArea(30, 70);
        Font font = new Font("Courier New", Font.BOLD, 20);
        consoleArea.setFont(font);
        consoleArea.setLineWrap(false);
        consoleArea.setWrapStyleWord(false);
        consoleArea.setEditable(false);
        consoleArea.setVisible(true);
        this.consoleArea = consoleArea;

        JScrollPane scroll = new JScrollPane(consoleArea);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(numberStudentsLabel);
        panel.add(numberStudents);
        panel.add(semesterDaysLabel);
        panel.add(semesterDays);
        panel.add(simulateButton, BorderLayout.LINE_END);
        panel.add(Box.createVerticalStrut(40));
        panel.add(scroll, BorderLayout.PAGE_END);
        this.panel = panel;

        JFrame frame = new JFrame("Students' Lives Simulation");
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new MainGUI();
    }

    /**
     * based on https://stackoverflow.com/questions/58526874/updating-jlabel-text-from-another-thread-in-real-time
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        final int semesterDays = Integer.parseInt(this.semesterDays.getText());
        final int numberOfStudents = Integer.parseInt(this.numberStudents.getText());
        this.simulateButton.setEnabled(false);
        SemesterWorker semester = new SemesterWorker(semesterDays, StudentGenerator.createRandomStudent(numberOfStudents));
        semester.addObserver(this);
        new Thread(semester).start();
    }

    @Override
    public void update(String message) {
        this.consoleArea.setText(message);
    }

    @Override
    public void finished() {
        this.simulateButton.setEnabled(true);
    }
}
