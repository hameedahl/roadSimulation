/*
 *  
 *  Assignment: Java4 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Canvas to hold all drawing components of simulation
 * 
 */

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel {
        public Graphics2D canvasG;
        Model model;

        public void setModel(Model model) {
                this.model = model;
        }

        /* draw callback */
        @Override
        public void paintComponent(Graphics g2D) { 
                canvasG = (Graphics2D) g2D;
                super.paintComponent(canvasG); 
                model.draw(canvasG);
        }
}