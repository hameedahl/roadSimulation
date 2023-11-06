/*

 *  Assignment: Java7 Fall 2023
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
        PlayerButton changeLanesBtn, speedBtn, slowBtn, removeBtn, 
                     zoomInBtn, zoomOutBtn;

        Slider speed;

        PlayerControls(Canvas canvas, Model simulationData) {
                styleControls();
                /* no longer added to panel */
                JLabel playerJLabel = new JLabel("Player Controls");
                driveBtn = new PlayerButton("Drive", ++buttonId, 
                                            this, simulationData);
                speed = new Slider(0, 84, 0, 
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
                removeBtn = new PlayerButton("Remove", ++buttonId, 
                                            this, simulationData);
                
                JLabel zoomLabel = new JLabel("Zoom Controls");
                zoomInBtn = new PlayerButton("Zoom In", ++buttonId, 
                                            this, simulationData);
                zoomOutBtn = new PlayerButton("Zoom Out", ++buttonId, 
                                            this, simulationData);
                breakBtn.setEnabled(false);
                speed.setEnabled(false);
                zoomOutBtn.setEnabled(false);


                add(selectedJLabel);
                add(changeLanesBtn);
                add(slowBtn);
                add(speedBtn);
                add(removeBtn);
                add(zoomLabel);
                add(zoomInBtn);
                add(zoomOutBtn);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C4));
                setPreferredSize(new Dimension(640, 80));
                setLayout(new FlowLayout());
        }
}
