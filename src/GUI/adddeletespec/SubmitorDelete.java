package GUI.adddeletespec;
import javax.swing.*;

/**
 *
 * @author Spconway 4/26/2014
 */
public class SubmitorDelete extends JPanel{
    private JButton addButton;
    private JButton deleteButton;
    
    public SubmitorDelete(){
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
