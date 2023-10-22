/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  
 *  Implements a Bike, the main player/vehicle of the simulation; can 
 *  change speed color and location
 * 
 */

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Bike extends Vehicle {
        private int colorIdx = 0;
        /* variables need for drawing */
        private int xLocation, yLocation;
        private String imagePath;
        Canvas mainCanvas;
        BufferedImage bikeSprite;
        int spriteX = 0, spriteY = 0;

        private String[] colors = {"blue", "red", "green", "orange", 
                                   "pink", "yellow"};

        public Bike(int x, int y, int speed, int speedChange, 
                    boolean isMoving, Canvas canvas, String imagePath) {
                super(x, y, speed, speedChange, isMoving, canvas, imagePath);
                this.mainCanvas = canvas;
                this.xLocation = x;
                this.yLocation = y;
                this.imagePath = imagePath;
                importImg();
        }
        
        private void importImg() {
                InputStream bikeImg = getClass().getResourceAsStream("imgs/bike.png");
                try {
                       bikeSprite = ImageIO.read(bikeImg);
                } catch (IOException e) {
                        e.printStackTrace();
                } finally {
                        try {
                                bikeImg.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }

        public void draw(Graphics2D canvas) { 
                canvas.drawImage(bikeSprite.getSubimage(spriteX, spriteY, 
                                 100, 73), getX(), getY(), null);
        }

        public String getColor() {
                return ("imgs/bike_" + colors[colorIdx] + ".png");
        }

        public void animate() {
                spriteX = (spriteX + 100) % 400;
        }

        public void changeColor() {
                /* "loop" through colors array */
                spriteY = (spriteY + 73) % 438;

                // colorIdx = (colorIdx + 1) % colors.length;
                // imagePath = getColor();
                mainCanvas.repaint();
        }
}
