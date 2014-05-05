package GUI.adddeletespec;

import Backend.Specialist;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Spconway 4/26/2014
 */
public class ListPanel extends JPanel{
    
    private JLabel specLabel;
    private Font font = new Font("MONOSPACED", Font.PLAIN, 18);
    //Need to make passT a JPassword field but after that we need to add another
    //JPassword field to confirm password and check that both JPassword fields match
    
    private ArrayList<Specialist> specs = new ArrayList<Specialist>(Backend.SpecialistList.getSpecialList());
    
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
       
       //to hold names for the Scroll Pane
       //ArrayList<String> namesList = new ArrayList<String>();
       
       //get the names of the Specialist objects
       dlm = new DefaultListModel<>();
       updateList();
       //one of these lists is used to display the names, they have the same index
       list = new JList(dlm);
       list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
       list.setLayoutOrientation(JList.VERTICAL);
        
       //nList = new JList(namesList.toArray());
       //add the scroll pane
       scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
       scroll.setPreferredSize(new Dimension(300, 490));
       
       add(specLabel, BorderLayout.NORTH);
       add(scroll, BorderLayout.CENTER);
       setVisible(true);
    }
    public void updateList()
    {
        dlm.clear();
        for (Specialist a : Backend.SpecialistList.specs)
        {
            dlm.addElement(a.getFullName());
        }
    }
    
    
}
