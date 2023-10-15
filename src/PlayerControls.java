import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayerControls extends JPanel{
        private int buttonId = 0;
        PlayerControls(Canvas canvas, Model simulationData) {
                styleControls();
                JLabel title = new JLabel("Player Controls");
                PlayerButton driveBtn = new PlayerButton("Drive", ++buttonId, 
                                             simulationData.background1, 
                                             simulationData.background2);
                Slider speed = new Slider(0, 100, 0, simulationData.background1, simulationData.background2);
                PlayerButton fasterBtn = new PlayerButton("Speed Up", ++buttonId, 
                                              simulationData.background1, 
                                              simulationData.background2);
                PlayerButton slowerBtn = new PlayerButton("Slow Down", ++buttonId, 
                                              simulationData.background1, 
                                              simulationData.background2);
                PlayerButton colorBtn = new PlayerButton("Change Bike Color", 
                                             ++buttonId, 
                                             simulationData.mainBike);
                PlayerButton breakBtn = new PlayerButton("Brake", ++buttonId, 
                                             simulationData.background1, 
                                             simulationData.background2);

                // fasterBtn.setEnabled(false);
                // slowerBtn.setEnabled(false);
                // breakBtn.setEnabled(false);

                add(title);
                add(driveBtn);
                add(breakBtn);
                add(speed);

                add(fasterBtn);
                add(slowerBtn);
                add(colorBtn);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C4));
                setPreferredSize(new Dimension(640, 80));
                setLayout(new FlowLayout());
        }
}
