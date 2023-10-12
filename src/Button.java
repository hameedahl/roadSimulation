/*

 *  Assignment: Java1 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Buttons to control simulation by interacting with 
 *  Bike class; to be used in Controls
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Button extends JButton implements ActionListener {
        private int id; 
        private Bike bike;

        public Button(String label, int btnId, Bike mainBike) {
                setText(label);
                addActionListener(this);
                id = btnId;
                bike = mainBike;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (id) {
                        case 1:
                                bike.drive();
                                break;
                        case 2:
                                bike.speedUp();
                                break;
                        case 3:
                                bike.slowDown();
                                break;
                        case 4:
                                bike.changeColor();
                                break;
                        case 5:
                                bike.brake();
                                break;
                }
        }
}