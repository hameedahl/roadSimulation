/*

 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Holds player widgets to control and customize the player's 
 *  vehicle by interacting with Background class (make Bike "move"); 
 *  to be used by Controls
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerControls extends JPanel{
        private int buttonId = 0;
        PlayerButton driveBtn, colorBtn, breakBtn;
        PlayerButton changeLanesBtn, speedBtn, slowBtn;

        Slider speed;

        PlayerControls(Canvas canvas, Model simulationData) {
                styleControls();
                JLabel playerJLabel = new JLabel("Player Controls");
                driveBtn = new PlayerButton("Drive", ++buttonId, 
                                            this, simulationData);
                speed = new Slider(0, 100, 0, 
                                          simulationData.background1, 
                                          simulationData.background2);
                colorBtn = new PlayerButton("Change Bike Color", 
                                            ++buttonId, 
                                            this, simulationData);
                breakBtn = new PlayerButton("Brake", ++buttonId, 
                                            this, simulationData);

                JLabel selectedJLabel = new JLabel("Selected Controls");

                changeLanesBtn = new PlayerButton("Change Lanes", ++buttonId, 
                                            this, simulationData);
                speedBtn = new PlayerButton("Speed Up", ++buttonId, 
                                            this, simulationData);
                slowBtn = new PlayerButton("Slow Down", ++buttonId, 
                                            this, simulationData);

                breakBtn.setEnabled(false);
                speed.setEnabled(false);
                add(playerJLabel);
                add(driveBtn);
                add(breakBtn);
                add(speed);
                add(colorBtn);
                add(selectedJLabel);
                add(changeLanesBtn);
                add(slowBtn);
                add(speedBtn);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C4));
                setPreferredSize(new Dimension(640, 80));
                setLayout(new FlowLayout());
        }
}
