/*

 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Buttons to control the player's vehicle by interacting with 
 *  Background class (make Bike "move"); to be used in PlayerControls
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StateButton extends JButton implements ActionListener {
        private int id; 
        private Bike bike;
        Background background1, background2;
        PlayerControls controls;
        Model model;


        public StateButton(String label, int btnId, PlayerControls controls, 
                            Model model) {
                setText(label);
                addActionListener(this);
                id = btnId;
                bike = model.mainBike;
                this.background1 = model.background1;
                this.background2 = model.background2;
                this.controls = controls;
                this.model = model;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (id) {
                        case 1:
                                
                }
        }
}