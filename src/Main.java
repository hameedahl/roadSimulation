/*
 *  
 *  Assignment: Java3 Fall 2023
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
                setSize(1280, 740);

                // MenuBar menu = new MenuBar();
                // setJMenuBar(menu);
                Canvas canvas = new Canvas(); /* canvas for ui */ 
                Model simulationData = new Model(canvas);
                canvas.setModel(simulationData);
                Controls controlPanel = new Controls(canvas, simulationData);

                add(canvas); 
                add(controlPanel, BorderLayout.PAGE_END);

                setVisible(true);
        }
}