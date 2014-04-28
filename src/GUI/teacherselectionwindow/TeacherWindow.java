/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.teacherselectionwindow;
import disabilitykiosk.*;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.event.*;

/**
 *
 * @author Jacob
 */
public class TeacherWindow extends JFrame 
{
  //Utilizing Toolkit to retrieve screen width and height
  Toolkit tk = Toolkit.getDefaultToolkit();
  private final int WINDOW_WIDTH = ((int) tk.getScreenSize().getWidth()); //Width
  private final int WINDOW_HEIGHT = ((int) tk.getScreenSize().getHeight()); //Height
  private GUI.teacherselectionwindow.GreetingsPanel greetings_Panel;
  //private GUI.teacherwindow.InfoPanel info_Panel;
  private GUI.teacherselectionwindow.SubmitPanel submit_Panel;
  
    public TeacherWindow()
  {
    //Display a title
    setTitle("Teacher Selection Window");
    //set the window size
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    //Specify an action on close
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    //Create a Border Layout
    setLayout(new BorderLayout());
    
    buildPanels();
    setLocationRelativeTo(null);
    //Make the window visable
    setVisible(true);
    setResizable(false);
  }
    
    public void buildPanels()
    {
    greetings_Panel = new GreetingsPanel();    
    submit_Panel = new SubmitPanel();
    submit_Panel.submit.addActionListener(new SubmitButtonListener());
   // submit_Panel.edit.addActionListener(new EditButtonListener());
    //info_Panel = new InfoPanel();
    add(greetings_Panel, BorderLayout.NORTH);
    add(submit_Panel, BorderLayout.SOUTH);
    //add(info_Panel, BorderLayout.CENTER);
    }

      private class SubmitButtonListener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
          {
              if (e.getSource() == submit_Panel.submit)
              {
                  //disabilitykiosk.setVisible(false);
                  new DisabilityKiosk();
                  setVisible(false);
              }
          }
      }
    
//    private class EditButtonListener implements ActionListener
//    {
//        public void actionPerformed(ActionEvent e)
//        {
//            if (e.getSource() == submit_Panel.edit)
//            {
//                setVisible(true);
//                
//            }
//        }
//    }
}
