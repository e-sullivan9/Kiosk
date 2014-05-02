package GUI.adddelete;

import Backend.Admin;
import Backend.AdminAccount;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

// Created by Pat and Cyrus

public class AddDeleteAdminFrame extends JFrame
{
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 500;
    
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JScrollPane listScroller;
    
    private JPanel buttonPanel;
    private JButton addBtn, editBtn, deleteBtn;
    
    public AddDeleteAdminFrame()
    {
        setTitle("Add/Delete Administrators");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        buildMainFrame();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }
    
    private void buildMainFrame()
    {
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
    
    private void updateList()
    {
        listModel.clear();
        for (AdminAccount a : Backend.Admin.admins)
        {
            listModel.addElement(a.getUsername());
        }
    }
    
    private AdminAccount getAdmin()
    {
        if (list.getSelectedValue() != null)
        {
            String target = list.getSelectedValue();
            
            for (AdminAccount a : Admin.admins)
            {
                if (target.equals(a.getUsername()))
                {
                    return a;
                }
            }
        }
        return null;
    }
    
    private class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == addBtn)
            {
                JPanel adminInput = new JPanel();
                JTextField unInput = new JTextField(10);
                JPasswordField pwInput = new JPasswordField(10);
                adminInput.add(new JLabel("Username: " ));
                adminInput.add(unInput);
                adminInput.add(Box.createHorizontalStrut(15));
                adminInput.add(new JLabel("Password: "));
                adminInput.add(pwInput);
                int submitted = JOptionPane.showConfirmDialog(null, adminInput, "Please enter a username and password for the new account.", JOptionPane.OK_CANCEL_OPTION);
                
                if (submitted == JOptionPane.OK_OPTION)
                {
                    boolean exists = false;
                    
                    for (AdminAccount a : Admin.admins)
                    {
                        if (a.getUsername().equals(unInput.getText()))
                        {
                            exists = true;
                        }
                    }
                    if (exists)
                    {
                        JOptionPane.showMessageDialog(null, "An account with this username already exits.", "Existing Account", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        Admin.admins.add(new AdminAccount(unInput.getText(), pwInput.getText()));
                        updateList();
                    }
                }
            }
            else if (e.getSource() == editBtn)
            {
                if (getAdmin() != null)
                {
                    JPanel passCheck = new JPanel();
                    JPasswordField passInput = new JPasswordField(20);
                    passCheck.add(new JLabel("Password: "));
                    passCheck.add(passInput);
                    int entered = JOptionPane.showConfirmDialog(null, passCheck, "Please enter the current password for this account.", JOptionPane.OK_CANCEL_OPTION);

                    if (entered == JOptionPane.OK_OPTION)
                    {
                        if (passInput.getText().equals(getAdmin().getPassword()))
                        {
                            JPanel adminInput = new JPanel();
                            JTextField unInput = new JTextField(10);
                            JPasswordField pwInput = new JPasswordField(10);
                            adminInput.add(new JLabel("Username: " ));
                            adminInput.add(unInput);
                            adminInput.add(Box.createHorizontalStrut(15));
                            adminInput.add(new JLabel("Password: "));
                            adminInput.add(pwInput);
                            int submitted = JOptionPane.showConfirmDialog(null, adminInput, "Please enter a new username and password for this account.", JOptionPane.OK_CANCEL_OPTION);

                            if (submitted == JOptionPane.OK_OPTION)
                            {
                                Admin.admins.set(Admin.admins.indexOf(getAdmin()), new AdminAccount(unInput.getText(), pwInput.getText()));
                                updateList();
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Incorrect Password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select an account to edit.", "Select Account", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getSource() == deleteBtn)
            {
                if (getAdmin() != null)
                {
                    if (Admin.admins.size() == 1)
                    {
                        JOptionPane.showMessageDialog(null, "You cannot delete the last Administrator.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else 
                    {
                        JPanel passCheck = new JPanel();
                        JPasswordField passInput = new JPasswordField(20);
                        passCheck.add(new JLabel("Password: "));
                        passCheck.add(passInput);
                        int entered = JOptionPane.showConfirmDialog(null, passCheck, "Please enter the current password for this account.", JOptionPane.OK_CANCEL_OPTION);

                        if (entered == JOptionPane.OK_OPTION)
                        {
                            if (passInput.getText().equals(getAdmin().getPassword()))
                            {
                                int entered2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?", "Verification", JOptionPane.YES_NO_OPTION);

                                if (entered2 == JOptionPane.YES_OPTION)
                                {
                                    Admin.admins.remove(getAdmin());
                                    updateList();
                                }
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Incorrect Password.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select an account to remove.", "Select Account", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
