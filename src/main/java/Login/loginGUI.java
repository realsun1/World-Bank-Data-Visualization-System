package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class loginGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;

    public loginGUI() {
        add(rootPanel);
        setTitle("World Bank Visualization Tool - Login");
        setSize(400, 200);
        rootPanel.getRootPane().setDefaultButton(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p = textField1.getText();
                String q = passwordField1.getText();
                loginHandler login = new loginHandler();
                int result = 0;
                try {
                    result = login.checkUser(p, q);
                } catch (FileNotFoundException | NoSuchAlgorithmException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                if (result == 1) {
                    JOptionPane.showMessageDialog(rootPanel, "User found");
                    dispose();
                }
                if (result == 2) {
                    JOptionPane.showMessageDialog(rootPanel, "Username found - Password Incorrect");
                    textField1.setText("");
                    passwordField1.setText("");
                }
                if (result == 3) {
                    JOptionPane.showMessageDialog(rootPanel, "Create a new user");
                    textField1.setText("");
                    passwordField1.setText("");
                    createUserUI createUser = new createUserUI();
                    createUser.setVisible(true);
                    createUser.setLocationRelativeTo(null);
                }
            }
        });

    }
}
