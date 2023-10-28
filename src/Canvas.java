/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Canvas to hold all drawing components of simulation
 * 
 */

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Canvas extends JPanel implements MouseListener {
        public Graphics2D canvasG;
        Model model;

        Canvas () {
                addMouseListener(this);
        }

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

        @Override
        public void mouseClicked(MouseEvent e) {
                model.checkMouse(e.getPoint());
        }

        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
}