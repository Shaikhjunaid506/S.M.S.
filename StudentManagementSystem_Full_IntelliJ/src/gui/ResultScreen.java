
package gui;

import javax.swing.*;
import java.util.List;

public class ResultScreen {
    public static void showResult(int score, List<String> subjects) {
        JFrame frame = new JFrame("Exam Result");
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        double percentage = (score / 25.0) * 100;
        double gpa = (percentage / 10.0);
        String grade;

        if (percentage >= 90) grade = "A+";
        else if (percentage >= 80) grade = "A";
        else if (percentage >= 70) grade = "B+";
        else if (percentage >= 60) grade = "B";
        else if (percentage >= 50) grade = "C";
        else grade = "F";

        StringBuilder result = new StringBuilder();
        result.append("Total Score: ").append(score).append(" / 25\n");
        result.append("Percentage: ").append(String.format("%.2f", percentage)).append("%\n");
        result.append("GPA: ").append(String.format("%.2f", gpa)).append("\n");
        result.append("Overall Grade: ").append(grade).append("\n");

        resultArea.setText(result.toString());
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(20, 20, 440, 200);
        frame.add(scrollPane);

        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
