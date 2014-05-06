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

import Backend.*;
import disabilitykiosk.DisabilityKiosk;

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

        CancelButtonListener close = new CancelButtonListener();

        loginPanel.getCancelButton().addActionListener(close);

		add(loginPanel);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true);
		getRootPane()
				.setWindowDecorationStyle(JRootPane.WHEN_IN_FOCUSED_WINDOW);
		getRootPane().setDefaultButton(loginPanel.getLoginButton());
		// setAlwaysOnTop(true);
		setVisible(true);
		setResizable(false);
	}

    private class CancelButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            if (ae.getSource() == loginPanel.getCancelButton()) {
                dispose();
                new DisabilityKiosk(); // cancels open new Kiosk window
            }
        }
    }

	private class LoginButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == loginPanel.getLoginButton()) {
				String sUserName = loginPanel.getUsernameText();
				String sPassWord = loginPanel.getPasswordText();

				/*
				 * NEED METHOD THAT WILL ACCEPT USERNAME AND PASSWORD AS
				 * PARAMETER AND COMPARE THAT TO EVERY USERNAME AND PASSWORD IN
				 * THE DATABASE AND RETURN TRUE OR FALSE
				 */

				boolean temp = false;
				for (AdminAccount add : Admin.admins) {
					if ((add.getUsername().equals(sUserName))
							&& (add.getPassword().equals(sPassWord))) {
						temp = true;
					}

				}
				if (temp) {
					TestFrame test = new TestFrame();
					test.setVisible(true);
					dispose();

				} else
					JOptionPane.showMessageDialog(null,
							"Incorrect username or password");

			}
		}
	}
} // end of class

