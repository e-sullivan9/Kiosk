package GUI.adddeleteuser;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Spconway 4/26/2014
 */
public class InfoPanel extends JPanel{
    
    private final int CHAR_LENGTH = 30;
    private JLabel first, last, email, userName, pass;
    private Font font = new Font("MONOSPACED", Font.PLAIN, 18);
    private JTextField firstT, lastT, emailT, userNameT, passT;
    
    public InfoPanel(){
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
        
        lastT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 1;
        grid.gridwidth = 2;
        add(lastT, grid);
        
        //Role
        email = new JLabel("E-Mail");
        email.setFont(font);
        grid.gridx = 0;
        grid.gridy = 2;
        grid.gridwidth = 1;
        add(email, grid);
        
        emailT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 2;
        grid.gridwidth = 2;
        add(emailT, grid);
        
        //User name
        userName = new JLabel("User Name");
        userName.setFont(font);
        grid.gridx = 0;
        grid.gridy = 3;
        grid.gridwidth = 1;
        add(userName, grid);
        
        userNameT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 3;
        grid.gridwidth = 2;
        add(userNameT, grid);
        
        //Password
        pass = new JLabel("Password");
        pass.setFont(font);
        grid.gridx = 0;
        grid.gridy = 4;
        grid.gridwidth = 1;
        add(pass, grid);
        
        passT = new JTextField(CHAR_LENGTH);
     
        grid.gridx = 1;
        grid.gridy = 4;
        grid.gridwidth = 2;
        add(passT, grid);
    }
    
    //getters
    public String getFirstName(){
        return firstT.getText();
    }
    
    public String getLastName(){
        return lastT.getText();
    }
    
    public String getEmailText(){
        return emailT.getText();
    }
    
    public String getUserNameText(){
        return userNameT.getText();
    }
    
    public String getPasswordText(){
        return passT.getText();
    }
}
