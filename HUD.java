/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Wilson Le
 */
public class HUD {
    private Window HUDwindow;
    
    public HUD(Window window) {
        HUDwindow = window;
    }
    
    public static int Player1Health = 100;
    public static int Player2Health = 100;
    private int numObjective = 2;
    public void tick() {    
    }
    
    public Window getWindow() {
        return HUDwindow;
    }
    
    public void render(Graphics g) {
        String message = "There are ";
        message = message + numObjective + " Buttons Left";
        g.setFont(new Font("TimesRoman",Font.PLAIN,20));
        g.drawString(message,40,40);
    }
    public int getObjective() {
        return numObjective;
    }
    public void winMessage(Graphics g) {
        String win = "Win";
        g.setFont(new Font("TimesRoman",Font.PLAIN,40));
        g.drawString(win,200,200);
    }
    public void Objective() {
        numObjective--;
    }
}
