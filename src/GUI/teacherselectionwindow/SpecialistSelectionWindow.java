package GUI.teacherselectionwindow;

import Backend.Data;
import Backend.User;
import disabilitykiosk.DisabilityKiosk;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SpecialistSelectionWindow extends JFrame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    private final int WINDOW_WIDTH = ((int) tk.getScreenSize().getWidth());
    private final int WINDOW_HEIGHT = ((int) tk.getScreenSize().getHeight());
    private Backend.User user;
    private JButton submit;
    private JPanel panel;
    private ArrayList<JRadioButton> radioButtons;
    private ButtonGroup bg = new ButtonGroup();
    private ArrayList<Backend.Specialist> SPECIALISTS;

    public SpecialistSelectionWindow(User user) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        buildPanel();
        add(panel);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        this.user = user;
    }

    private void buildPanel() {
        submit = new JButton("Submit");
        submit.addActionListener(new SpecialistSelectionWindow.RadioButtonListener());
        panel = new JPanel();

        // create radio buttons and put them in the button group 
        ArrayList<Backend.Specialist> specialistsList = Backend.SpecialistList.getSpecialList();
        radioButtons = new ArrayList<JRadioButton>();
        for (int i = 0; i < specialistsList.size(); i++) {
            /*
             * need to get the specialistsList.get(i).getPhoto() somehow
             */
            String s = specialistsList.get(i).getfName() + " " + specialistsList.get(i).getLname();
            //put faculty names in an array  
            JRadioButton rButton = new JRadioButton(s);
            radioButtons.add(rButton);
        }
        // put buttons in radio group  
        for (int i = 0; i < radioButtons.size(); i++) {
            bg.add((JRadioButton) radioButtons.get(i));
        }
        // put buttons in panel
        for (int i = 0; i < radioButtons.size(); i++) {
            panel.add((JRadioButton) radioButtons.get(i));
        }
        panel.add(submit);
    }

    public ArrayList<Backend.Specialist> getSpecialists() {
        SPECIALISTS = Backend.SpecialistList.getSpecialList();
        return SPECIALISTS;
    }

    public JRadioButton getSelection(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            JRadioButton b = (JRadioButton) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }
        return null;
    }

    public void submitted() {
        JRadioButton selected = getSelection(bg);
        String facultySelected[] = selected.getText().split(" ");
        user.setSpecialist(facultySelected[0], facultySelected[1]);
        try {
            Data.open();
            user.newVisit(Data.chooseTable("visits"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Thank you for using the Disability Kiosk", "Thank You",
                JOptionPane.PLAIN_MESSAGE);
        new DisabilityKiosk();
        this.dispose();
    }

    private class RadioButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                submitted();
            }
        }
    }
}
