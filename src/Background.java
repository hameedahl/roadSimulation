/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Scrolling background; to be used by Model
 * 
 */

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Background extends Vehicle {
        int xLocation;
        int yLocation;
        int speed;
        Timer timer;
        Canvas canvas;
        String backgroundPath;
        String[] temp = {"bike_blue", "bike_blue1", "bike_blue2", "bike_blue3"};
        int tempIdx = 0;
        int row = 0;

        public Background(int x, int y, int speed, Canvas canvas, 
                          String backgroundPath) {
                super(x, y, speed, speed, 
                      false, canvas, backgroundPath);
        }

        public Image getBgImage() {
                return new ImageIcon(getImagePath()).getImage();
        }

        public String moveBike() {
                return (temp[++tempIdx % temp.length]) + ".png";
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                setX(getX() - getSpeed());
                /* place second background at the end to loop */
                if (getX() <= -2132) {
                        setX(2110);
                }
        }
}
