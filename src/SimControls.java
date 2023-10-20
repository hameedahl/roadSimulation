import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimControls extends JPanel {
        private int buttonId = 0;

        SimControls(Canvas canvas, Model simulationData) {
                styleControls();
                JLabel title = new JLabel("Simulation Controls");
                SimButton pause = new SimButton("Pause", ++buttonId, 
                                         simulationData);
                SimButton play = new SimButton("Play", ++buttonId, 
                                         simulationData);
                Slider speed = new Slider(0, 100, 0, 
                                          simulationData);

                String[] vehicles = {"Select Vehicle", "jeep", "truck"};
                DropDown vehicleOptions = new DropDown(vehicles);
                String[] position = {"Select Lane", "Left Lane", "Middle Lane", 
                                     "Right Lane"};
                DropDown posOptions = new DropDown(position);
                // Spinner vehicleSpinner = new Spinner(0, 30);
                SimButton addVehicle = new SimButton("Add Vehicle", 
                                                     ++buttonId, 
                                                     simulationData);

                // play.setEnabled(false);
                add(title);
                add(pause);
                add(play);
                add(speed);
                add(vehicleOptions);
                add(posOptions);
                // add(vehicleSpinner);
                add(addVehicle);
        }

        private void styleControls() {
                setBackground(new Color(0xC4C4C9));
                setPreferredSize(new Dimension(640, 80));
                setLayout(new FlowLayout());
        }
}
