/*

 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Buttons to control the player's vehicle by interacting with 
 *  Background class (make Bike "move"); to be used in PlayerControls
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
        Model model;


        public PlayerButton(String label, int btnId, PlayerControls controls, 
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
                Vehicle v = model.selectedVehicle;
                switch (id) {
                        case 1: /* drive */
                                controls.driveBtn.setEnabled(false);
                                controls.breakBtn.setEnabled(true);
                                controls.speed.setEnabled(true);
                                background1.drive();
                                background2.drive();
                                break;
                        case 2: /* change color */
                                bike.changeColor();
                                break;
                        case 3: /* brake */
                                controls.speed.setEnabled(false);
                                controls.driveBtn.setEnabled(true);
                                controls.breakBtn.setEnabled(false);
                                background1.brake();
                                background2.brake();
                                break;
                        case 4: /* change lanes */
                                /* no vehicle selected */
                                if (v.imagePath == "") { return; } 
                                model.changeLanes(v, true);
                                break;
                        case 5: /* speed up */
                                /* no vehicle selected */
                                if (v.imagePath == "") { return; } 
                                v.setSpeed(v.getSpeed() + 5);
                                model.statePanel.updateSelected(v.name, 
                                                                model.lanes[v.lane],
                                                                v.getSpeed());
                                break;
                        case 6: /* slow down */
                                /* no vehicle selected */
                                if (v.imagePath == "") { return; } 
                                v.setSpeed(v.getSpeed() - 5);
                                model.statePanel.updateSelected(v.name, 
                                                                model.lanes[v.lane],
                                                                v.getSpeed());
                                break;
                        case 7: /* remove */
                                /* no vehicle selected */
                                if (v.imagePath == "") { return; } 
                                model.removeVehicle(model.selectedVehicle, false);
                                break;
                        case 8: /* zoom in */
                                model.zoom *= 1.1;
                                model.streetZoom += 22;
                                model.vehicleZoom *= 1.2;

                                controls.zoomOutBtn.setEnabled(true);
                                /* set max zoom */
                                if (model.zoom >= 1.3) {
                                        this.setEnabled(false);
                                }
                                model.zoom();
                                break;
                        case 9: /* zoom out */
                                model.zoom /= 1.1;
                                model.streetZoom -= 22;
                                model.vehicleZoom /= 1.2;

                                controls.zoomInBtn.setEnabled(true);
                                /* set max zoom */
                                if (model.zoom <= 1.0) {
                                        this.setEnabled(false);
                                }
                                model.zoom();
                                break;
                }
        }
}