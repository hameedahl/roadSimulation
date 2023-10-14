/*
 *  
 *  Assignment: Java4 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Abstract base class for all vehicles in simulation; 
 *  to be used by Model, Car, Bike, and Background 
 * 
 */

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

abstract public class Vehicle implements ActionListener {
        private int xLocation;
        private int yLocation;
        private int initSpeed = 100;
        private int speed;
        private int speedChange;
        public  boolean isMoving; 
        private Timer timer;
        private Canvas mainCanvas;
        public  String imagePath;

        public Vehicle (int x, int y, int speed, int speedChange, 
                        boolean isMoving, Canvas canvas, String imagePath) {
                this.xLocation = x;
                this.yLocation = y;
                this.speed = speed;
                this.speedChange = speedChange;
                this.isMoving = isMoving;
                this.mainCanvas = canvas;
                this.timer = new Timer(initSpeed, this);
                this.imagePath = imagePath;
                if (isMoving) { drive(); }
        }

        public void draw(Graphics2D canvas) {
                canvas.drawImage((new ImageIcon(imagePath)).getImage(), getX(), 
                                  getY(), null);
        }

        public void setImagePath(String path) {
                imagePath = path;
        }

        public String getImagePath() {
                return imagePath;
        }

        public void setX(int newX) {
                xLocation = newX;
        }

        public void setY(int newY) {
                yLocation = newY;
        }

        public void setSpeed(int newSpeed) {
                speed = newSpeed;
        }

        public int getX() {
                return xLocation;
        }

        public int getY() {
                return yLocation;
        }

        public int getSpeed() {
                return speed;
        }

        public void drive() {
                isMoving = true;
                if (!timer.isRunning()) {
                        timer.start();
                }
                mainCanvas.repaint();
        }

        public void brake() {
                isMoving = false;
                timer.stop();
                // timer.setDelay(initSpeed); /* reset speed */
        }

        public void speedUp() {
                /* keep speed 0 or positive */
                timer.setDelay(timer.getDelay() -  ((timer.getDelay() - speedChange) < 0 ? 0 : speedChange));
                //speed += speedChange; /* TODO: set max speed */
        }

        public void slowDown() {
                /* stop car when speed is low */
                if (timer.getDelay() + speedChange >= 100) { 
                        brake();
                } else {
                        timer.setDelay(timer.getDelay() + speedChange);
                }
               // speed -= ((speed - speedChange) < 0 ? 0 : speedChange);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                /* set vehicle back to beginning when out of bounds */
                if (getX() >= 1280) { 
                        setX(-3000);
                }

                setX(getX() + getSpeed());
                mainCanvas.repaint();
        }
}
