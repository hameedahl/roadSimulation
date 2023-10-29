/*
 *  
 *  Assignment: Java4 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Abstract base class for all vehicles in simulation; 
 *  to be used by Model, Car, Bike, and Background 
 * 
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
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
        public  String imagePath, name;
        private Rectangle hitBox;
        public  boolean isSelected = false;
        public  int lane = -1;

        public Vehicle (String name, int x, int y, int speed, int speedChange, 
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
                this.hitBox = new Rectangle (x, y, 100, 100); 
                this.name = name;
        }

        public void draw(Graphics2D canvas) {
                Image img = new ImageIcon(imagePath).getImage();
                canvas.drawImage(img, getX(), 
                                  getY(), null);
                canvas.setPaint(new Color(0,0,0,0));
                if (isSelected) {
                        canvas.setStroke(new BasicStroke(2));
                        /* add red boarder on click */
                        canvas.setPaint(Color.red); 
                } 
                hitBox.x = getX();
                hitBox.y = getY();
                hitBox.width = img.getWidth(null);
                hitBox.height = img.getHeight(null);
                canvas.draw(hitBox);
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
                if (newSpeed <= 0) {
                        brake();
                        speed = 0;
                } else {
                        speed = newSpeed;
                }
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
        }

        public void changeSpeed(int speedChange) {
                /* update speed based on value from slider */
                int newSpeed = initSpeed + speedChange;
                timer.setDelay(newSpeed);
        }

        public void tick() {
                /* set vehicle back to beginning when out of view */
                if (getX() >= 1280) { 
                        setX(-3000);
                }

                setX(getX() + getSpeed());
        }

        public boolean wasClicked(Point p) {
                return hitBox.contains(p);
        }

        public boolean checkForCollision(Vehicle otherVehicle, Model model) {
                if (hitBox.intersects(otherVehicle.hitBox)) {
                        /* both cars takes damage, so slow down */
                        setSpeed(getSpeed() - 1);
                        otherVehicle.setSpeed(otherVehicle.getSpeed() - 1);

                        /* remove from sim if too much damage */
                        if (!isMoving) { model.removeVehicle(this, true); }
                        if (!otherVehicle.isMoving) { model.removeVehicle(otherVehicle, true); }

                        return true;
                }
                return false ;
        }  
        
        @Override
        public void actionPerformed(ActionEvent e) {
                tick();
                mainCanvas.repaint();
        }
}
