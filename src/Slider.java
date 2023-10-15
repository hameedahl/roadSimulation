/*
 *  Assignment: Java1 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Creates and styles a JSlider
 */

import java.awt.Color;
import java.awt.Font;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JSlider implements ChangeListener {
        Background background1, background2;

        public Slider(int minVal, int maxVal, int start, 
                      Background background1, Background background2) {
                new JSlider(minVal, maxVal);
                setValue(0);
                addChangeListener(this);
                this.background1 = background1;
                this.background2 = background2;
        }

        public void styleSlider(int textColor, String font, 
                                int fontWeight, int fontSize) {
                setForeground(new Color(textColor));
                setFont(new Font(font, fontWeight, fontSize)); 
                /* add ticks and interval spacing */
                setPaintTicks(true);
		setMinorTickSpacing(1);
		setPaintTrack(true);
		setMajorTickSpacing(5);
		setPaintLabels(true);
        }
        
        @Override
        public void stateChanged(ChangeEvent e) {
                int value = Integer.parseInt(String.valueOf(getValue()));
                System.out.println(value);
                background1.changeSpeed(value * -1);
                background2.changeSpeed(value * -1);
        }
}
