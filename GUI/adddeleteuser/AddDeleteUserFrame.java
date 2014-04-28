package GUI.adddeleteuser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;



/**
 *
 * @author Spconway 4/26/2014
 */
public class AddDeleteUserFrame extends JFrame{
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 300;
    private SubmitorDelete submitPanel;
    private InfoPanel infoPanel;
    
    public AddDeleteUserFrame(){
        //Window title
        setTitle("Add/Delete User");
        //Set default close operation
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Build the main frame and add components
        buildMainFrame();
        //Set location
        setLocationRelativeTo(null);
        //Set visible
        setVisible(true);
        //Block resizing
        setResizable(false);
    }
    
    private void buildMainFrame(){
        submitPanel = new SubmitorDelete();
        infoPanel = new InfoPanel();
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        setLayout(new BorderLayout());
        
        add(infoPanel, BorderLayout.CENTER);
        add(submitPanel, BorderLayout.SOUTH);
    }
    
    //LISTENERS???
    private class submitOrDeleteListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            
        }
    }
}
