import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Model {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Bike mainBike;
        String backgroundPath = "imgs/background.png";
        Canvas mainCanvas;

        public Model(Canvas canvas) {
                this.mainCanvas = canvas;
                createVehicles();
        }

        public void createVehicles() {
                /* top lane  */
                // Car car1 = new Car(300, 380, 15, 5, 
                //         true, mainCanvas, "imgs/car_blue.png");
                // vehicles.add(car1);

                /* middle lane  */
                mainBike = new Bike(50, 470, 15, 5, 
                             false, mainCanvas, "imgs/bike_blue.png");
                vehicles.add(mainBike);

                /* bottom lane  */
        }

        /* draw methods called by canvas */
        public void draw(Graphics2D canvas) {
                drawBackground(canvas);
                drawRoad(canvas);
                drawVehicles(canvas);
        }

        public void drawVehicles(Graphics2D canvas) {
                for (Vehicle vehicle : vehicles) {
                        System.out.println("redrawing " + vehicle);
                        System.out.println("x: " + vehicle.getX());

               
                        vehicle.draw(canvas);
                }
        }

        public void drawBackground(Graphics2D canvas) {
                ImageIcon backgroundImg = new ImageIcon(backgroundPath);
                canvas.drawImage(backgroundImg.getImage(),  0, 0, null);
        }
        
        public void drawRoad(Graphics2D canvas) {
                /* street */
                canvas.setColor(new Color(0x41413E));
                canvas.fillRect(0, 450, 1280, 180);

                /* lanes */
                canvas.setColor(Color.white);
                int lanesLineX = 0;

                for (int i = 0; i < 10; i++) {
                        canvas.fillRect(lanesLineX, 510, 100, 6); /* upper */
                        canvas.fillRect(lanesLineX, 570, 100, 6);

                        lanesLineX += 150;
                }
                drawSideWalk(canvas);
        }

        public void drawSideWalk(Graphics2D canvas) {
                /* top sidewalk step */
                canvas.setColor(new Color(0x737373));
                canvas.fillRect(0, 440, 1280, 10);
                canvas.setStroke(new BasicStroke(3));
                canvas.drawRect(0, 440, 1280, 10);

                canvas.setColor(new Color(0x919191));
                canvas.fillRect(0, 420, 1280, 20); /* top sidewalk */
                canvas.fillRect(0, 630, 1280, 40); /* bottom sidewalk */

                canvas.setColor(new Color(0x383838));
                canvas.drawRect(0, 420, 1280, 20);
                canvas.drawRect(0, 630, 1280, 40);

                /* lines for sidewalk */
                canvas.setColor(new Color(0x4b4b4b));
                int topLineBottom = 450;
                int topXVal = 50;
                for (int i = 0; i < 35; i++) {
                        canvas.drawLine(topXVal, 440, topXVal, topLineBottom);
                        topXVal += 50;
                }
        }
}
