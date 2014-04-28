package disabilitykiosk;

/**
 * @author Jacob Dwyer
 */
import java.awt.*;
import javax.swing.*;

public class GreetingsPanel extends JPanel
{
  public GreetingsPanel()
  {
    JLabel greetings = new JLabel("Welcome to the Disability Resource Center Kiosk");
    greetings.setFont(new Font("Serif",Font.BOLD, 30));
    add(greetings);
    
  }
}
   