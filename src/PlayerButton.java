/*

 *  Assignment: Java4 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Buttons to control simulation by interacting with 
 *  Background class (make Bike "move"); to be used in Controls
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PlayerButton extends JButton implements ActionListener {
        private int id; 
        private Bike bike;
        Background background1, background2;

        public PlayerButton(String label, int btnId, Bike mainBike) {
                setText(label);
                addActionListener(this);
                id = btnId;
                bike = mainBike;
        }

        public PlayerButton(String label, int btnId, Background background1, 
                      Background background2) {
                setText(label);
                addActionListener(this);
                id = btnId;
                this.background1 = background1;
                this.background2 = background2;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                // System.out.println(id);
                switch (id) {
                        case 1:
                                background1.drive();
                                background2.drive();
                                setEnabled(false);
                                break;
                        case 2:
                                // background1.speedUp();
                                // background2.speedUp();
                                break;
                        case 3:
                                // background1.slowDown();
                                // background2.slowDown();

                                break;
                        case 4:
                                bike.changeColor();
                                break;
                        case 5:
                                background1.brake();
                                background2.brake();
                                break;
                }
        }
}