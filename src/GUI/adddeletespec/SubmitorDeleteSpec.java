package GUI.adddeletespec;
import Backend.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Spconway 4/26/2014
 */
public class SubmitorDeleteSpec extends JPanel{
    public static JButton addButton;
    private JButton deleteButton;
    
    
    
    public SubmitorDeleteSpec(){
        addButton = new JButton("Add User");
        deleteButton = new JButton("Delete User");
        add(addButton);
        add(deleteButton);
    }
    
    
    
    
    
    public final JButton getAddButton(){
        return this.addButton;
    }
    
    public final JButton getDeleteButton(){
        return this.deleteButton;
    }
    
    
    
}
