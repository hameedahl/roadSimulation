import javax.swing.JButton;
import javax.swing.JPanel;

class StatePanel extends JPanel {
        Model model;
        private int buttonId = 0;

        Canvas canvas;
        public StatePanel(Canvas canvas, Model model) {
                this.canvas = canvas;
                this.model = model;
                JButton btn = new JButton("");
                add(btn);
        }
}
