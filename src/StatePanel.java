import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StatePanel extends JPanel {
        Model model;
        private int buttonId = 0;
        JLabel carLabel, collisionLabel, scoreLabel;
        int carCount = 0, collisionCount = 0, score = 0;

        Canvas canvas;
        public StatePanel(Canvas canvas) {
                styleControls();
                this.canvas = canvas;
                carLabel = new JLabel();
                JLabel empty1 = new JLabel("       ");
                collisionLabel = new JLabel("Total Accidents: 0");
                scoreLabel = new JLabel("Total Score: 0");
                JLabel empty2 = new JLabel("       ");


                add(carLabel);
                add(empty1);
                add(collisionLabel);
                add(empty2);
                add(scoreLabel);

        }

        private void styleControls() {
                setBackground(new Color(0xC9C9C9));
                setPreferredSize(new Dimension(40, 20));
                setLayout(new FlowLayout());
        }

        public void updateCarCount(int count) {
                carLabel.setText("Total Vehicles: " + count);
        }

        public void updateAccidentCount(int count) {
                carLabel.setText("Total Accidents: " + count);
        }

        public void updateScore(int count) {
                scoreLabel.setText("Total Accidents: " + score);
        }
}
