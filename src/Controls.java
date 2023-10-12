/*
 *  
 *  Assignment: Java3 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  All controls needed for simulation; i.e driving, 
 *  changing speed and color 
 *  
 */

import java.awt.Color;

import javax.swing.JPanel;

public class Controls extends JPanel {
        private int buttonId = 0;

        public Controls(Canvas canvas, Model simulationData) {
                styleControls();
                Button driveBtn = new Button("Drive", ++buttonId, simulationData.mainBike);
                Button fasterBtn = new Button("Speed Up", ++buttonId, simulationData.mainBike);
                Button slowerBtn = new Button("Slow Down", ++buttonId, simulationData.mainBike);
                Button colorBtn = new Button("Change Bike Color", ++buttonId, simulationData.mainBike);
                Button breakBtn = new Button("Brake", ++buttonId, simulationData.mainBike);

                add(driveBtn);
                add(breakBtn);
                add(fasterBtn);
                add(slowerBtn);
                add(colorBtn);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C4));
        }
}
