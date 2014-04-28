/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.verifywindow;
import javax.swing.*;
/**
 *
 * @author Jacob
 */
public class GreetingsPanel extends JPanel
{
  public GreetingsPanel()
  {
    JLabel greetings = new JLabel("Please enter a user name and password");
    add(greetings);
    
  }
}
