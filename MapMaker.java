/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wilson Le
 */

public class MapMaker {
    private String nextLine;
    private Handler handler;
    private ImageHandler image;
    private Timer timer = new Timer();
    private int secondSpawnDelay = 3;
    Random ran = new Random();
    
    public MapMaker(Handler handler,ImageHandler image) {
        this.handler = handler;
        this.image = image;
        hardCodedMap();
    }
    
    /**
     * Hard coded generated map for simplicity and demo sake
     */
    public void hardCodedMap() {
        for(int i = 0; i < 6; i++) {
            handler.addObject(new Block(0,240 + (i * 40),9999,ID.Block,image,handler));
            handler.addObject(new Block(40,240 + (i * 40),9999,ID.Block,image,handler));
            handler.addObject(new Block(600,240 + (i * 40),9999,ID.Block,image,handler));
            handler.addObject(new Block(560,240 + (i * 40),9999,ID.Block,image,handler));
        }
        for(int i = 0; i < 16; i++) {
            handler.addObject(new Block(i * 40,440,9999,ID.Block,image,handler));
        }
        handler.addPlayer(new Player(300,300,ID.Player,handler,image));
        handler.addObject(new Button(0,200,9999,ID.Button,image,handler));
        handler.addObject(new Button(600,200,9999,ID.Button,image,handler));
        spawnBoxes();
    }
    public void spawnBoxes() {
        timer.schedule(new TimerTask() {
            public void run() {
                int randomWeight = ran.nextInt(3) + 1;
                for(int i = 0; i < handler.players.size(); i++) {
                    Player tempPlayer = handler.players.get(i);
                    int spawnX = (tempPlayer.getX() / 40);
                    if(spawnX != 0 && spawnX != 1 && spawnX != 15 && spawnX != 14) {
                        handler.addObject(new Box(spawnX * 40,0,randomWeight,ID.Box,image,handler));
                    }
                }
            }
        },0,secondSpawnDelay*1000);
    }
}
