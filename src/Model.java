/*
 *  
 *  Assignment: Java4 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Holds data for the simulation and keeps track 
 *  of any updates made
 * 
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        Bike mainBike;
        String backgroundPath = "imgs/background.png";
        Canvas mainCanvas;
        Background background1, background2;
        int bikeIdx = 0;
        /* data for adding vehicles to sim */
        ArrayList<String> vehiclePaths = new ArrayList<String>
                          (Arrays.asList("bike_blue", 
                                         "bus", "car_blue", "car_grey", 
                                         "jeep", "car_green", 
                                         "cop_car", "fast_car"));
        ArrayList<Integer> x = new ArrayList<Integer>
                          (Arrays.asList(550, 
                                         -500, 100, 490, 
                                         50, -250,
                                         100, 490));
        ArrayList<Integer> y = new ArrayList<Integer>
                          (Arrays.asList(360, 
                                         330, 380, 
                                         380, 450, 450,
                                         510, 510));
        ArrayList<Integer> speed = new ArrayList<Integer>
                          (Arrays.asList(15, 
                                         25, 25, 25,
                                         30, 25,
                                         60, 60));

        public Model(Canvas canvas) {
                this.mainCanvas = canvas;
                /* have 2nd background already drawn for looping */
                background1 = new Background(0,0, 15, 
                                             mainCanvas, backgroundPath);
                background2 = new Background(2132,0, 15, 
                                             mainCanvas, backgroundPath);
                createVehicles();
        }

        public void createVehicles() {
                /* add cars to each lane */
                for (int newVehicle = 0; newVehicle < vehiclePaths.size(); 
                     newVehicle++) {
                        Vehicle vehicle;
                        if (newVehicle == bikeIdx) {
                                /* store player bike in instance variable */
                                vehicle = new Bike(x.get(newVehicle), 
                                                y.get(newVehicle), 
                                                speed.get(newVehicle), 
                                                5, false, mainCanvas, 
                                                "imgs/" + 
                                                vehiclePaths.get(newVehicle) 
                                                + ".png");
                                mainBike = (Bike) vehicle;
                        } else {
                                vehicle = new Car(x.get(newVehicle), 
                                                y.get(newVehicle), 
                                                speed.get(newVehicle), 
                                                5, true, mainCanvas, 
                                                "imgs/" + 
                                                vehiclePaths.get(newVehicle) 
                                                + ".png");
                        }
                        
                        vehicles.add(vehicle);
                }
        }

        /* draw methods called by canvas */
        public void draw(Graphics2D canvas) {
                drawBackground(background1, canvas);
                drawBackground(background2, canvas);
                drawRoad(canvas);
                drawVehicles(canvas);
        }

        public void drawVehicles(Graphics2D canvas) {
                for (Vehicle vehicle : vehicles) {
                        vehicle.draw(canvas);
                }
        }

        public void drawBackground(Background background, Graphics2D canvas) {
                canvas.drawImage(background.getBgImage(), background.getX(), 0, null);
        }
        
        public void drawRoad(Graphics2D canvas) {
                /* street */
                canvas.setColor(new Color(0x41413E));
                canvas.fillRect(0, 450, 1280, 180);

                /* lanes */
                canvas.setColor(Color.white);
                int lanesLineX = 0;

                for (int i = 0; i < 9; i++) {
                        canvas.fillRect(lanesLineX, 510, /* upper lane */
                                        100, 6); 
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
                for (int i = 0; i < 25; i++) {
                        canvas.drawLine(topXVal, 440, topXVal, topLineBottom);
                        topXVal += 50;
                }
        }
}
