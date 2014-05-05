/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TTS;

/**
 *
 * @author Eric Sullivan
 */
import javax.speech.*;
import com.sun.speech.freetts.VoiceManager;

/**
 *
 * @author pat
 */
public class TextToSpeech {
}

class Voice {

    private String name;
    private com.sun.speech.freetts.Voice systemVoice;

    public Voice(String name) {
        this.name = name;
        this.systemVoice = VoiceManager.getInstance().getVoice(this.name);
        this.systemVoice.allocate();
    }

    public void say(String[] thingsToSay) {
        for (int i = 0; i < thingsToSay.length; i++) {
            this.say(thingsToSay[i]);
        }
    }

    public void say(String thingToSay) {
        this.systemVoice.speak(thingToSay);
    }

    public void dispose() {
        this.systemVoice.deallocate();
    }
}