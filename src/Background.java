/*
 *  
 *  Assignment: Jav43 Fall 2023
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


        public Background(int x, int y, int speed, Canvas canvas, 
                          String backgroundPath) {
                super(x, y, speed, speed, 
                      false, canvas, backgroundPath);
        }

        public Image getBgImage() {
                return new ImageIcon(getImagePath()).getImage();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                setX(getX() - getSpeed());

                /* place background at the end to loop */
                if (getX() <= -2132) {
                        setX(2110);
                }
        }
}
