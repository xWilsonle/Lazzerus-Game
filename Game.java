/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secondgame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 *
 * @author Wilson Le
 */
public class Game extends Canvas implements Runnable{
    public static final int screenWidth = 640;
    public static final int screenHeight = 480;
    public static final int gameWidth = 1500;
    public static final int gameHeight = 1500;
    
    
    private Thread thread; // The Game Thread
    private boolean running = false;
    private static AudioHandler audio;
    private Handler handler;
    private HUD hud;
    private MapMaker map;
    public ImageHandler imagehandler;
    //private Background background;
    
    public Game() {
        imagehandler = new ImageHandler();
        audio = new AudioHandler();
        audio.backgroundMusic();
        handler = new Handler(imagehandler,audio);
        this.addKeyListener(new KeyInput(handler));
        
        Window window = new Window(screenWidth, screenHeight, "SecondGame", this);
        
        hud = new HUD(window);
        handler.addHUD(hud);
        map = new MapMaker(handler,imagehandler);
        
    }
    
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
        
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS " + frames);
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick() {
        handler.tick();
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.CYAN);
        g.fillRect(0,0,screenWidth,screenHeight);
        
        handler.render(g);
        
        g.dispose();
        bs.show();
        
    }
    
    public static void main(String[] args) {
        new Game();
    }
    
}