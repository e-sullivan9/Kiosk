/**
 * Created by Calvin Wong on 04/26/2014
 *
 * AfterLoginFrame
 *
 */
package GUI.loginwindow;
import disabilitykiosk.*;
import Backend.Admin;
import Backend.SpecialistList;
import GUI.reportwindow.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TestFrame extends JFrame {

    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 100;

    private JButton launchKioskButton = new JButton("LAUNCH KIOSK");
    private JButton reportButton = new JButton("VIEW REPORT");
    private JButton closeKioskButton = new JButton("CLOSE KIOSK");

    public TestFrame() {

        setLayout(new GridLayout());
        JPanel button = new JPanel();
        button.add(launchKioskButton);
        button.add(closeKioskButton);
        button.add(reportButton);

        add(button);
        setTitle("SELECT CHOICE");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // view report button link
        ReportButtonListener onClick = new ReportButtonListener();
        getReportButton().addActionListener(onClick);

        // launch kiosk button link
        LaunchKioskButtonListener click = new LaunchKioskButtonListener();
        getLaunchKioskButton().addActionListener(click);

        // close kiosk button link
        CloseKioskButtonListener close = new CloseKioskButtonListener();
        getCloseKioskButton().addActionListener(close);

        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.WHEN_IN_FOCUSED_WINDOW);
        //setAlwaysOnTop(true);
        setResizable(false);
        getRootPane().setDefaultButton(launchKioskButton);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // getters for buttons
    public final JButton getReportButton() {
        return reportButton;
    }

    public final JButton getLaunchKioskButton() {
        return launchKioskButton;
    }

    public final JButton getCloseKioskButton() {
        return closeKioskButton;
    }

    // action listeners for each button
    public class LaunchKioskButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == getLaunchKioskButton()) {
                new DisabilityKiosk();
                // launches Disability window
                dispose();
            }
        }
    }

    public class CloseKioskButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ee) {
            if (ee.getSource() == getCloseKioskButton()) {
            	Admin.serialize();
                SpecialistList.serialize();
                dispose();
                // close app
                System.exit(0);
            }
        }
    }

    private class ReportButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == getReportButton()) {
                // this button goes to the report window
                try {
					new ReportWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                dispose();
            }
        }
    }
} // end of class

