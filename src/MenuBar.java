/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  MenuBar to be in used in Main
 * 
 */

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {
        private String[] menuOp = {"Settings", "Help", "Quit"};
        public MenuBar() {
                new JMenuBar();
                for (String option : menuOp) {
                        this.add(new JMenu(option));
                }
        }
}