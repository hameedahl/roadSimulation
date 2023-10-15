/*
 *  Assignment: Java1 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Creates and styles a JComboBox
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;

public class DropDown extends JComboBox<String> {
        public DropDown(String[] values) {
                new JComboBox<>(values);
                /* initialize combo box with passed in values */
                for(int val = 0; val < values.length; val++) {
                        addItem(values[val]);
                }
        }

        public void styleBox(int textColor, int boxColor, String font, 
                             int fontWeight, int fontSize) {
                setEditable(true); /* allow styling */
                getEditor().getEditorComponent()
                           .setBackground(new Color(boxColor));
                getEditor().getEditorComponent()
                           .setForeground(new Color(textColor));
                setFont(new Font(font, fontWeight, fontSize)); 
        }
        
}
