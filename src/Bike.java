/*
 *  
 *  Assignment: Java3 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  
 *  Implements a Bike, the main player/vehicle of the simulation; can 
 *  change speed color and location
 * 
 */

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class Bike extends Vehicle {
        private static int colorIdx = 0;
        private static boolean isMoving = false; 
        /* variables need for drawing */
        private int xLocation;
        private int yLocation;
        private String imagePath;
        Canvas mainCanvas;

        private String[] colors = {"blue", "red", "green", "orange", 
                                   "pink", "yellow"};

        public Bike(int x, int y, int speed, int speedChange, boolean isMoving, Canvas canvas, String imagePath) {
                super(x, y, speed, speedChange, isMoving, canvas, imagePath);
                this.mainCanvas = canvas;
                this.xLocation = x;
                this.yLocation = y;
                this.imagePath = imagePath;
        }

        public void draw(Graphics2D canvas) {
                /* colors for bike */
                // System.out.println("here: " + getX());

                canvas.drawImage((new ImageIcon(imagePath)).getImage(), xLocation, 
                                  yLocation, null);
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

        // @Override
        // public void actionPerformed(ActionEvent e) {
        //         /* simulate driving; set bike back to beginning when out 
        //            of bounds */
        //         setX((getX() >= 1280 - 73) ? -200: getX() + getSpeed());
        //         mainCanvas.repaint();
        // }
}
