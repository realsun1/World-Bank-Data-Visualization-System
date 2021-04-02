package Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class createUserUI extends JFrame {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton createUserButton;
    private JPanel rootPanel;

    public createUserUI() {
        add(rootPanel);
        setTitle("World Bank Visualization Tool - Create User");
        setSize(400,200);
        rootPanel.getRootPane().setDefaultButton(createUserButton);
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginProxy users = null;
                try {
                    users = new loginProxy();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                loginHandler instance=new loginHandler();
                String p= textField1.getText();
                String q=passwordField1.getText();
                String pass = null;
                try {
                    pass = instance.encodePass(q);
                } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    noSuchAlgorithmException.printStackTrace();
                }
                user newUser = new user(p, pass);
                users.insertUser(newUser);
                dispose();
            }
        });
    }
}
