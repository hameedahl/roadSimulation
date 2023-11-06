/*
 *  
 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Cars (subclass of Vehicle) to be used in Model
 * 
 */

import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Car extends Vehicle {
        private boolean isMoving = false; 
        private int xLocation;
        private int yLocation;
        private String imagePath;
        Canvas mainCanvas;
        Rectangle hitBox; 

        public Car(String name, int x, int y, int speed, int speedChange, 
                   boolean isMoving, Canvas canvas, String imagePath) {
                super(name, x, y, speed, speedChange, 
                      isMoving, canvas, imagePath);
                this.mainCanvas = canvas;
                this.xLocation = x;
                this.yLocation = y;
                this.imagePath = imagePath;
                this.hitBox = new Rectangle (x, y, 100, 100); 
                setImage((new ImageIcon(imagePath)).getImage());
                this.width = image.getWidth(null);
                this.height = image.getHeight(null);
        }
}
