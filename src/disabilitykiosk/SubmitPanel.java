/**
 * @author Jacob Dwyer
 * Greetings panel to display a message to the user
 */
package disabilitykiosk;

import javax.swing.*;


public class SubmitPanel extends JPanel
{
    public JButton submit, close, admin;
    
    public SubmitPanel()
    {
        submit = new JButton("Submit");
        close = new JButton("Close");
        admin = new JButton("Administrator");
        add(submit);
        add(close);
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

