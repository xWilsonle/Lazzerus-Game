/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Wilson Le
 */
public class ImageHandler {
    protected static Map<String,BufferedImage> images = new HashMap<String,BufferedImage>();
    
    public ImageHandler() {
        images.put("background", loadImage("Resources/Background.png"));
        images.put("wall",loadImage("Resources/Wall.png"));
        images.put("box1",loadImage("Resources/CardBox.png"));
        images.put("box2",loadImage("Resources/WoodBox.png"));
        images.put("box3",loadImage("Resources/StoneBox.png"));
        images.put("Button",loadImage("Resources/Button.png"));
    }

    public BufferedImage getImage (String name) {
        return images.get(name);
    }
    public ArrayList<BufferedImage> getSpriteSheet(String filePath, int num) {
        ArrayList<BufferedImage> SpriteSheet = new ArrayList<BufferedImage>();
            BufferedImage Sprites = loadImage(filePath);
            int imageWidth = (Sprites.getWidth() / num);
            int imageHeight = Sprites.getHeight();
            for(int i = 0; i < num; i++) {
                SpriteSheet.add(Sprites.getSubimage(i * imageWidth,0,imageWidth,imageHeight));
            }
            return SpriteSheet;
    }
    
    protected BufferedImage loadImage(String filePath) {
        try {
            BufferedImage image;
            image = ImageIO.read(this.getClass().getResource
                                (filePath));
            return image;
        } catch(Exception e) {
            printStackTrace();
        }
        System.out.println("Cant find " + filePath);
        return null;
    }
    
}
