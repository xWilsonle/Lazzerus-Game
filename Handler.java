/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author Wilson Le
 */
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    LinkedList<Player> players = new LinkedList<Player>();
    LinkedList<Box> box = new LinkedList<Box>();
    Background background;
    AudioHandler audio;
    ImageHandler image;
    boolean gameWin = false;
    boolean gameOver = false;
    HUD hud;
    public Handler(ImageHandler image, AudioHandler audio) {
        this.audio = audio;
        this.image = image;
        background = new Background(Game.gameWidth,Game.gameHeight,image);
    }
    public void tick() {
        if(gameWin == false && gameOver == false) {
            for(int i = 0; i < object.size(); i++) {
                GameObject tempObject = object.get(i);
                tempObject.tick();
            }
            for(int i = 0; i < players.size(); i++) {
                Player tempPlayer = players.get(i);
                tempPlayer.tick();
            } 
        }
    }
    
    public void render(Graphics g) {
        background.render(g);
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
        for(int i = 0; i < players.size(); i++) {
            Player tempPlayer = players.get(i);
            tempPlayer.render(g);
        }
        hud.render(g);
    }
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    public void addPlayer(Player player) {
        this.players.add(player);
    }
    public void removePlayer(Player player) {
        this.players.remove(player);
    }
    public void addHUD(HUD hud) {
        this.hud = hud;
    }
    
}
