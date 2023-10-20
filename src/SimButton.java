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

public class SimButton extends JButton implements ActionListener {
        private int id; 
        private Bike bike;
        Model model;

        public SimButton(String label, int btnId, Model model) {
                setText(label);
                addActionListener(this);
                id = btnId;
                this.model = model;
                bike = model.mainBike;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (id) {
                        case 1: /* pause */
                                stopSimVehicles();
                                break;
                        case 2: /* play */
                                startSimVehicles();
                                break;
                        case 3: /* add */
                                System.out.println("adding veh");
                                break;
                }
        }

        public void stopSimVehicles() {
                for (Vehicle vehicle : model.vehicles) {
                        if (vehicle != bike) {
                                vehicle.brake();
                        }
                }
        }

        public void startSimVehicles() {
                for (Vehicle vehicle : model.vehicles) {
                        if (vehicle != bike) {
                                vehicle.drive();
                        }
                }
        }
}