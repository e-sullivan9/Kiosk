package GUI.adddeletespec;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Spconway 4/26/2014
 */
public class ListPanel extends JPanel{
    
    private final int CHAR_LENGTH = 30;
    private JLabel specLabel;
    private Font font = new Font("MONOSPACED", Font.PLAIN, 18);
    //Need to make passT a JPassword field but after that we need to add another
    //JPassword field to confirm password and check that both JPassword fields match
    
    private ArrayList specs = new ArrayList(Backend.SpecialistList.getSpecialList());
    private JList list;
    private DefaultListModel dlm;
    private JScrollPane scroll;
    
    public ListPanel(){
        super(new BorderLayout());
        buildPanel();
        setVisible(true);
    }
    
    private void buildPanel(){
        
       specLabel = new JLabel("Specialists");
        
       //dlm = new DefaultListModel();

       list = new JList(specs.toArray());
       scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
       add(specLabel, BorderLayout.NORTH);
       add(scroll, BorderLayout.CENTER);
       setVisible(true);
    }
    
    
}
