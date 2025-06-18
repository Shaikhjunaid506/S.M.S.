
package gui;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");
        JButton studentButton = new JButton("Register as Student");
        JButton adminButton = new JButton("Login as Admin");

        studentButton.setBounds(100, 100, 200, 40);
        adminButton.setBounds(100, 160, 200, 40);

        frame.add(studentButton);
        frame.add(adminButton);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentButton.addActionListener(e -> {
            frame.dispose();
            RegistrationForm.start();
        });

        adminButton.addActionListener(e -> {
            frame.dispose();
            AdminLogin.showLogin();
        });
    }
}
