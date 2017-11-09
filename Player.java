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
public class Player{
    ArrayList<BufferedImage> player;
    ImageHandler imageHandler;
    int x,y,velX,velY;
    int accY;
    int playerHeight = 40;
    int playerWidth = 40;
    ID id;
    int frameDelay;
    Handler handler;
    int currentFrame;
    boolean grounded = false;
    
    public Player(int x, int y, ID id, Handler handler ,ImageHandler imagehandler) {
        this.x = x;
        this.y = y;
        velX = 0;
        velY = -30;
        this.id = id;
        this.handler = handler;
        this.imageHandler = imagehandler;
        loadImage();
    }
    
    protected void loadImage() {
        player = imageHandler.getSpriteSheet("Resources/Lazarus_afraid_strip10.png",10);
    }


    public void tick() {
        gravity();
        this.velY += accY;
        this.x += velX;
        this.y += velY;
        Collision();
        addFrame();
    }
    public void render(Graphics g) {
        g.drawImage(player.get(currentFrame),x,y, null);
    }
    
    public void moveRight() {
        this.velX = 2;
    }
    public void moveLeft() {
        this.velX = -2;
    }
    public void jump() {
        hasFloor();
        if(grounded == true) {
            handler.audio.playJump();
            this.accY = -11;
            grounded = false;
        }
    }
    public Rectangle hitBox() {
        return new Rectangle(x+ 7,y,playerWidth - 14,playerHeight);
    }

    public void gravity() {
        if(grounded == true) {
            velY = 3;
            accY = 0;
        }
        else {
            if(accY < 3) {
                accY += 3;
            }
            else if (accY > 3 || velY > 3) {
                velY = 3;
            }
        }
    }
    public void hasFloor() {
        grounded = false;
        Rectangle feet = new Rectangle(x,y + 3,playerWidth,playerHeight);
        for(int i = 0; i < handler.object.size();i++) {
            GameObject tempObject = handler.object.get(i);
            if(feet.intersects(tempObject.hitBox())) {
                grounded = true;
                break;
                }
            }
    }
    
    public void addFrame() {
        if(frameDelay < 3) {
            frameDelay++;
        }
        else {
            frameDelay = 0;
            if(currentFrame == 9) {
                currentFrame = 0;
            }
            else {
                currentFrame++;
            }
        }
    }
    
    public void Collision() {
        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.hitBox().intersects(this.hitBox())) {
                if(tempObject.id == ID.Button) {
                    handler.removeObject(tempObject);
                    handler.audio.playButton();
                    handler.hud.Objective();
                }
                else {
                    new Rectangle(x,y,playerWidth,playerHeight);
                    Rectangle Left = new Rectangle(tempObject.x,tempObject.y + 3,1,tempObject.image.getHeight() - 3);
                    Rectangle Right = new Rectangle(tempObject.x + tempObject.image.getWidth() - 1, tempObject.y + 3, 1, tempObject.image.getHeight() - 3);
                    Rectangle Up = new Rectangle(tempObject.x + 2, tempObject.y,tempObject.image.getWidth() - 4,1);
                    Rectangle Down = new Rectangle (tempObject.x, tempObject.y + tempObject.image.getHeight() - 1,tempObject.image.getWidth(),1);
                    if(this.hitBox().intersects(Left) || this.hitBox().intersects(Right)) {
                        this.x = x - velX;
                    }
                    if(this.hitBox().intersects(Up)) {
                        grounded = true;
                        accY = 0;
                        this.y = tempObject.y - 41;
                    }
                    if(this.hitBox().intersects(Down)) {
                        handler.addObject(new DeadPlayer(this.x,this.y,1,ID.DeadPlayer,imageHandler,handler));
                        handler.audio.playSquished();
                        handler.players.remove(this);
                    }
                }
            }
        }
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getVelX() {
        return this.velX;
    }
    public ID getID() {
        return this.id;
    }
    public int getVelY() {
        return this.velY;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setVelX(int x) {
        this.velX = x;
    }
    public void setVelY(int y) {
        this.velY = y;
    }
    public void setID(ID id) {
        this.id = id;
    }
}
