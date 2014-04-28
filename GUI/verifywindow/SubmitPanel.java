/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.verifywindow;
import javax.swing.*;
/**
 *
 * @author Jacob
 */
    public class SubmitPanel extends JPanel
    {
       // VerifyWindow verify_Window = new VerifyWindow();
        public JButton submit, cancel;
       // private InfoPanel info_Panel;
        public SubmitPanel()
        {
          buildPanel();
        }
        
        public void buildPanel()
        {
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        add(submit);
        add(cancel);
        }
        
    }
