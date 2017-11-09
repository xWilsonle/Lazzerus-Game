/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Wilson Le
 */
public class DeadPlayer extends GameObject{
    int frameDelay = 0;
    ArrayList<BufferedImage> player;
    public DeadPlayer(int x, int y,int weight, ID id, ImageHandler imagehandler, Handler handler) {
        super(x, y,weight,id, imagehandler, handler);
        this.x = x;
        this.y = y;
        this.id = id;
        this.imageHandler = imagehandler;
        this.handler = handler;
        loadImage();
    }

    protected void loadImage() {
        player = imageHandler.getSpriteSheet("Resources/Lazarus_squished_strip11.png",11);
    }

    public void tick() {
        addFrame();
    }

    public void render(Graphics g) {
        g.drawImage(player.get(currentFrame), x, y, null);
    }

    
    public Rectangle hitBox() {
        return new Rectangle(0,0,1,1);
    }
    
    public void addFrame() {
        if(frameDelay < 3) {
            frameDelay++;
        }
        else {
            frameDelay = 0;
            if(currentFrame == 10) {
                handler.removeObject(this);
            }
            else {
                currentFrame++;
            }
        }
    }
}
