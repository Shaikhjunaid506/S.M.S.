package gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class AdminPanel {
    static List<Student> studentDatabase = new ArrayList<>();

    // Sample Student class
    static class Student {
        String name, course;
        int roll;
        Map<String, Integer> results;

        Student(String name, String course, int roll) {
            this.name = name;
            this.course = course;
            this.roll = roll;
            this.results = new HashMap<>();
        }
    }

    public static void showPanel() {
        JFrame frame = new JFrame("Admin Panel");

        JButton viewStudentsBtn = new JButton("View Registered Students");
        JButton updateDetailsBtn = new JButton("View/Update Student Details");
        JButton viewResultsBtn = new JButton("View Results");
        JButton exitBtn = new JButton("Exit");

        viewStudentsBtn.setBounds(50, 30, 250, 30);
        updateDetailsBtn.setBounds(50, 70, 250, 30);
        viewResultsBtn.setBounds(50, 110, 250, 30);
        exitBtn.setBounds(50, 150, 250, 30);

        frame.add(viewStudentsBtn);
        frame.add(updateDetailsBtn);
        frame.add(viewResultsBtn);
        frame.add(exitBtn);

        // Sample Data
        if (studentDatabase.isEmpty()) {
            Student s1 = new Student("Junaid Hussain", "B.Tech", 101);
            s1.results.put("DSA", 9);
            s1.results.put("OS", 8);

            Student s2 = new Student("rocky", "MBA", 201);
            s2.results.put("Marketing", 7);
            s2.results.put("Finance", 9);

            studentDatabase.add(s1);
            studentDatabase.add(s2);
        }

        viewStudentsBtn.addActionListener(e -> {
            JTextArea textArea = new JTextArea();
            for (Student s : studentDatabase) {
                textArea.append("Name: " + s.name + ", Course: " + s.course + ", Roll: " + s.roll + "\n");
            }
            showDialog("Registered Students", textArea);
        });

        updateDetailsBtn.addActionListener(e -> {
            String rollStr = JOptionPane.showInputDialog("Enter Roll Number:");
            if (rollStr != null) {
                int roll = Integer.parseInt(rollStr);
                Student target = null;
                for (Student s : studentDatabase) {
                    if (s.roll == roll) {
                        target = s;
                        break;
                    }
                }

                if (target != null) {
                    String newName = JOptionPane.showInputDialog("Enter New Name:", target.name);
                    if (newName != null && !newName.isEmpty()) {
                        target.name = newName;
                        JOptionPane.showMessageDialog(null, "Updated successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Student not found.");
                }
            }
        });

        viewResultsBtn.addActionListener(e -> {
            String rollStr = JOptionPane.showInputDialog("Enter Roll Number:");
            if (rollStr != null) {
                int roll = Integer.parseInt(rollStr);
                for (Student s : studentDatabase) {
                    if (s.roll == roll) {
                        JTextArea resultArea = new JTextArea();
                        resultArea.append("Results for " + s.name + ":\n");
                        for (Map.Entry<String, Integer> entry : s.results.entrySet()) {
                            resultArea.append(entry.getKey() + ": GPA " + entry.getValue() + "\n");
                        }
                        showDialog("Student Results", resultArea);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Student not found.");
            }
        });

        exitBtn.addActionListener(e -> frame.dispose());

        frame.setSize(380, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void showDialog(String title, JTextArea area) {
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setPreferredSize(new java.awt.Dimension(350, 150));
        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
