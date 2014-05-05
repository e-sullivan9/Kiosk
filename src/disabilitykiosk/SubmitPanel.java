/**
 * @author Jacob Dwyer
 * Submit panel with speech to text buttons
 */
package disabilitykiosk;

import javax.swing.*;
import java.awt.*;


public class SubmitPanel extends JPanel
{
    public JPanel panel_1 , panel_2, panel_3, panel_4, panel_5;
    public JButton submit, close, admin;
//    public JButton submitSpeech, closeSpeech, adminSpeech;
//    private ImageIcon microphone = new ImageIcon("src/microphone.jpg");
    
    public SubmitPanel()
    {
        //Create grid layout
        super(new GridLayout(0,5,10,10));
        //crete 5 panels for lame formatting
        panel_1 = new JPanel(new GridLayout(0,1));
        panel_2 = new JPanel();
        panel_3 = new JPanel(new GridLayout(0,1));
        panel_4 = new JPanel();
        panel_5 = new JPanel(new GridLayout(0,1));
      
       //add them to the panel
        add(panel_1);
        add(panel_2);
        add(panel_3);
        add(panel_4);
        add(panel_5);
        //set microphone .jpg to the speech to text buttons
//        submitSpeech = new JButton(microphone);
//        closeSpeech = new JButton(microphone);
//        adminSpeech = new JButton(microphone);
        //create action buttons
        submit = new JButton("Submit");
        close = new JButton("Close");
        admin = new JButton("Administrator");

        //add them to each panel
//        panel_1.add(submitSpeech);
        panel_1.add(submit);

      //  panel_3.add(closeSpeech);
      //  panel_3.add(close);
        
     //   panel_5.add(adminSpeech);
        panel_5.add(admin);
    }
}


