package GUI.adddelete;

import Backend.Admin;
import Backend.AdminAccount;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;



/**
 * Created by Pat
 */
public class AddDeleteAdminFrame extends JFrame{
    private final int WINDOW_WIDTH = 450;
    private final int WINDOW_HEIGHT = 300;
    
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JScrollPane listScroller;
    
    private JPanel buttonPanel;
    private JButton addBtn, editBtn, deleteBtn;
    
    public AddDeleteAdminFrame(){
        setTitle("Add/Delete Administrators");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        //Setting Layout for Frame
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildMainFrame();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private void buildMainFrame(){
        listModel = new DefaultListModel<>();
        
        updateList();
        list = new JList<>(listModel);
        
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        
        listScroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(listScroller, BorderLayout.CENTER);
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        addBtn = new JButton("Add New Admin");
        addBtn.addActionListener(new ButtonListener());
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        buttonPanel.add(addBtn, c);
        
        editBtn = new JButton("Edit Admin");
        editBtn.addActionListener(new ButtonListener());
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        buttonPanel.add(editBtn, c);
        
        deleteBtn = new JButton("Remove Admin");
        deleteBtn.addActionListener(new ButtonListener());
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        buttonPanel.add(deleteBtn, c);
        
        add(buttonPanel, BorderLayout.EAST);
    }
    private void updateList() {
        listModel.clear();
        for (AdminAccount a : Backend.Admin.admins) {
            listModel.addElement(a.getUsername());
        }
    }
    private AdminAccount getAdmin() {
        if (list.getSelectedValue() != null) {
            String target = list.getSelectedValue();
            for (AdminAccount a : Admin.admins) {
                if (a.getUsername().equals(target)) {
                    return a;
                }
            }
        }
        return null;
    }
    
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == addBtn) {
                JPanel adminInput = new JPanel();
                JTextField unInput = new JTextField(10);
                JPasswordField pwInput = new JPasswordField(10);
                adminInput.add(new JLabel("Username: " ));
                adminInput.add(unInput);
                adminInput.add(Box.createHorizontalStrut(15));
                adminInput.add(new JLabel("Password: "));
                adminInput.add(pwInput);
                int submitted = JOptionPane.showConfirmDialog(null, adminInput, "Please enter new Admin Username & Password.", JOptionPane.OK_CANCEL_OPTION);
                if (submitted == JOptionPane.OK_OPTION) {
                    Admin.admins.add(new AdminAccount(unInput.getText(), pwInput.getText()));
                    updateList();
                }
            } else if (e.getSource() == editBtn) {
                JPanel adminInput = new JPanel();
                JTextField unInput = new JTextField(10);
                JPasswordField pwInput = new JPasswordField(10);
                adminInput.add(new JLabel("Username: " ));
                adminInput.add(unInput);
                adminInput.add(Box.createHorizontalStrut(15));
                adminInput.add(new JLabel("Password: "));
                adminInput.add(pwInput);
                int submitted = JOptionPane.showConfirmDialog(null, adminInput, "Please enter new Admin Username & Password for this Administrator.", JOptionPane.OK_CANCEL_OPTION);
                if (submitted == JOptionPane.OK_OPTION) {
                    Admin.admins.set(Admin.admins.indexOf(getAdmin()), new AdminAccount(unInput.getText(), pwInput.getText()));
                    updateList();
                }
            } else if (e.getSource() == deleteBtn) {
                if (Admin.admins.size() == 1) {
                    JOptionPane.showMessageDialog(null, "Unable to delete the last Administrator.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Admin.admins.remove(getAdmin());
                }
                updateList();
            }
        }
    }
}
