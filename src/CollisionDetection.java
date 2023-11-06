/*
 *  
 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Keep tracks of collisions between vehicles and updates the score and
 *  collision count accordingly; to be used by Model
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class CollisionDetection implements ActionListener {
        int collisions = 0;
        StatePanel statePanel;
        Model model;
        CollisionDetection(Model model, StatePanel statePanel) {
                new Timer(280, this).start();
                this.statePanel = statePanel;
                this.model = model;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < model.vehiclesLeft.size(); i++) {
                        for (int j = i + 1; j < model.vehiclesLeft.size(); j++) {
                                if (model.vehiclesLeft.get(i).
                                   checkForCollision(model.vehiclesLeft.get(j),
                                   model)) { 
                                        collisions++;
                                        model.score -= 10;
                                }
                        }
                }

                for (int i = 0; i < model.vehiclesMiddle.size(); i++) {
                        for (int j = i + 1; j < model.vehiclesMiddle.size(); j++) {
                                if (model.vehiclesMiddle.get(i).
                                   checkForCollision(model.vehiclesMiddle.get(j), 
                                   model)) { 
                                        collisions++;
                                        model.score -= 10;
                                }
                        }
                }

                for (int i = 0; i < model.vehiclesRight.size(); i++) {
                        for (int j = i + 1; j < model.vehiclesRight.size(); j++) {
                                if (model.vehiclesRight.get(i).
                                    checkForCollision(model.vehiclesRight.get(j),
                                    model)) { 
                                        collisions++;
                                        model.score -= 10;
                                }
                        }
                }
                statePanel.updateAccidentCount(collisions);
                model.score = (model.score < 0) ? 0: model.score;
                statePanel.updateScore(model.score); 
        }
}