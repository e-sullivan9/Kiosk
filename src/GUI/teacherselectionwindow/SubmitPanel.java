/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.teacherselectionwindow;
import javax.swing.*;

/**
 *
 * @author Jacob
 */
    public class SubmitPanel extends JPanel
    {
        public JButton submit, edit;
        //private InfoPanel info_Panel;
        public SubmitPanel()
        {
          buildPanel();
        }
        
        public void buildPanel()
        {
        submit = new JButton("Submit");
       // edit = new JButton("Edit Previous Info");
        add(submit);
        //add (edit);
        }
    }