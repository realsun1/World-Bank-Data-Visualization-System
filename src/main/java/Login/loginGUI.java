/**
* This class creates the login GUI
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Login;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import mainGUI.MainUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class loginGUI extends JFrame {

    /**
     * these are the instance variables
     */
    private JPanel rootPanel;
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;

    /**
     * this is the constructor of the class
     */
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
                if (p.isEmpty() | q.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPanel, "Field empty");
                    textField1.setText("");
                    passwordField1.setText("");
                } else {
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
                        JFrame frame = MainUI.getInstance();
                        frame.setSize(1100, 1000);
                        frame.setVisible(true);
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
            }
        });

    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /***
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        rootPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(panel1, gbc);
        textField1 = new JTextField();
        panel1.add(textField1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(panel2, gbc);
        passwordField1 = new JPasswordField();
        panel2.add(passwordField1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(panel3, gbc);
        panel3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        final JLabel label1 = new JLabel();
        label1.setText("Username");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Password");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        rootPanel.add(label2, gbc);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        rootPanel.add(panel4, gbc);
        loginButton = new JButton();
        loginButton.setText("Login");
        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        rootPanel.add(loginButton, gbc);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
