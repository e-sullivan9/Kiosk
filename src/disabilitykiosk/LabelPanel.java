/**
 * @author Jacob Dwyer
 */
package disabilitykiosk;
import java.awt.*;
import javax.swing.*;

public class LabelPanel extends JPanel
{
  private final JLabel date, time, name, email, phone, reason, followUp;
  
  public LabelPanel()
  {
    setLayout(new GridLayout(7,1,10,10));
    
    date = new JLabel("\tDate: ");
    date.setFont(new Font("Serif",Font.PLAIN, 18));
    time = new JLabel("\tTime: ");
    time.setFont(new Font("Serif",Font.PLAIN, 18));
    name = new JLabel("\tName: ");
    name.setFont(new Font("Serif",Font.PLAIN, 18));
    email = new JLabel("\tE-mail: ");
    email.setFont(new Font("Serif",Font.PLAIN, 18));
    phone = new JLabel("\tPhone #: ");
    phone.setFont(new Font("Serif",Font.PLAIN, 18));
    reason = new JLabel("\tReason for Visit: ");
    reason.setFont(new Font("Serif",Font.PLAIN, 18));
    followUp = new JLabel("\tFollow Up: ");
    followUp.setFont(new Font("Serif",Font.PLAIN, 18));
    
    add(date);
    add(time);
    add(name);
    add(email);
    add(phone);
    add(reason);
    add(followUp);
  }
}