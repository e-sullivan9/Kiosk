package GUI.adddeletespec;

import Backend.Specialist;
import Backend.SpecialistList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;



/**
 *
 * @author Spconway 4/26/2014
 */
public class AddDeleteSpecFrame extends JFrame{
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 500;
    private SpecInfoPanel infoPanel;
    private JPanel buttonPanel;
    private JButton addBtn, editBtn, deleteBtn;
    private JList<String> list;
    private DefaultListModel<String> dlm;
    private JScrollPane scroll;
    
    Specialist spec;
    
    public AddDeleteSpecFrame(){
        //Window title
        setTitle("Add/Delete Specialists");
        //Set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Build the main frame and add components
        buildMainFrame();
        //Set location
        setLocationRelativeTo(null);
        //Set visible
        setVisible(true);
        //Block resizing
        setResizable(false);
    }
    
    private void buildMainFrame(){
        dlm = new DefaultListModel<>();
        updateList();
       //one of these lists is used to display the names, they have the same index
        list = new JList(dlm);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
//        submitPanel = new SubmitorDeleteSpec();
        scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(300, 490));
        infoPanel = new SpecInfoPanel();
        //listPanel = new ListPanel();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        //add(infoPanel, BorderLayout.EAST);
//        add(submitPanel, BorderLayout.SOUTH);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        addBtn = new JButton("Add New Specialist");
        addBtn.addActionListener(new submitOrDeleteListener());
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        buttonPanel.add(addBtn, c);
        
        editBtn = new JButton("Edit Specialist");
        editBtn.addActionListener(new submitOrDeleteListener());
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        buttonPanel.add(editBtn, c);
        
        deleteBtn = new JButton("Remove Specialist");
        deleteBtn.addActionListener(new submitOrDeleteListener());
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0.05;
        buttonPanel.add(deleteBtn, c);
        add(buttonPanel, BorderLayout.EAST);
    }
       public void updateList()
    {
        dlm.clear();
        for (Specialist a : Backend.SpecialistList.specs)
        {
            dlm.addElement(a.getFullName());
        }
    }
       private Specialist getSpecialist()
    {
        if (list.getSelectedValue() != null)
        {
            String target = list.getSelectedValue();
            
            for (Specialist a : SpecialistList.specs)
            {
                if (target.equals(a.getFullName()))
                {
                    return a;
                }
            }
        }
        return null;
    }
    //LISTENERS???
    private class submitOrDeleteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == addBtn){
                                int submitted = JOptionPane.showConfirmDialog(null, infoPanel, "Please enter a username and password for the new account.", JOptionPane.OK_CANCEL_OPTION);
                   if (submitted == JOptionPane.OK_OPTION){
                                boolean exists = false;
                        for (Specialist a : SpecialistList.specs)
                        {
                            if (a.getFullName().equals(infoPanel.getFullName()))
                            {
                                exists = true;
                            }
                        }
                    if (exists)
                    {
                        JOptionPane.showMessageDialog(null, "An account with this username already exits.", "Existing Account", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        if(infoPanel.getPhoto().equals(""))
                    {
                                SpecialistList.specs.add(new Specialist(infoPanel.getEmailText(),infoPanel.getFirstName(),infoPanel.getLastName(),infoPanel.getRoleText(),infoPanel.getPhoneText()));
                                updateList();
                                infoPanel.clear();
                    }
                    else
                            {
                                ImageIcon i = new ImageIcon(infoPanel.getPhoto());
                                if(i.getIconHeight()>250||i.getIconWidth()>250){
                                    
                                      JOptionPane.showMessageDialog(null, "Image too Large.", "Image Error", JOptionPane.ERROR_MESSAGE);

                                }
                                else{
                                SpecialistList.specs.add(new Specialist(infoPanel.getPhoto(), infoPanel.getEmailText(),infoPanel.getFirstName(),infoPanel.getLastName(),infoPanel.getRoleText(),infoPanel.getPhoneText()));
                                updateList();
                                infoPanel.clear();
                                }
                    }
                   }
            }
            if (e.getSource() == editBtn){
                if(getSpecialist()!=null){
                infoPanel.setEditUser(getSpecialist());
                int submitted = JOptionPane.showConfirmDialog(null, infoPanel, "Please enter a username and password for the new account.", JOptionPane.OK_CANCEL_OPTION);
                if (submitted == JOptionPane.OK_OPTION){
                    if(infoPanel.getPhoto().equals("")){
                     SpecialistList.specs.set(SpecialistList.specs.indexOf(getSpecialist()),new Specialist(infoPanel.getEmailText(),infoPanel.getFirstName(),infoPanel.getLastName(),infoPanel.getRoleText(),infoPanel.getPhoneText()));
                     updateList();
                     infoPanel.clear();
                    }
                    else{
                        ImageIcon j = new ImageIcon(infoPanel.getPhoto());
                                if(j.getIconHeight()>250||j.getIconWidth()>250){
                                    
                                      JOptionPane.showMessageDialog(null, "Image too Large.", "Image Error", JOptionPane.ERROR_MESSAGE);

                                }
                                else{
                                    SpecialistList.specs.set(SpecialistList.specs.indexOf(getSpecialist()),new Specialist(infoPanel.getPhoto(),infoPanel.getEmailText(),infoPanel.getFirstName(),infoPanel.getLastName(),infoPanel.getRoleText(),infoPanel.getPhoneText()));
                                }
                    }
                }
            }
        }
            if(e.getSource() == deleteBtn){
                if(getSpecialist()!=null){
                     SpecialistList.specs.remove(SpecialistList.specs.indexOf(getSpecialist()));
                     updateList();
                }
            }
    }
}
}
