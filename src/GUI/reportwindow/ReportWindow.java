package GUI.reportwindow;
import Backend.*;
import GUI.adddeletespec.AddDeleteSpecFrame;
import GUI.adddelete.AddDeleteAdminFrame;
import GUI.loginwindow.LoginFrame;

import com.healthmarketscience.jackcess.*;
import com.healthmarketscience.jackcess.Cursor;

import java.io.IOException;
import java.util.Collections;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PrinterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;

import com.healthmarketscience.jackcess.CursorBuilder;
import com.healthmarketscience.jackcess.Row;
import java.util.ArrayList;

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
    //private JButton addDeleteBtn;
    private JButton addDeleteSpecBtn;
    private JButton addDeleteAdminBtn;
    private JButton closeBtn;

    private final String[] reasons = {"New, Prospective Student/Group","Disclose and Document Disability (In-take)","Placement Testing with Accommodation",
            "Schedule An Appointment with Disability Specialist","Meet with a Disability Specialist","Take Test with Accommodations","Drop Off/Pick Up Notes",
            "Academic Advising (Course Selection, Add/Drop, Withdrawal)","Fill Out Accommodation Forms","Address Problems with Specific Accommodations",
            "Address Specific Course Assignment or Issue","Alternative Format for Texts and Handouts",
            "Professional Consultation (Faculty, Staff, Administration, Department)","Other"};
    private String[] datesPastYr;

    public ReportWindow() throws IOException {
        super("Administrator Window");

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
        reasonsComboBox.addItemListener(new ReportWindow.ItemChangeListener());
        datesPastYr = new String[365];
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormat timeFormat = new SimpleDateFormat("h:mm a");
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
        datesComboBox.addItemListener(new ReportWindow.ItemChangeListener());


        comboPanel.add(datesComboBox);
        comboPanel.add(reasonsComboBox);

        northPanel.add(new JLabel("Current students waiting to be seen:"), BorderLayout.NORTH);
        northPanel.add(comboPanel, BorderLayout.SOUTH);

        //Setting up centerPanel
        centerPanel = new JPanel();
        //centerPanel.setLayout();
        textArea = new JTextArea();
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        addHeader();

        try
        {
            Data.open();
            String temp = "";
            for (Row row: Data.chooseTable("visits"))
            {
                Table table = Data.chooseTable("user");
                Cursor cursor = CursorBuilder.createCursor(table);
                boolean found = cursor.findFirstRow(Collections.singletonMap("email", row.get("email")));

                temp += addBuffer(dateFormat.format(row.get("visitDate")),15)
                        + addBuffer(timeFormat.format(row.get("visitTime")),15)
                        + addBuffer(cursor.getCurrentRowValue(table.getColumn("fName")).toString(),15)
                        + addBuffer(cursor.getCurrentRowValue(table.getColumn("lName")).toString(),15) + addBuffer(row.get("email").toString(),30)
                        + addBuffer(cursor.getCurrentRowValue(table.getColumn("phone")).toString(),15) + addBuffer(row.get("reason").toString(),40)
                        + addBuffer(followUpSwitcher(row.get("followUp").toString()),15) + addBuffer(row.get("Specialist").toString(),15)
                        + addBuffer(row.get("location").toString(),15) + "\n";
            }

            textArea.append(temp);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerPanel.add(scrollPane);


        //setting up southPanel
        southPanel = new JPanel();

        addDeleteAdminBtn = new JButton("Add / Delete Admin");
        addDeleteAdminBtn.addActionListener(new ReportWindow.ButtonListener());
        southPanel.add(addDeleteAdminBtn);

        addDeleteSpecBtn = new JButton("Add / Delete Specialist");
        addDeleteSpecBtn.addActionListener(new ReportWindow.ButtonListener());
        southPanel.add(addDeleteSpecBtn);

        printFileBtn = new JButton("Print File");
        printFileBtn.addActionListener(new ReportWindow.ButtonListener());
        southPanel.add(printFileBtn);

        closeBtn = new JButton("Close");
        closeBtn.addActionListener(new ReportWindow.CloseButtonListener());
        southPanel.add(closeBtn);


        //adding all panels to frame
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
    }
    private void addHeader() {
        textArea.append(addBuffer("Date", 15));
        textArea.append(addBuffer("Time", 15));
        textArea.append(addBuffer("FirstName", 15));
        textArea.append(addBuffer("LastName", 15));
        textArea.append(addBuffer("Email", 30));
        textArea.append(addBuffer("Phone", 15));
        textArea.append(addBuffer("Reason", 40));
        textArea.append(addBuffer("Follow Up?", 15));
        textArea.append(addBuffer("Specialist", 15));
        textArea.append(addBuffer("Location", 15));

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

    private static String followUpSwitcher(String s) {

        if (s.equalsIgnoreCase("true")) {
            return "Yes";
        }
        else
            return "No";
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
            } else if (e.getSource() == addDeleteAdminBtn) {
                AddDeleteAdminFrame addDeleteAdmin = new AddDeleteAdminFrame();
                addDeleteAdmin.setVisible(true);
            } else if (e.getSource() == addDeleteSpecBtn) {
                AddDeleteSpecFrame addDeleteSpec = new AddDeleteSpecFrame();
                addDeleteSpec.setVisible(true);
            }
        }
    }

    private class CloseButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == closeBtn)
            {
                try {
                    Data.closeData();
                    new LoginFrame();
                    setVisible(false);
                    dispose();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
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

    class ItemChangeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {

                String string = "";
                textArea.setText("");
                addHeader();
                DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                DateFormat timeFormat = new SimpleDateFormat("h:mm a");

                try {
                    for (Row row : Data.chooseTable("visits")) {
                        Table table = Data.chooseTable("user");

                        Cursor cursor = CursorBuilder.createCursor(table);

                        String temp = "";
                        temp += addBuffer(dateFormat.format(row.get("visitDate")),15)
                                + addBuffer(timeFormat.format(row.get("visitTime")),15)
                                //+ addBuffer(cursor.getCurrentRowValue(table.getColumn("fName")).toString(), 15)
                                + addBuffer(cursor.getCurrentRowValue(table.getColumn("lName")).toString(), 15)
                                + addBuffer(row.get("email").toString(), 30)
                                + addBuffer(cursor.getCurrentRowValue(table.getColumn("phone")).toString(), 15)
                                + addBuffer(row.get("reason").toString(), 40)
                                + addBuffer(row.get("followUp").toString(), 15)
                                + addBuffer(row.get("Specialist").toString(), 15)
                                + addBuffer(row.get("location").toString(), 15)
                                + "\n";

                        if (temp.contains(datesComboBox.getSelectedItem().toString())
                                && temp.contains(reasonsComboBox.getSelectedItem().toString()))
                            string += temp;

                        textArea.append(string);

                    }
                } catch (IOException e) {
                    System.out.println("error");
                }
            }
        }

    }
     public ArrayList<ArrayList<String>> read(String query,String key) throws IOException
    {
        ArrayList<ArrayList<String>> aListOfListsOfStrings = new ArrayList<ArrayList<String>>();
        Table table = Data.open().getTable(query);
        for(Row row: table)
        {
            if(row.get("email").toString().equalsIgnoreCase(key))
            {
                ArrayList<String> userStrings = new ArrayList<String>();
                userStrings.add(row.get("visitDate").toString());
                userStrings.add(row.get("visitTime").toString());
                userStrings.add(row.get("reason").toString());
                userStrings.add(row.get("followUp").toString());
                userStrings.add(row.get("email").toString());
                userStrings.add(row.get("ID").toString());
                aListOfListsOfStrings.add(userStrings);
            }
        }
        return aListOfListsOfStrings;
    }
      public ArrayList<ArrayList<String>> read(String query) throws IOException {

        ArrayList<ArrayList<String>> aListOfListsOfStrings = new ArrayList<ArrayList<String>>();
        Table table = Data.open().getTable(query);
        for(Row row: table)
        {
            ArrayList<String> userStrings = new ArrayList<String>();
            userStrings.add(row.get("visitDate").toString());
            userStrings.add(row.get("visitTime").toString());
            userStrings.add(row.get("reason").toString());
            userStrings.add(row.get("followUp").toString());
            userStrings.add(row.get("email").toString());
            userStrings.add(row.get("ID").toString());
            aListOfListsOfStrings.add(userStrings);
                    
        }
        return aListOfListsOfStrings;
    }
}


