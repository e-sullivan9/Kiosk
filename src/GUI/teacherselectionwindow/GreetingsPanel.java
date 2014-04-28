/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.teacherselectionwindow;
import java.awt.Font;
import javax.swing.*;
/**
 *
 * @author Jacob
 */
public class GreetingsPanel extends JPanel
{
  public GreetingsPanel()
  {
    JLabel greetings = new JLabel("Please select the teacher you would like to see.");
    greetings.setFont(new Font("Serif",Font.BOLD, 30));
    add(greetings);
    
  }
}