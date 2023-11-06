/*

 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Holds simulation widgets to control and customize the simulation 
 *  (change speed, add new vehicles, etc.); to be used by Controls
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SimControls extends JPanel {
        private int buttonId = 0;
        SimButton pause, play, addVehicle;
        Slider speed;
        ScrollList vehicleOptions;
        DropDown posOptions;
        JSpinner vehicleSpeed;
        Model model;

        SimControls(Canvas canvas, Model simulationData) {      
                this.model = simulationData;
                styleControls();
                JLabel title = new JLabel("Simulation Controls");
                pause = new SimButton("Pause", ++buttonId, model, this);
                play = new SimButton("Play", ++buttonId, model, this);
                speed = new Slider(0, 84, 0, model);
                vehicleOptions = new ScrollList(model.newVehicles);
                posOptions = new DropDown(model.lanes);
                vehicleSpeed = new JSpinner(new SpinnerNumberModel(25, 
                                            0, 300, 1));
                addVehicle = new SimButton("Add Vehicle", ++buttonId, 
                                           model, this);

                play.setEnabled(false); /* sim starts of on play */
                add(title);
                add(pause);
                add(play);
                add(speed);
                add(vehicleOptions);
                add(posOptions);
                add(vehicleSpeed);
                add(addVehicle);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C9));
                setPreferredSize(new Dimension(640, 80));
                setLayout(new FlowLayout());
        }
}