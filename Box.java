/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Wilson Le
 */
public class Box extends GameObject{

    public Box(int x, int y,int weight, ID id, ImageHandler imagehandler, Handler handler) {
        super(x, y, weight,  id, imagehandler, handler);
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.id = id;
        this.imageHandler = imagehandler;
        this.handler = handler;
        loadImage();
    }

    protected void loadImage() {
        String box = "box";
        box = box + weight;
        image = imageHandler.getImage(box);
    }


    public void tick() {
        gravity();
        x += velX;
        y += velY;
        Collision();
    }
    public void gravity() {
        velY = 3;
    }
    public void Collision() {
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject != this) {
                if(tempObject.hitBox().intersects(this.hitBox())) {
                    if(tempObject.getID() == ID.Box || tempObject.getID() == ID.Block) {
                        if(tempObject.getWeight() < this.getWeight()) {
                            handler.object.remove(tempObject);
                            handler.audio.playCrush();
                        }
                        else {
                            this.y = tempObject.y - 41;
                        }
                    }
                }
            }
        }
    }

    public void render(Graphics g) {
        g.drawImage(image,x,y,null);
    }
    public Rectangle hitBox() {
        return new Rectangle(x,y,image.getWidth(),image.getHeight());
    }
    
}
