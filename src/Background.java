/*
 *  
 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Scrolling background; to be used by Model
 * 
 */

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Background extends Vehicle {
        int xLocation;
        int yLocation;
        int speed;
        Timer timer;
        Canvas canvas;
        String backgroundPath;
        String[] temp = {"bike_blue", "bike_blue1", 
                         "bike_blue2", "bike_blue3"};
        int tempIdx = 0;
        int row = 0;
        Image bgImage;

        public Background(int x, int y, int speed, Canvas canvas, 
                          String backgroundPath) {
                super("", x, y, speed, speed, 
                      false, canvas, backgroundPath);
                setY(0);
                try {
                        bgImage = ImageIO.read(new File(getImagePath()));
                } catch (IOException e) {
                        e.printStackTrace();
                }
                setImage(bgImage);
                width = bgImage.getWidth(null);
                height = bgImage.getHeight(null);
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
