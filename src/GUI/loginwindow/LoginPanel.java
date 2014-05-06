package GUI.loginwindow;

/**
 * Created by Calvin Wong on 04/24/2014
 *
 * Login Panel
 */

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class LoginPanel extends JPanel {

    private final int CHAR_LENGTH = 15;
    private JLabel userName;
    private JLabel passWord;
    private JButton loginButton;
    private JButton cancelButton;
    private Font font = new Font("PLAIN", Font.PLAIN, 18);
    private JTextField userNameText;
    private JPasswordField passWordText;

    public LoginPanel() {
        super(new GridBagLayout());
        loginPanel();
        setVisible(true);
    }

    private void loginPanel() {

        userNameText = new JTextField(CHAR_LENGTH);
        passWordText = new JPasswordField(CHAR_LENGTH);
        loginButton = new JButton("LOGIN");
        cancelButton = new JButton("CANCEL");


        GridBagConstraints grid = new GridBagConstraints();

        grid.fill = GridBagConstraints.HORIZONTAL;

        userName = new JLabel("Username: ");
        userName.setFont(font);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;

        add(userName, grid);

        grid.gridx = 1;
        grid.gridy = 0;
        grid.gridwidth = 2;

        add(userNameText, grid);

        passWord = new JLabel("Password: ");
        passWord.setFont(font);
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;

        add(passWord, grid);

        grid.gridx = 1;
        grid.gridy = 1;
        grid.gridwidth = 2;

        add(passWordText, grid);

        grid.gridx = 1;
        grid.gridy = 2;
        grid.gridwidth = 1;

        add(loginButton, grid);

        grid.gridx = 2;
        grid.gridy = 2;
        grid.gridwidth = 1;

        add(cancelButton, grid);

    }

    // getters

    public final JButton getLoginButton() {
        return loginButton;
    }

    public final JButton getCancelButton() {
        return cancelButton;
    }

    public String getPasswordText() {
        return String.valueOf(passWordText.getPassword());
    }

    public String getUsernameText() {
        return userNameText.getText();
    }

} // end of class