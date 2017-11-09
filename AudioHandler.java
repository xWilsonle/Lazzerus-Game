/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.applet.*;
import java.util.*;
import sun.audio.*;

/**
 *
 * @author Wilson Le
 */


public class AudioHandler {

    private AudioClip BGMclip;
    private AudioClip Button;
    private AudioClip Crush;
    private AudioClip Squished;
    private AudioClip Jump;
    Timer timer = new Timer();
    /**
     * Plays the background Music in a loop
     */
    public void backgroundMusic() {
        // First time running
        try {
            BGMclip = Applet.newAudioClip(AudioHandler.class.getResource("Resources/Music.mid"));           
            BGMclip.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Loops over a 2 minute timer
        timer.schedule(new TimerTask() {
            public void run() {
                BGMclip.play();
            }
        },0,304*1000);
    }
    
    /**
     * Plays the Crushing sound
     */
    public void playCrush() {
        if(Crush == null) {
            try {
                Crush = Applet.newAudioClip(AudioHandler.class.getResource("Resources/Crush.wav"));           
                Crush.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Crush.play();
        }

    }
    /**
     * plays the jumping sound
     */
    public void playJump() {
        if(Jump == null) {
            try {
                Jump = Applet.newAudioClip(AudioHandler.class.getResource("Resources/Move.wav"));           
                Jump.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Jump.play();
        }

    }
    /**
     * Plays the Button Getting Sound
     */
    public void playButton() {
        if(Button == null) {
            try {
                Button = Applet.newAudioClip(AudioHandler.class.getResource("Resources/Button.wav"));           
                Button.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Button.play();
        }

    }
    /**
     * Plays the death sound when the player gets squished
     */
    public void playSquished() {
        if(Squished == null) {
            try {
                Squished = Applet.newAudioClip(AudioHandler.class.getResource("Resources/Squished.wav"));           
                Squished.play();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Squished.play();
        }

    }    
}