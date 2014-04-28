package disabilitykiosk;

/**
 * @author Jacob Dwyer
 */
import java.awt.*;
import javax.swing.*;

 public class InfoPanel extends JPanel
{
  private final JTextField dateInput, timeInput, nameInput, emailInput, phoneInput;
  private final JComboBox  reasonInput, followUpInput;
  
  public InfoPanel()
  {
    //Create a 7 row 1 column grid layout for formatting 
    setLayout(new GridLayout(7,1,10,10));
    
    //Create the JText fields for user input
    dateInput = new JTextField(30);
    timeInput = new JTextField(30);
    nameInput = new JTextField(30);
    emailInput = new JTextField(30);
    phoneInput = new JTextField(30);
    String[] reasons = {"New, Prospective Student/Group","Disclose and Document Disability (In-take)","Placement Testing with Accommodation",
      "Schedule An Appointment with Disability Specialist","Meet with a Disability Specialist","Take Test with Accommodations","Drop Off/Pick Up Notes",
      "Academic Advising (Course Selection, Add/Drop, Withdrawal)","Fill Out Accommodation Forms","Address Problems with Specific Accommodations",
      "Address Specific Course Assignment or Issue","Alternative Format for Texts and Handouts",
      "Professional Consultation (Faculty, Staff, Administration, Department)","Other"}; 
    reasonInput  = new JComboBox(reasons);
    String[] returnVisit = {"Yes", "No"};
    followUpInput = new JComboBox(returnVisit);
    
    //add each component to the panel
    add(dateInput);
    add(timeInput);
    add(nameInput);
    add(emailInput);
    add(phoneInput);
    add(reasonInput);
    add(followUpInput);
  }
}