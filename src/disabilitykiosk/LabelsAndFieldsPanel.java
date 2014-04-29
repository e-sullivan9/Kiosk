
package disabilitykiosk;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.*;
import java.io.IOException;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
//import java.awt.setPreferredSize;

 /*
 * @author Spconway 4/26/2014
 * @author Jacob Dwyer 4/28/2014
 */
public class LabelsAndFieldsPanel extends JPanel{
    /*
     * Date object to be used later
     */
    private Date todaysDate = new Date();
    /*
     * Labels, text fields and combo box
     */
    JTextField firstI, lastI, emailI;
	JTextField phoneI;
    JComboBox reasonI;
	JComboBox followUpI;
	JComboBox roleI;
    private JLabel date, time, first, last, email, phone, reason, followUp, role, dateI, timeI;
    private JButton firstButton, lastButton, emailButton, phoneButton, reasonButton, followUpButton, roleButton;
    private ArrayList<JButton> buttonList;
    private ImageIcon microphone = new ImageIcon("microphone.jpg");
    
    /*
     * Character length for text fields
     */
    private final int CHAR_LENGTH = 30;
    
    /*
     * Font for gridbag
     */
    private Font font = new Font("SERIF", Font.PLAIN, 24);
    private Font textFieldFont = new Font("SERIF", Font.PLAIN, 18);
    
    /*
     * Constructor
     */
    public LabelsAndFieldsPanel(){
        super(new GridBagLayout());
        buildPanel();
        setVisible(true);
    }
    
    /*
     * Build panel method
     */
    private void buildPanel(){
        GridBagConstraints grid = new GridBagConstraints();
        grid.fill = GridBagConstraints.HORIZONTAL;
        
        //date
//        dateButton = new JButton();
//        //dateButton.setPreferredSize(new Dimension(40, 40));
//        dateButton.setIcon(microphone);
        date = new JLabel("Date: ");
        date.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 0;
        grid.gridwidth = 2;
        add(date, grid);
        
        //dateI
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd: ");
        dateI = new JLabel(dateFormat.format(todaysDate));
        dateI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 0;
        grid.gridwidth = 4;
        add(dateI, grid);
        
        //time
        time = new JLabel("Time: ");
        time.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 1;
        grid.gridwidth = 2;
        add(time, grid);
        
        //timeI
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm: ");
        timeI = new JLabel(timeFormat.format(todaysDate));
        timeI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 1;
        grid.gridwidth = 4;
        add(timeI, grid);
        
        //first
        firstButton = new JButton();
        firstButton.addActionListener(new firstButtonListener());
        firstButton.setIcon(microphone);
        first = new JLabel("First Name: ");
        first.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 2;
        grid.gridwidth = 1;
        add(firstButton, grid);
        add(first, grid);
        
        //firstI
        firstI = new JTextField(CHAR_LENGTH);
        firstI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 2;
        grid.gridwidth = 4;
        add(firstI, grid);
        
        //last
        lastButton = new JButton();
        lastButton.addActionListener(new lastButtonListener());
        lastButton.setIcon(microphone);
        last = new JLabel("Last Name: ");
        last.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 3;
        grid.gridwidth = 1;
        add(lastButton, grid);
        add(last, grid);
        
        //lastI
        lastI = new JTextField(CHAR_LENGTH);
        lastI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 3;
        grid.gridwidth = 4;
        add(lastI, grid);
        
        //role
        roleButton = new JButton();
        roleButton.addActionListener(new roleButtonListener());
        roleButton.setIcon(microphone);
        role = new JLabel("Role: ");
        role.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 4;
        grid.gridwidth = 1;
        add(roleButton, grid);
        add(role, grid);
        
        //RoleI
        String[] roles = {"Student", "Teacher", "Parent", "Administrator"};
        roleI = new JComboBox(roles);
        roleI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 4;
        grid.gridwidth = 4;
        add(roleI, grid);
        
        //email
        emailButton = new JButton();
        emailButton.addActionListener(new emailButtonListener());
        emailButton.setIcon(microphone);
        email = new JLabel("E-Mail: ");
        email.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 5;
        grid.gridwidth = 1;
        add(emailButton, grid);
        add(email, grid);
        
        //emailI
        emailI = new JTextField(CHAR_LENGTH);
        emailI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 5;
        grid.gridwidth = 4;
        add(emailI, grid);
        
        //phone
        phoneButton = new JButton();
        phoneButton.addActionListener(new phoneButtonListener());
        phoneButton.setIcon(microphone);
        phone = new JLabel("Phone #: ");
        phone.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 6;
        grid.gridwidth = 1;
        add(phoneButton, grid);
        add(phone, grid);
        
        //phoneI
        phoneI = new JTextField(CHAR_LENGTH);
        phoneI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 6;
        grid.gridwidth = 4;
        add(phoneI, grid);
        
        //reason
        reasonButton = new JButton();
        reasonButton.addActionListener(new reasonButtonListener());
        reasonButton.setIcon(microphone);
        reason = new JLabel("Reason: ");
        reason.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 7;
        grid.gridwidth = 1;
        add(reasonButton, grid);
        add(reason, grid);
        
        //reasonI
        String[] reasons = {"New, Prospective Student/Group","Disclose and Document Disability (In-take)","Placement Testing with Accommodation",
      "Schedule An Appointment with Disability Specialist","Meet with a Disability Specialist","Take Test with Accommodations","Drop Off/Pick Up Notes",
      "Academic Advising (Course Selection, Add/Drop, Withdrawal)","Fill Out Accommodation Forms","Address Problems with Specific Accommodations",
      "Address Specific Course Assignment or Issue","Alternative Format for Texts and Handouts",
      "Professional Consultation (Faculty, Staff, Administration, Department)","Other"}; 
        reasonI  = new JComboBox(reasons);
        reasonI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 7;
        grid.gridwidth = 4;
        add(reasonI, grid);
        
        //followUp
        followUpButton = new JButton();
        followUpButton.addActionListener(new followUpButtonListener());
        followUpButton.setIcon(microphone);
        followUp = new JLabel("Follow up: ");
        followUp.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 8;
        grid.gridwidth = 1;
        add(followUpButton, grid);
        add(followUp, grid);
        
        //followUpI
        String[] returnVisit = {"Yes", "No"};
        followUpI = new JComboBox(returnVisit);
        followUpI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 8;
        grid.gridwidth = 4;
        add(followUpI, grid);
    }
    
    
    private class firstButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == firstButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter your first name in the text field";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(text);

       }
       voice.deallocate();
        }

    }
  }
   private class lastButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() ==  lastButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter your last name in the text field";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(string[i]);

       }
       voice.deallocate();
        }

    }
  }
       private class emailButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == emailButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter your email address in the text field";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(text);

       }
       voice.deallocate();
        }

    }
  }
           private class phoneButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == phoneButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter your phone number in the text field";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(text);

       }
       voice.deallocate();
        }

    }
  }
               private class reasonButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == reasonButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter your reason for being here in the drop down list";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(text);

       }
       voice.deallocate();
        }

    }
  }

               private class followUpButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == followUpButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter if this is a follow up visit. Yes or no";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(text);

       }
       voice.deallocate();
        }

    }
  }
         private class roleButtonListener implements ActionListener
{
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == roleButton)
        {
             VoiceManager vm = VoiceManager.getInstance();

            com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
            String text = "Please enter your role with the school in the drop down list";
            String string[] = text.split("  ");
            voice.allocate();
            for (int i = 0; i < string.length; i++) {
                voice.speak(text);

       }
       voice.deallocate();
        }

    }
  }
}
