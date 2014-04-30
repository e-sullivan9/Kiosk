package Backend;



import disabilitykiosk.DisabilityKiosk;

import java.io.IOException;


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
       s.addSpecialist(null, "", "Eric" , "Sullivan", "", "");
       s.addSpecialist(null, "", "Stephen", "Conway", "", "");
       Data data = new Data();
       SpecialistList.serialize();
       Admin admin = new Admin();
       //User user = new User();

       DisabilityKiosk dk = new DisabilityKiosk();
    }
    
}
