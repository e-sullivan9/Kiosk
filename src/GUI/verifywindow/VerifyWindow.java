/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.verifywindow;
import GUI.reportwindow.*;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import java.awt.event.*;
import java.io.IOException;

/**
 *
 * @author Jacob
 */
public class VerifyWindow extends JFrame 
{
  private final int WINDOW_WIDTH = 350; //Width
  private final int WINDOW_HEIGHT = 150; //Height
  private GUI.verifywindow.GreetingsPanel greetings_Panel;
  private GUI.verifywindow.InfoPanel info_Panel;
  private GUI.verifywindow.SubmitPanel submit_Panel;
  
    public VerifyWindow()
  {
    //Display a title
    setTitle("Login Window");
    //set the window size
    setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
    //Specify an action on close
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Create a Border Layout
    setLayout(new BorderLayout());
    
    buildPanels();
    setLocationRelativeTo(null);
    //Make the window visable
    setVisible(true);
    setResizable(false);
  }
    
    public void buildPanels()
    {
    greetings_Panel = new GreetingsPanel();    
    submit_Panel = new SubmitPanel();
    submit_Panel.cancel.addActionListener(new CancelButtonListener());
    submit_Panel.submit.addActionListener(new SubmitButtonListener());
    info_Panel = new InfoPanel();
    add(greetings_Panel, BorderLayout.NORTH);
    add(submit_Panel, BorderLayout.SOUTH);
    add(info_Panel, BorderLayout.CENTER);
    }

    private class SubmitButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == submit_Panel.submit)
            {
                setVisible(false);
                try {
					new ReportWindow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
    }
    
    private class CancelButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == submit_Panel.cancel)
            {
                setVisible(false);
            }
        }
    }
}
