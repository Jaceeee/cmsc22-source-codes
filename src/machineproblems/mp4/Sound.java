package machineproblems.mp4;

import java.applet.Applet;
import java.applet.AudioClip;

/**
 * Created by Juan Carlos on 10/23/2016.
 */
public class Sound {
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav")); //each AudioClip object represents the audio needed for the background, collision, and game over sounds.
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
}
