/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Wilson Le
 */
public class Block extends GameObject{

    public Block(int x, int y,int weight, ID id, ImageHandler imagehandler, Handler handler) {
        super(x, y,weight, id, imagehandler, handler);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.id = id;
        this.imageHandler = imagehandler;
        this.handler = handler;
        loadImage();
    }

    protected void loadImage() {
       image = imageHandler.getImage("wall");
    }


    public void tick() {
        
    }

    public void gravity() {
        
    }
    
    public void render(Graphics g) {
        g.drawImage(image,x,y,null);
    }

    public Rectangle hitBox() {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
}
