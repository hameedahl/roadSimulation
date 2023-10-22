/*

 *  Assignment: Java5 Fall 2023
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

public class SimControls extends JPanel {
        private int buttonId = 0;
        SimButton pause, play, addVehicle;
        Slider speed;
        DropDown vehicleOptions, posOptions;
        Spinner vehicleSpeed;
        String[] newVehicles = {"Select Vehicle", "Sports Car", 
                                "Red Vintage Coupe", "Black Vintage Coupe",
                                "Sliver Hatchback", "Sport Sedan",
                                "Red Motorcycle", "Black Motorcycle"},
                 positions   = {"Select Lane", "Left Lane", "Middle Lane",
                                "Right Lane"};
        Model model;

        SimControls(Canvas canvas, Model simulationData) {      
                this.model = simulationData;
                styleControls();
                JLabel title = new JLabel("Simulation Controls");
                pause = new SimButton("Pause", ++buttonId, 
                                      model, this);
                play = new SimButton("Play", ++buttonId, 
                                     model, this);
                speed = new Slider(0, 100, 0, 
                                   model);
                vehicleOptions = new DropDown(newVehicles);
                posOptions = new DropDown(positions);
                vehicleSpeed = new Spinner(0, 30);
                vehicleSpeed.setValue(25);
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
