/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package disabilitykiosk;

import com.sun.speech.freetts.VoiceManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eric Sullivan
 */
public class Speech implements Runnable {
    String text;
    public static Speech instance = null;
    
    public Speech(String text){
        this.text = text;
    }
    public static Speech getInstance(String text){
        if(instance == null)
            instance = new Speech(text);
        
        return instance;
    }
    public void run(){
        VoiceManager vm = VoiceManager.getInstance();
        com.sun.speech.freetts.Voice voice = vm.getVoice("kevin16");
        String string[] = text.split("  ");
        voice.allocate();
        for (int i = 0; i < string.length; i++) {
               voice.speak(text);
        voice.deallocate();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Speech.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
}
}
