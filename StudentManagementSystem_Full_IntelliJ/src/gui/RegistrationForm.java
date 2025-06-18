package gui;

import javax.swing.*;

public class RegistrationForm {
    public static void start() {
        JFrame frame = new JFrame("Student Registration - Step 1");

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel idLabel = new JLabel("Student ID:");
        JTextField idField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth (dd/mm/yyyy):");
        JTextField dobField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone No:");
        JTextField phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel semLabel = new JLabel("Semester (1-8):");
        JTextField semField = new JTextField();

        JLabel courseLabel = new JLabel("Select Course:");
        String[] courses = {"B.Tech", "BCA", "MBA", "MBBS"};
        JComboBox<String> courseBox = new JComboBox<>(courses);

        JButton nextButton = new JButton("Next");

        // Set bounds
        nameLabel.setBounds(30, 20, 150, 30);
        nameField.setBounds(180, 20, 180, 30);
        idLabel.setBounds(30, 60, 150, 30);
        idField.setBounds(180, 60, 180, 30);
        dobLabel.setBounds(30, 100, 180, 30);
        dobField.setBounds(210, 100, 150, 30);
        phoneLabel.setBounds(30, 140, 150, 30);
        phoneField.setBounds(180, 140, 180, 30);
        emailLabel.setBounds(30, 180, 150, 30);
        emailField.setBounds(180, 180, 180, 30);
        semLabel.setBounds(30, 220, 150, 30);
        semField.setBounds(180, 220, 180, 30);
        courseLabel.setBounds(30, 260, 150, 30);
        courseBox.setBounds(180, 260, 180, 30);
        nextButton.setBounds(130, 310, 120, 40);

        // Add components to frame
        frame.add(nameLabel); frame.add(nameField);
        frame.add(idLabel); frame.add(idField);
        frame.add(dobLabel); frame.add(dobField);
        frame.add(phoneLabel); frame.add(phoneField);
        frame.add(emailLabel); frame.add(emailField);
        frame.add(semLabel); frame.add(semField);
        frame.add(courseLabel); frame.add(courseBox);
        frame.add(nextButton);

        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nextButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String studentId = idField.getText().trim();
            String dob = dobField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();
            String semester = semField.getText().trim();
            String course = (String) courseBox.getSelectedItem();

            // Validations
            if (name.isEmpty() || studentId.isEmpty() || dob.isEmpty() ||
                    phone.isEmpty() || email.isEmpty() || semester.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields.");
                return;
            }

            if (!dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                JOptionPane.showMessageDialog(frame, "DOB must be in dd/mm/yyyy format.");
                return;
            }

            if (!phone.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(frame, "Phone must be 10 digits.");
                return;
            }

            if (!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                JOptionPane.showMessageDialog(frame, "Invalid email format.");
                return;
            }

            try {
                int sem = Integer.parseInt(semester);
                if (sem < 1 || sem > 8) {
                    JOptionPane.showMessageDialog(frame, "Semester must be between 1 and 8.");
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Semester must be a number.");
                return;
            }

            // Proceed if all validations pass
            frame.dispose();
            SubjectSelectionForm.showSubjects(course);
        });
    }
}
