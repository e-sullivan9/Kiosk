package GUI.adddeletespec;

import Backend.Specialist;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Spconway 4/26/2014
 */
public class SpecInfoPanel extends JPanel{
    
    private final int CHAR_LENGTH = 30;
    private JLabel first, last, photo, email, role, phone;
    private Font font = new Font("MONOSPACED", Font.PLAIN, 18);
    //Need to make passT a JPassword field but after that we need to add another
    //JPassword field to confirm password and check that both JPassword fields match
    private JTextField firstT, lastT, emailT, photoT, roleT, phoneT;
    private JButton fileselector;
   // private JComboBox locationI;
    
    public SpecInfoPanel(){
        super(new GridBagLayout());
        buildPanel();
        setVisible(true);
    }
    
    private void buildPanel(){
        GridBagConstraints grid = new GridBagConstraints();
        
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        /*
         * Begin initialization and add contents to grid
         */
        
        //First name 
        first = new JLabel("First Name");
        first.setFont(font);
        grid.gridx = 0;
        grid.gridy = 0;
        grid.gridwidth = 1;
        add(first, grid);
        
        //input field for first name
        firstT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 0;
        grid.gridwidth = 2;
        add(firstT, grid);
        
        //Last name
        last = new JLabel("Last Name");
        last.setFont(font);
        grid.gridx = 0;
        grid.gridy = 1;
        grid.gridwidth = 1;
        add(last, grid);
        
        //input field for first name
        lastT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 1;
        grid.gridwidth = 2;
        add(lastT, grid);
        
        //Location
        photo = new JLabel("Photo");
        photo.setFont(font);
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        add(photo, grid);
        
        photoT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 2;
        grid.gridwidth = 1;
        add(photoT, grid);
        
        fileselector = new JButton("...");
        
        grid.gridx = 3;
        grid.gridy = 2;
        grid.gridwidth = 1;
        add(fileselector,grid);
        fileselector.addActionListener(new Listener());
        
        //Email
        email = new JLabel("E-Mail");
        email.setFont(font);
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        add(email, grid);
        
        emailT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 3;
        grid.gridwidth = 2;
        add(emailT, grid);
        
        //Email
        phone = new JLabel("Phone");
        phone.setFont(font);
        grid.gridx = 0;
        grid.gridy = 5;
        grid.gridwidth = 1;
        add(phone, grid);
        
        phoneT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 5;
        grid.gridwidth = 2;
        add(phoneT, grid);
        
        //role
        role = new JLabel("Role");
        role.setFont(font);
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        add(role, grid);
        
        roleT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 4;
        grid.gridwidth = 2;
        add(roleT, grid);
        
        
        
        
    }
    
    //getters
    public String getFirstName(){
        return firstT.getText();
    }
    
    public String getLastName(){
        return lastT.getText();
    }
    public String getFullName(){
        return firstT.getText()+" "+lastT.getText();
    }
    public void clear(){
        firstT.setText("");
        lastT.setText("");
        emailT.setText("");
        phoneT.setText("");
        roleT.setText("");
        photoT.setText("");
    }
    
    public String getEmailText(){
        return emailT.getText();
    }
    public String getRoleText(){
        return roleT.getText();
    }
    public String getPhoneText(){
        return phoneT.getText();
    }
    public String getPhoto(){
        return photoT.getText();
    }
    public void setEditUser(Specialist a){
        firstT.setText(a.getfName());
        lastT.setText(a.getLname());
        emailT.setText(a.getEmail());
        phoneT.setText(a.getPhone());
        roleT.setText(a.getRole());
        if(photoT.getText().equals(""))
        photoT.setText(a.getPhoto().getDescription());
    }
    private class Listener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == fileselector){
                JFileChooser fc = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Img File", "jpg", "png"); // create a filter
                fc.setFileFilter(filter);
                int f = fc.showDialog(SpecInfoPanel.this,"");
                if(f == JFileChooser.APPROVE_OPTION){
                    photoT.setText(fc.getSelectedFile().getAbsolutePath());
                }
            }
        }
    }
}
