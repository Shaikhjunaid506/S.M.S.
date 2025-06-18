
package gui;

import javax.swing.*;
import java.util.*;

public class SubjectSelectionForm {
    public static void showSubjects(String course) {
        JFrame frame = new JFrame("Subject Selection - " + course);
        JLabel label = new JLabel("Select 5 Subjects:");
        label.setBounds(30, 20, 300, 30);
        frame.add(label);

        String[] btech = { "DSA", "OS", "CN", "DBMS", "AI", "ML", "Web Dev" };
        String[] bca = { "C Prog", "Maths", "DBMS", "Networking", "Python", "OOP", "HTML/CSS" };
        String[] mba = { "Marketing", "Finance", "HR", "Economics", "Statistics", "Mgmt", "Ethics" };
        String[] mbbs = { "Anatomy", "Physiology", "Biochem", "Pharma", "Pathology", "Microbio", "Surgery" };

        String[] subjects;
        switch(course) {
            case "B.Tech": subjects = btech; break;
            case "BCA": subjects = bca; break;
            case "MBA": subjects = mba; break;
            case "MBBS": subjects = mbbs; break;
            default: subjects = new String[0];
        }

        JCheckBox[] checkBoxes = new JCheckBox[subjects.length];
        int y = 60;
        for (int i = 0; i < subjects.length; i++) {
            checkBoxes[i] = new JCheckBox(subjects[i]);
            checkBoxes[i].setBounds(50, y, 200, 30);
            frame.add(checkBoxes[i]);
            y += 30;
        }

        JButton submit = new JButton("Register & View Notes");
        submit.setBounds(100, y + 20, 200, 40);
        frame.add(submit);

        frame.setSize(400, y + 100);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submit.addActionListener(e -> {
            List<String> selected = new ArrayList<>();
            for (JCheckBox cb : checkBoxes) {
                if (cb.isSelected()) selected.add(cb.getText());
            }

            if (selected.size() != 5) {
                JOptionPane.showMessageDialog(null, "Please select exactly 5 subjects.");
                return;
            }

            frame.dispose();
            NotesScreen.displayNotes(course, selected);
        });
    }
}
