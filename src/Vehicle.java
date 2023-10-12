import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

abstract public class Vehicle implements ActionListener {
        private int xLocation;
        private int yLocation;
        private int speed;
        private int speedChange;
        private boolean isMoving; 
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
                this.timer = new Timer(100, this);
                this.imagePath = imagePath;
                // if (isMoving) { drive(); }

        }

        public void draw(Graphics2D canvas) {
                canvas.drawImage((new ImageIcon(imagePath)).getImage(), getX(), 
                                  getY(), null);
        }

        public void setImagePath(String path) {
                imagePath = path;
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
        }

        public void speedUp() {
                speed += speedChange; /* TODO: set max speed */
        }

        public void slowDown() {
                /* keep speed 0 or positive */
                speed -= ((speed - speedChange) < 0 ? 0 : speedChange);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                /* simulate driving; set bike back to beginning when out 
                   of bounds */
                setX((getX() >= 1280 - 73) ? -200: getX() + getSpeed());
                mainCanvas.repaint();
        }
}
