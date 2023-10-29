import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class CollisionDetection implements ActionListener {
        int accidents = 0;
        ArrayList<Vehicle> vehiclesL, vehiclesM, vehiclesR;
        StatePanel statePanel;
        CollisionDetection(Model model, StatePanel statePanel) {
                new Timer(280, this).start();
                this.vehiclesL = model.vehiclesLeft;
                this.vehiclesM = model.vehiclesMiddle;
                this.vehiclesR = model.vehiclesRight;
                this.statePanel = statePanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < vehiclesL.size(); i++) {
                        for (int j = i + 1; j < vehiclesL.size(); j++) {
                                if (vehiclesL.get(i).checkForCollision(vehiclesL.get(j))) { accidents++; };
                        }
                }

                for (int i = 0; i < vehiclesM.size(); i++) {
                        for (int j = i + 1; j < vehiclesM.size(); j++) {
                                if (vehiclesL.get(i).checkForCollision(vehiclesL.get(j))) { accidents++; };
                        }
                }

                for (int i = 0; i < vehiclesR.size(); i++) {
                        for (int j = i + 1; j < vehiclesR.size(); j++) {
                                if (vehiclesR.get(i).checkForCollision(vehiclesR.get(j))) { accidents++; };
                        }
                }
                statePanel.collisionLabel.setText("Total Accidents: " + accidents);
                
        }
}
