/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.verifywindow;
//import GUI.reportwindow.*;
import javax.swing.*;
/**
 *
 * @author Jacob
 */
public class InfoPanel extends JPanel
{
    private final JTextField pwInput, userNameInput;
    private final JLabel pwLabel, userNameLabel;
    private String pw, un;
    
    public InfoPanel()
    {
        userNameLabel = new JLabel("User Name: ");
        pwLabel = new JLabel ("Password: ");
        userNameInput = new JTextField(15);
        pwInput = new JTextField(15);
        add(userNameLabel);
        add(userNameInput);
        add(pwLabel);
        add(pwInput);
    }
    
    public String getUserName(){
        un = userNameInput.getText();
        return un;
    }
    
    public String getPW()
    {
        pw = pwInput.getText();
        return pw;
    }
}