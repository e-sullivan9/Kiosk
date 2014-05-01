package Backend;
import disabilitykiosk.DisabilityKiosk;

import java.io.IOException;
import javax.swing.ImageIcon;


/**
 *
 * @author Ian
 */
public class KioskRun {

    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String[] args) throws IOException {
       
        
       SpecialistList s = new SpecialistList();
       s.addSpecialist(new ImageIcon("src/team-adam.png"), "", "Adam" , "Kline", "", "");
       s.addSpecialist(new ImageIcon("src/team-alan.png"), "", "Alan", "Hamilton", "", "");
       s.addSpecialist(new ImageIcon("src/team_arun.jpg"), "", "Arun", "Syrus", "", "");
       s.addSpecialist(new ImageIcon("src/team_fritz.jpg"), "", "Fritz", "Engel", "", "");
       s.addSpecialist(new ImageIcon("src/team-ambica.png"), "", "Ambica", "Ghezzo", "", "");
       s.addSpecialist(new ImageIcon("src/team-carrie.png"), "", "Carrie", "Mellins", "", "");
       s.addSpecialist(new ImageIcon("src/team-chris.png"), "", "Chris", "Zilonis", "", "");
       s.addSpecialist(new ImageIcon("src/team-dexter.png"), "", "Dexter", "Morgan", "", "");
       s.addSpecialist(new ImageIcon("src/team-peter.png"), "", "Peter", "Holloway", "", "");
       s.addSpecialist(new ImageIcon("src/team-vishal.png"), "", "Vishal", "Pirie", "", "");
       Data data = new Data();
       SpecialistList.serialize();
       Admin admin = new Admin();
       //User user = new User();

       DisabilityKiosk dk = new DisabilityKiosk();
    }
    
}