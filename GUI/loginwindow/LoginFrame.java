package GUI.loginwindow;
/**
 * Created by Calvin Wong on 04/24/2014
 *
 * Login Frame
 *
 * Login:
 * admin:cs225
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 200;
    private LoginPanel loginPanel;

    public LoginFrame() {
        setTitle("ADMINISTRATOR LOG-IN"); // set title
        buildLoginWindow(); // build window
    }

    private void buildLoginWindow() {

        loginPanel = new LoginPanel();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        LoginButtonListener onClick = new LoginButtonListener();

        loginPanel.getLoginButton().addActionListener(onClick);

        add(loginPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.WHEN_IN_FOCUSED_WINDOW);
        getRootPane().setDefaultButton(loginPanel.getLoginButton());
        //setAlwaysOnTop(true);
        setVisible(true);
        setResizable(false);
    }

    private class LoginButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == loginPanel.getLoginButton()) {
                String sUserName = loginPanel.getUsernameText();
                String sPassWord = loginPanel.getPasswordText();
                //boolean bool = METHODNAME(sUserName, sPassWord);
                
                /*
                 * NEED METHOD THAT WILL ACCEPT USERNAME AND PASSWORD AS PARAMETER AND COMPARE
                 * THAT TO EVERY USERNAME AND PASSWORD IN THE DATABASE AND RETURN
                 * TRUE OR FALSE
                 */
                //if(bool) will replace line 61
                if (sUserName.equals("admin") && sPassWord.equals("cs225")) {

                    //DisabilityKiosk test = new DisabilityKiosk(); // launch disability window

                    TestFrame test = new TestFrame();

                    test.setVisible(true);
                    dispose(); // close Login window
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            }
        }
    }

    // main to test LoginFrame
    public static void main(String[] args) {
        new LoginFrame();
    }

} // end of class

