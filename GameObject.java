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
public abstract class GameObject {
    protected int x,y; // x and y coordinates to be drawn
    protected ID id; // ID tag of what the object is
    protected int velX,velY; // for movement, for objects that move
    protected int currentFrame; // for objects with spritesheets
    protected ImageHandler imageHandler;
    protected Handler handler;
    public BufferedImage image;
    Boolean Top;
    int weight;
    public GameObject(int x, int y, int weight, ID id,ImageHandler imagehandler, Handler handler) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.id = id;
        this.imageHandler = imagehandler;
        this.handler = handler;
    }
    protected abstract void loadImage();
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle hitBox();
    
    // *******************
    // Setters and getters
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public void setvelX(int x) {
        this.velX = x;
    }
    public void setvelY(int y) {
        this.velY = y;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public ID getID() {
        return this.id;
    }
    public int getvelX() {
        return this.velX;
    }
    public int getvelY() {
        return this.velY;
    }
    public int getWeight() {
        return weight;
    }


    
    
}
