
package gui;

import javax.swing.*;

public class AdminLogin {
    private static final String PASSWORD = "junaid123";

    public static void showLogin() {
        JFrame frame = new JFrame("Admin Login");
        JLabel label = new JLabel("Enter Admin Password:");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        label.setBounds(50, 30, 200, 30);
        passwordField.setBounds(50, 70, 200, 30);
        loginButton.setBounds(80, 120, 120, 40);

        frame.add(label);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.setSize(300, 220);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(e -> {
            String pass = new String(passwordField.getPassword());
            if (pass.equals(PASSWORD)) {
                frame.dispose();
                AdminPanel.showPanel();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        });
    }
}
