/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disabilitykiosk;

import GUI.loginwindow.*;
import GUI.teacherselectionwindow.*;
import Backend.*;
import com.sun.speech.freetts.VoiceManager;
import disabilitykiosk.LabelsAndFieldsPanel.*;
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.io.IOException;
import java.util.Hashtable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
  private Backend.User user;
  
  public DisabilityKiosk()
  {
    //Display a title
    setTitle("Disability Resource Kiosk");
    //set the window size
    //setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    //setExtendedState(Frame.MAXIMIZED_vBOTH);
    //setUndecorated(true);
    //Specify an action on close
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    /*
     * TRYING TO GET RID OF TASK BAR
     */
                //--Below code code are different options for 
                //--creating full screen effect minus taskbar
                //--no way of testing on my mac so whoever tests
                //--can delete the code that isn't needed
                //--don't forget to comment out the setSize method on line 45
                //--before trying these options though
                //--lastly, setVisible(true) is on line 107
    
                //--option 1--//
//    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
//    if(gd.isFullScreenSupported()){
//        setUndecorated(true);
//        gd.setFullScreenWindow(this);
//    }else{
//        JOptionPane.showMessageDialog(rootPane, "Full screen not supported.");
//        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
//    }
                //--option 2--//
//    this.setSize(this.getToolkit().getScreenSize());
                //--option 3--//
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    setUndecorated(true);
    
    /*
     * ABOVE CODE IS TRYING TO GET RID OF TASK BAR
     */
    //Create a Border Layout
    setLayout(new BorderLayout());
    
    //Create the custom panels
    greetings_Panel = new GreetingsPanel();
    /*
     * Commented out info_Panel and label_Panel to add the labelsAndFields panel
     * which was made using gridbaglayout
     */
    labelsAndFields = new LabelsAndFieldsPanel();
    submit_Panel = new SubmitPanel();
    submit_Panel.admin.addActionListener(new DisabilityKiosk.AdminButtonListener());
    submit_Panel.close.addActionListener(new DisabilityKiosk.CloseButtonListener());
    submit_Panel.submit.addActionListener(new DisabilityKiosk.SubmitButtonListener());
//    submit_Panel.submitSpeech.addActionListener(new DisabilityKiosk.SubmitSpeechButtonListener());
//    submit_Panel.closeSpeech.addActionListener(new DisabilityKiosk.CloseSpeechButtonListener());
//    submit_Panel.adminSpeech.addActionListener(new DisabilityKiosk.AdminSpeechButtonListener());
    
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
              new LoginFrame();
              setVisible(false);
              dispose();
          }
      }
    }
  private class SubmitButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
          if(!SpecialistList.getSpecialList().isEmpty()){
          boolean flag = true;
            if( labelsAndFields.getEmail().length() == 0 )
            {
              flag = false;
            }
            else if (labelsAndFields.getLast().length() == 0 )
            {
              flag = false;
              
            }
            else if(labelsAndFields.getFirst().length() == 0)
            {
              flag = false;
            }
            else if( labelsAndFields.getPhone().length() == 0)
            {
              flag  = false;
            }
            else if( flag = true)
            {
              boolean temp;
                if(labelsAndFields.followUpI.getSelectedItem() == "Yes")
                temp = true;
              else
                temp = false;
               user = new User(labelsAndFields.getFollowUp(), labelsAndFields.getReason(),
                      labelsAndFields.getLocationInput(), labelsAndFields.getEmail(),
                      labelsAndFields.getFirst(), labelsAndFields.getLast(),
                      labelsAndFields.getRole(), labelsAndFields.getPhone());
              
              setVisible(false);
              new GUI.teacherselectionwindow.SpecialistSelectionWindow(user);
            }
          
            if(flag == false)
            {
              JOptionPane.showMessageDialog(null,"Please Enter the Correct Information","Incomplete",JOptionPane.ERROR_MESSAGE);
            }
      }
            else{
    JOptionPane.showMessageDialog(null,"No Specailist in List","Incomplete",JOptionPane.ERROR_MESSAGE);
  }
}
  }
}
//           private class SubmitSpeechButtonListener implements ActionListener
//{
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == submit_Panel.submitSpeech)
//        {
//             VoiceManager vm = VoiceManager.getInstance();
//
//            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
//            String text = "Submit your answers";
//            String string[] = text.split("  ");
//            voice.allocate();
//            for (int i = 0; i < string.length; i++) {
//                voice.speak(text);
//
//       }
//       voice.deallocate();
//        }
//
//    }
//  }
//           
//        private class CloseSpeechButtonListener implements ActionListener
//{
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == submit_Panel.closeSpeech)
//        {
//             VoiceManager vm = VoiceManager.getInstance();
//
//            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
//            String text = "Close the window";
//            String string[] = text.split("  ");
//            voice.allocate();
//            for (int i = 0; i < string.length; i++) {
//                voice.speak(text);
//
//       }
//       voice.deallocate();
//        }
//
//    }
//  }
//      private class AdminSpeechButtonListener implements ActionListener
//{
//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == submit_Panel.adminSpeech)
//        {
//             VoiceManager vm = VoiceManager.getInstance();
//
//            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
//            String text = "Admins only.";
//            String string[] = text.split("  ");
//            voice.allocate();
//            for (int i = 0; i < string.length; i++) {
//                voice.speak(text);
//
//       }
//       voice.deallocate();
//        }
//
//    }
//  }  
//}
