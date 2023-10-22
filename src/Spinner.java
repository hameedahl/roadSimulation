/*
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Get value to set speed of a new vehicle to add to the
 *  simulation; to be used by SimControls
 */


import java.awt.Dimension;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Spinner extends JSpinner {
        public Spinner(int minVal, int maxVal) {
                new JSpinner(new SpinnerNumberModel(1, minVal, maxVal, 1));
                setPreferredSize(new Dimension(60, 20));
        }
}
