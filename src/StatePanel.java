/*
 *  
 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Displays the status of the game (score, collisions, and car count) 
 * 
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StatePanel extends JPanel {
        Model model;
        JLabel carCountLabel, collisionLabel, scoreLabel, 
               stateLabel, selectedLabel;

        Canvas canvas;
        public StatePanel(Canvas canvas) {
                styleControls();
                this.canvas = canvas;
                selectedLabel = new JLabel();
                JLabel empty0 = new JLabel("       ");
                carCountLabel = new JLabel();
                JLabel empty1 = new JLabel("       ");
                collisionLabel = new JLabel("Total Collisions: 0");
                JLabel empty2 = new JLabel("       ");
                scoreLabel = new JLabel("Total Score: 0");
                JLabel empty3 = new JLabel("       ");
                stateLabel = new JLabel("");

                styleLabels();
                add(selectedLabel);
                add(empty0);
                add(carCountLabel);
                add(empty1);
                add(collisionLabel);
                add(empty2);
                add(scoreLabel);
                add(empty3);
                add(stateLabel);
        }

        private void styleControls() {
                setBackground(new Color(0xC9C9C9));
                setPreferredSize(new Dimension(40, 30));
                setLayout(new FlowLayout());
        }
        public void updateSelected(String name, String lane, int speed) {
                selectedLabel.setText(name + " in " + lane + 
                                      " going " + speed + "m/hr");
        }

        public void updateCarCount(int count) {
                carCountLabel.setText("Total Vehicles: " + count);
        }

        public void updateAccidentCount(int count) {
                collisionLabel.setText("Total Collisions: " + count);
        }

        public void updateScore(int score) {
                scoreLabel.setText("Total Score: " + score);
        }

        public void updateState(String msg) {
                stateLabel.setText(msg);
        }

        public void styleLabels() {
                stateLabel.setForeground(Color.BLUE);
                selectedLabel.setForeground(Color.BLUE);
        }
}
