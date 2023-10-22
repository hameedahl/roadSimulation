/*

 *  Assignment: Java5 Fall 2023
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
        PlayerControls controls;

        public PlayerButton(String label, int btnId, Bike mainBike, 
                            Background background1, Background background2, 
                            PlayerControls controls) {
                setText(label);
                addActionListener(this);
                id = btnId;
                bike = mainBike;
                this.background1 = background1;
                this.background2 = background2;
                this.controls = controls;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (id) {
                        case 1:
                                controls.driveBtn.setEnabled(false);
                                controls.breakBtn.setEnabled(true);
                                controls.speed.setEnabled(true);
                                background1.drive();
                                background2.drive();
                                break;
                        case 2:
                                bike.changeColor();
                                break;
                        case 3:
                                controls.speed.setEnabled(false);
                                controls.driveBtn.setEnabled(true);
                                controls.breakBtn.setEnabled(false);
                                background1.brake();
                                background2.brake();
                                break;
                }
        }
}