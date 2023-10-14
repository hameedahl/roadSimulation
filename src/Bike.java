/*
 *  
 *  Assignment: Java4 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  
 *  Implements a Bike, the main player/vehicle of the simulation; can 
 *  change speed color and location
 * 
 */

import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class Bike extends Vehicle {
        private int colorIdx = 0;
        /* variables need for drawing */
        private int xLocation;
        private int yLocation;
        private String imagePath;
        Canvas mainCanvas;

        private String[] colors = {"blue", "red", "green", "orange", 
                                   "pink", "yellow"};

        public Bike(int x, int y, int speed, int speedChange, 
                    boolean isMoving, Canvas canvas, String imagePath) {
                super(x, y, speed, speedChange, isMoving, canvas, imagePath);
                this.mainCanvas = canvas;
                this.xLocation = x;
                this.yLocation = y;
                this.imagePath = imagePath;
        }

        public void draw(Graphics2D canvas) {
                canvas.drawImage((new ImageIcon(imagePath)).getImage(), getX(), 
                                  getY(), null);
        }

        public String getColor() {
                return ("imgs/bike_" + colors[colorIdx] + ".png");
        }

        public void changeColor() {
                /* "loop" through colors array */
                colorIdx = (colorIdx + 1) % colors.length;
                imagePath = getColor();
                mainCanvas.repaint();
        }
}
