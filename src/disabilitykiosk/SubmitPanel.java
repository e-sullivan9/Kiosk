/**
 * @author Jacob Dwyer
 * Greetings panel to display a message to the user
 */
package disabilitykiosk;

import javax.swing.*;


public class SubmitPanel extends JPanel
{
    public JButton submit, close, admin;
    public JButton submitSpeech, closeSpeech, adminSpeech;
    private ImageIcon microphone = new ImageIcon("microphone.jpg");
    
    public SubmitPanel()
    {
        submitSpeech = new JButton(microphone);
        closeSpeech = new JButton(microphone);
        adminSpeech = new JButton(microphone);
        submit = new JButton("Submit");
        close = new JButton("Close");
        admin = new JButton("Administrator");
        add(submitSpeech);
        add(submit);
        add(closeSpeech);
        add(close);
        add(adminSpeech);
        add(admin);
        //admin.addActionListener(new AdminButtonListener());
    }
  
//  private class AdminButtonListener implements ActionListener
//  {
//      public void actionPerformed(ActionEvent e)
//      {
//          if (e.getSource() == admin)
//          {
//              setVisible(true);
//              new VerifyWindow(); 
//          }
//      }
//  }
}

