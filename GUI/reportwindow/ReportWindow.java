package GUI.reportwindow;
import Backend.*;
import GUI.loginwindow.LoginFrame;
import GUI.adddeleteuser.AddDeleteUserFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;

import com.healthmarketscience.jackcess.Row;

/**
 * Created by Pat
 */
public class ReportWindow extends JFrame {
    private JPanel northPanel;
    private JPanel comboPanel;

    private JPanel centerPanel;
    private JPanel southPanel;

    private JComboBox reasonsComboBox;
    private JComboBox datesComboBox;

    private JTextArea textArea;
    private JScrollPane scrollPane;

    private JButton printFileBtn;
    private JButton addDeleteBtn;
    private JButton closeBtn;

    private final String[] reasons = {"New, Prospective Student/Group","Disclose and Document Disability (In-take)","Placement Testing with Accommodation",
            "Schedule An Appointment with Disability Specialist","Meet with a Disability Specialist","Take Test with Accommodations","Drop Off/Pick Up Notes",
            "Academic Advising (Course Selection, Add/Drop, Withdrawal)","Fill Out Accommodation Forms","Address Problems with Specific Accommodations",
            "Address Specific Course Assignment or Issue","Alternative Format for Texts and Handouts",
            "Professional Consultation (Faculty, Staff, Administration, Department)","Other"};
    private String[] datesPastYr;

    public ReportWindow() throws IOException {
        super("Report Window");

        setExtendedState(Frame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(new BorderLayout());
        buildPanels();
        setVisible(true);
    }
    public void buildPanels() throws IOException {
        //Setting up northPanel
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());

        comboPanel = new JPanel();

        reasonsComboBox = new JComboBox(reasons);
        reasonsComboBox.addActionListener(new ComboBoxListener());

        datesPastYr = new String[365];
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();

        for (int i = 0; i < datesPastYr.length; i++) {
            if (i == 0) {
                Date day = cal.getTime();
                datesPastYr[i] = dateFormat.format(day);
            } else {
                cal.add(Calendar.DAY_OF_YEAR, -1);
                Date day = cal.getTime();
                datesPastYr[i] = dateFormat.format(day);
            }
        }

        datesComboBox = new JComboBox(datesPastYr);

        comboPanel.add(datesComboBox);
        comboPanel.add(reasonsComboBox);

        northPanel.add(new JLabel("Current students waiting to be seen:"), BorderLayout.NORTH);
        northPanel.add(comboPanel, BorderLayout.SOUTH);

        //Setting up centerPanel
        centerPanel = new JPanel();
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        addHeader();
        String temp = "";
        Data.open();
        for (Row row: Data.chooseTable("visits"))
        	temp += row + "\n";
        Data.closeData();
        textArea.append(temp);


        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerPanel.add(scrollPane);


        //setting up southPanel
        southPanel = new JPanel();

        addDeleteBtn = new JButton("Add / Delete Users");
        addDeleteBtn.addActionListener(new ButtonListener());
        southPanel.add(addDeleteBtn);

        printFileBtn = new JButton("Print File");
        printFileBtn.addActionListener(new ButtonListener());
        southPanel.add(printFileBtn);

        closeBtn = new JButton("Close");
        closeBtn.addActionListener(new CloseButtonListener());
        southPanel.add(closeBtn);


        //adding all panels to frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    private void addHeader() {
        textArea.append(addBuffer("Date", 15));
        textArea.append(addBuffer("Time", 10));
        textArea.append(addBuffer("FirstName", 30));
        textArea.append(addBuffer("LastName", 30));
        textArea.append(addBuffer("Email", 25));
        textArea.append(addBuffer("Phone", 25));
        textArea.append(addBuffer("Reason", 35));
        textArea.append(addBuffer("Follow Up?", 10));

        Scanner scan = new Scanner(textArea.getText());
        String s = scan.nextLine();
        textArea.append("\n");
        for (int i = 0; i < s.length(); i++) {
            textArea.append("-");
        }
        textArea.append("\n");
        scan.close();
    }
    private static String addBuffer(String s, int buffSize) {
        String temp = s;
        for (int i = s.length(); i <= buffSize; i++) {
            temp += " ";
        }

        return temp;
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == printFileBtn) {
                try {
                    boolean complete = textArea.print();
                    if (complete) {
                        JOptionPane.showMessageDialog(null, "Done Printing!", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch(PrinterException exception) {
                    JOptionPane.showMessageDialog(null, exception);
                }
            } else if (e.getSource() == addDeleteBtn) {
                AddDeleteUserFrame addDeleteUser = new AddDeleteUserFrame();
                addDeleteUser.setVisible(true);
            }
        }
    }
    private class CloseButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          if (e.getSource() == closeBtn)
          {
              new LoginFrame();
              setVisible(false);
              dispose();
             //System.exit(0);
          }
      }
    }
    private class ComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();

            String selection = (String) cb.getSelectedItem();

            StringBuilder stb;
        }
    }
}