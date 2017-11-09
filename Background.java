/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;
 
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Wilson Le
 */
public class Background {
    private int x;
    private int y;
    private ID id;
    ImageHandler image;
    public Background(int x, int y, ImageHandler image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }
    public void render(Graphics g) {
        BufferedImage background;
        background = image.getImage("background");
        for(int i = -2; i < x; i += background.getWidth()) {
            for(int j = -2; j < y; j+= background.getHeight()) {
                g.drawImage(background,i,j,null);
            }
        }
    }
/*
    public BufferedImage getImage(String filepath) {
        BufferedImage image;
        try {
            image = ImageIO.read(this.getClass().getResource(filepath));
            return image;
        } catch (IOException ex) {
            System.out.println("YOU SUCK");
        }
        return null;
    }
*/
}