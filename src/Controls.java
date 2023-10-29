/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  All controls needed for simulation; i.e driving, 
 *  changing speed and color 
 *  
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class Controls extends JPanel {
        StatePanel statePanel;
        public Controls(Canvas canvas, Model simulationData) {
                styleControls();
                PlayerControls playerPanel = new PlayerControls(canvas, 
                                                                simulationData);
                SimControls simPanel = new SimControls(canvas, simulationData);
                add(playerPanel, BorderLayout.LINE_END);
                add(simPanel, BorderLayout.LINE_START);
        }

        public Controls(Canvas canvas) {
                styleControls();
                setBackground(new Color(0xC9C9C9));

                setPreferredSize(new Dimension(1280, 30));
                statePanel = new StatePanel(canvas);
                add(statePanel, BorderLayout.NORTH);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C9));
                setPreferredSize(new Dimension(1280, 80));
                setLayout(new BorderLayout());
        }
}
