import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerControls extends JPanel{
        private int buttonId = 0;
        PlayerButton driveBtn, colorBtn, breakBtn;
        Slider speed;

        PlayerControls(Canvas canvas, Model simulationData) {
                styleControls();
                JLabel title = new JLabel("Player Controls");
                driveBtn = new PlayerButton("Drive", ++buttonId, 
                                             simulationData.mainBike,
                                             simulationData.background1, 
                                             simulationData.background2, this);
                speed = new Slider(0, 100, 0, 
                                          simulationData.background1, 
                                          simulationData.background2);
                colorBtn = new PlayerButton("Change Bike Color", 
                                            ++buttonId, 
                                            simulationData.mainBike, 
                                            simulationData.background1, 
                                            simulationData.background2, this);
                breakBtn = new PlayerButton("Brake", ++buttonId, 
                                            simulationData.mainBike,
                                            simulationData.background1, 
                                            simulationData.background2, this);

                breakBtn.setEnabled(false);
                speed.setEnabled(false);
                add(title);
                add(driveBtn);
                add(breakBtn);
                add(speed);
                add(colorBtn);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C4));
                setPreferredSize(new Dimension(640, 80));
                setLayout(new FlowLayout());
        }
}
