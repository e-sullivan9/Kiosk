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

/**
 *
 * @author Spconway 4/26/2014
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
        date = new JLabel("Date");
        date.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 0;
        grid.gridwidth = 2;
        add(date, grid);
        
        //dateI
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyy/MM/dd");
        dateI = new JLabel(dateFormat.format(todaysDate));
        dateI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 0;
        grid.gridwidth = 4;
        add(dateI, grid);
        
        //time
        time = new JLabel("Time");
        time.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 1;
        grid.gridwidth = 2;
        add(time, grid);
        
        //timeI
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeI = new JLabel(timeFormat.format(todaysDate));
        timeI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 1;
        grid.gridwidth = 4;
        add(timeI, grid);
        
        //first
        first = new JLabel("First Name");
        first.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 2;
        grid.gridwidth = 2;
        add(first, grid);
        
        //firstI
        firstI = new JTextField(CHAR_LENGTH);
        firstI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 2;
        grid.gridwidth = 4;
        add(firstI, grid);
        
        //last
        last = new JLabel("Last Name");
        last.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 3;
        grid.gridwidth = 2;
        add(last, grid);
        
        //lastI
        lastI = new JTextField(CHAR_LENGTH);
        lastI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 3;
        grid.gridwidth = 4;
        add(lastI, grid);
        
        //role
        role = new JLabel("Role");
        role.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 4;
        grid.gridwidth = 2;
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
        email = new JLabel("E-Mail");
        email.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 5;
        grid.gridwidth = 2;
        add(email, grid);
        
        //emailI
        emailI = new JTextField(CHAR_LENGTH);
        emailI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 5;
        grid.gridwidth = 4;
        add(emailI, grid);
        
        //phone
        phone = new JLabel("Phone #");
        phone.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 6;
        grid.gridwidth = 2;
        add(phone, grid);
        
        //phoneI
        phoneI = new JTextField(CHAR_LENGTH);
        phoneI.setFont(textFieldFont);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 6;
        grid.gridwidth = 4;
        add(phoneI, grid);
        
        //reason
        reason = new JLabel("Reason");
        reason.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 7;
        grid.gridwidth = 2;
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
        followUp = new JLabel("Follow up");
        followUp.setFont(font);
        grid.gridx = GridBagConstraints.RELATIVE;
        grid.gridy = 8;
        grid.gridwidth = 2;
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
}
