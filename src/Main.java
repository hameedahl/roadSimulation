/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Main driver of GUI
 * 
 */

import java.awt.BorderLayout;
import javax.swing.*; 

public class Main extends JFrame {
        public static void main (String [] args) {
                java.awt.EventQueue.invokeLater (new Runnable() {
                    public void run() {
                            new Main();
                    }
                });
        }
        
        public Main () {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(new BorderLayout());
                setSize(1280, 790);
                
                Canvas canvas = new Canvas(); /* canvas for ui */ 
                Controls stateControls = new Controls(canvas);
                Model simulationData = new Model(canvas, stateControls);
                Controls controlPanel = new Controls(canvas, simulationData);
                canvas.setModel(simulationData);


                add(canvas); 
                add(controlPanel, BorderLayout.PAGE_END);
                add(stateControls, BorderLayout.PAGE_START);
                setVisible(true);
        }
}