/*

 *  Assignment: Java6 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Buttons to control the simulation vehicle by interacting with 
 *  the Model class; to be used in SimControls
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SimButton extends JButton implements ActionListener {
        private int id; 
        SimControls controls;
        Model model;

        public SimButton(String label, int btnId, Model model, 
                         SimControls controls) {
                setText(label);
                addActionListener(this);
                id = btnId;
                this.model = model;
                this.controls = controls;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                switch (id) {
                        case 1: /* pause */
                                controls.play.setEnabled(true);
                                controls.pause.setEnabled(false);
                                controls.addVehicle.setEnabled(false);
                                controls.speed.setEnabled(false);
                                model.stopSimVehicles();
                                break;
                        case 2: /* play */
                                controls.speed.setEnabled(true);
                                controls.play.setEnabled(false);
                                controls.pause.setEnabled(true);
                                controls.addVehicle.setEnabled(true);
                                model.startSimVehicles();
                                break;
                        case 3: /* add new vehicle */
                                int vehIndex = controls.vehicleOptions.scrollList.getSelectedIndex();
                                String name = controls.vehicleOptions.scrollList.getSelectedValue();
                                int posIndex = controls.posOptions.getSelectedIndex();
                                /* only add if option is selected */
                                model.addSimVehicle(name, vehIndex, posIndex, 
                                                    Integer.parseInt(controls.vehicleSpeed.getValue().toString()));
                                break;
                }
        }
}