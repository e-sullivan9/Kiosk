package GUI.teacherselectionwindow;

import Backend.Data;
import Backend.User;
import disabilitykiosk.DisabilityKiosk;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author Sarah Ben-Kiki
 */
public class SpecialistSelectionWindow extends JFrame {

    Toolkit tk = Toolkit.getDefaultToolkit();
    private final int WINDOW_WIDTH = ((int) tk.getScreenSize().getWidth());
    private final int WINDOW_HEIGHT = ((int) tk.getScreenSize().getHeight());
    private Backend.User user;
    private JButton submit;
    private JPanel panel1, panel2; //panel3, panel4;
    private ArrayList<JRadioButtonMenuItem> radioButtons;
    private ButtonGroup bg = new ButtonGroup();
    private ArrayList<Backend.Specialist> SPECIALISTS;
    //private Border blackline = BorderFactory.createLineBorder(Color.black);

    public SpecialistSelectionWindow(User user) {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        buildPanel1();
        buildPanel2();
        setLayout(new BorderLayout());
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        this.user = user;
    }

    private void buildPanel1() {
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createEmptyBorder(100, 300,60,300));
        ArrayList<Backend.Specialist> specialistsList = Backend.SpecialistList.specs;
        radioButtons = new ArrayList<JRadioButtonMenuItem>();
        for (int i = 0; i < specialistsList.size(); i++) {
            Icon picture = specialistsList.get(i).getPhoto();
            String name = specialistsList.get(i).getfName() + " " + specialistsList.get(i).getLname();
            JRadioButtonMenuItem rButton = new JRadioButtonMenuItem(name, picture, true);
            rButton.setFont(new Font("serif",Font.BOLD, 30));
            rButton.isBorderPainted();
            radioButtons.add(rButton);
        }
        for (int i = 0; i < radioButtons.size(); i++) {
            bg.add((JRadioButtonMenuItem) radioButtons.get(i));
        }
        for (int i = 0; i < radioButtons.size(); i++) {
            panel1.add((JRadioButtonMenuItem)radioButtons.get(i));
        }
    }
    
    private void buildPanel2(){
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 100, 150, 100));

        submit = new JButton("Submit");
        submit.addActionListener(new SpecialistSelectionWindow.RadioButtonListener());
        submit.setPreferredSize(new Dimension(100, 50));
        panel2.add(submit);
    }

    public ArrayList<Backend.Specialist> getSpecialists() {
        SPECIALISTS = Backend.SpecialistList.getSpecialList();
        return SPECIALISTS;
    }

    public JRadioButtonMenuItem getSelection(ButtonGroup group) {
        for (Enumeration e = group.getElements(); e.hasMoreElements();) {
            JRadioButtonMenuItem b = (JRadioButtonMenuItem) e.nextElement();
            if (b.getModel() == group.getSelection()) {
                return b;
            }
        }
        return null;
    }

    public void submitted() {
        JRadioButtonMenuItem selected = getSelection(bg);
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