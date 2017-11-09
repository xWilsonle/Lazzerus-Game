/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Wilson Le
 */
public class KeyInput extends KeyAdapter{
    private Handler handler;
    private final int TankSpeed = 5;
    private final int BulletSpeed = 10;
    
    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    
    
    /**
     * Manages keyboard inputs for the players
     * @param e 
     */
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for(int i = 0; i < handler.players.size(); i++) {
            Player tempPlayer = handler.players.get(i);
            if(tempPlayer.getID() == ID.Player) { // Keyboard Input for Player1
                if(key == KeyEvent.VK_W) tempPlayer.jump();
                if(key == KeyEvent.VK_A) tempPlayer.moveLeft();
                if(key == KeyEvent.VK_D) tempPlayer.moveRight();
                
                
                
            }
        }
        
    }
    /**
     * Manages the situations for when keys are released
     * Stops the tanks when the buttons are released
     * @param e 
     */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for(int i = 0; i < handler.players.size(); i++) {
            Player tempPlayer = handler.players.get(i);
            if(tempPlayer.getID() == ID.Player) {
                // Keyboard Input for Player1
                if(key == KeyEvent.VK_D){
                    tempPlayer.setVelX(0);
                }
                if(key == KeyEvent.VK_A) {
                    tempPlayer.setVelX(0);
                }
            }
        }
    }
    
}
