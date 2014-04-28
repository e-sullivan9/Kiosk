/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disabilitykiosk;

import GUI.loginwindow.*;
import GUI.teacherselectionwindow.*;
import Backend.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;

/**
 *
 * @author Jacob Dwyer
 */
public class DisabilityKiosk extends JFrame
{
  //Utilizing Toolkit to retrieve screen width and height
  Toolkit tk = Toolkit.getDefaultToolkit();
  private final int WINDOW_WIDTH = ((int) tk.getScreenSize().getWidth()); //Width
  private final int WINDOW_HEIGHT = ((int) tk.getScreenSize().getHeight()); //Height
  //private final LoginWindow login_Window;
  private final GreetingsPanel greetings_Panel;
  //private final InfoPanel info_Panel;
  //private final LabelPanel label_Panel;
  private final LabelsAndFieldsPanel labelsAndFields;
  private final SubmitPanel submit_Panel;
  
  public DisabilityKiosk()
  {
    //Display a title
    setTitle("Disability Resource Kiosk");
    //set the window size
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    //setExtendedState(Frame.MAXIMIZED_vBOTH);
    //setUndecorated(true);
    //Specify an action on close
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    //Create a Border Layout
    setLayout(new BorderLayout());
    
    //Create the custom panels
    greetings_Panel = new GreetingsPanel();
    /*
     * Commented out info_Panel and label_Panel to add the labelsAndFields panel
     * which was made using gridbaglayout
     */
    //info_Panel = new InfoPanel();
    //label_Panel = new LabelPanel();
    Admin.deSerialize();
    labelsAndFields = new LabelsAndFieldsPanel();
    submit_Panel = new SubmitPanel();
    submit_Panel.admin.addActionListener(new AdminButtonListener());
    submit_Panel.close.addActionListener(new CloseButtonListener());
    submit_Panel.submit.addActionListener(new SubmitButtonListener());
    
    //Add the componets to the content pane
    add(greetings_Panel, BorderLayout.NORTH);
    add(labelsAndFields, BorderLayout.CENTER);
    //add(info_Panel, BorderLayout.CENTER);
    //add(label_Panel, BorderLayout.WEST);
    add(submit_Panel, BorderLayout.SOUTH);
    
    //set the windows position to the center of the screen
    setLocationRelativeTo(null);
    //Make the window visable
    setVisible(true);
  }
  
  private class AdminButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          if (e.getSource() == submit_Panel.admin)
          {
              setVisible(true);
              new LoginFrame();
              dispose();
          }
      }
    }
    
  private class CloseButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          if (e.getSource() == submit_Panel.close)
          {
        	  Admin.serialize();
              new LoginFrame();
              setVisible(false);
              dispose();
             //System.exit(0);
          }
      }
    }
  private class SubmitButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          if (e.getSource() == submit_Panel.submit)
          {
              setVisible(false);
              
              boolean temp;
              if(labelsAndFields.followUpI.getSelectedItem() == "Yes")
              	temp = true;
              else
              	temp = false;
              
              try {
              	Data.open();

							
              	
					User.newVisit(Data.chooseTable("visits"),temp, labelsAndFields.reasonI.getSelectedItem().toString(), 
							"wellesley" , labelsAndFields.emailI.getText() , labelsAndFields.firstI.getText() , labelsAndFields.lastI.getText() , 
							labelsAndFields.roleI.getSelectedItem().toString() ,  
							labelsAndFields.phoneI.getText(), "Enter specialist"); //reference speacilist!!
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
          			
             new DisabilityKiosk();
          }
      }
  }
    }
