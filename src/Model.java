/*
 *  
 *  Assignment: Java5 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Holds data for the simulation and keeps track 
 *  of any updates made
 * 
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class Model {
        ArrayList<Vehicle> vehiclesLeft = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehiclesMiddle = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehiclesRight = new ArrayList<Vehicle>();
        int vehicleCount = 0;

        Bike mainBike;
        String backgroundPath = "imgs/background.png";
        Canvas mainCanvas;
        Background background1, background2;
        int bikeIdx = 0;
        boolean isPaused = false;
        Vehicle selectedVehicle;

        /* data for adding vehicles to sim */
        ArrayList<String> vehiclePaths = new ArrayList<String>
                         (Arrays.asList("bus", "car_blue", "car_grey",
                                        "jeep", "car_green",
                                        "cop_car", "fast_car"));
        ArrayList<Integer> xVal = new ArrayList<Integer>
                                (Arrays.asList(-500, 100, 490,
                                                50, -250,
                                                100, 490));
        ArrayList<Integer> yVal = new ArrayList<Integer>
                                (Arrays.asList(330, 380, 380,
                                               450, 450,
                                               510, 510));
        ArrayList<Integer> speed = new ArrayList<Integer>
                                 (Arrays.asList(25, 25, 25,
                                                30, 25, 
                                                70, 70));   

        String[] newVehiclePaths = {"sports_car", "red_vintage", 
                                    "black_vintage", "sliver_hatchback",
                                    "blue_sport_sedan", "motorcycle_red", 
                                    "motorcycle_black"};

        public Model(Canvas canvas) {
                this.mainCanvas = canvas;
                /* have 2nd background already drawn for looping */
                background1 = new Background(0,0, 15, 
                                             mainCanvas, backgroundPath);
                background2 = new Background(2132,0, 15, 
                                             mainCanvas, backgroundPath);
                createVehicles();
                selectedVehicle = new Car(0, 0, 0, 0, false, mainCanvas, "");
        }

        public void createVehicles() {
                /* add bike to sidewalk */
                mainBike = new Bike(550, 360, 15, 5, false, mainCanvas, 
                                    "imgs/bike.png");
                // vehiclesLeft.add(mainBike);

                vehicleCount = vehiclePaths.size();
                /* add cars to each lane */
                for (int i = 0; i < vehicleCount; i++) {
                        Vehicle vehicle = new Car(xVal.get(i), yVal.get(i), 
                                                  speed.get(i), 5, true, 
                                                  mainCanvas, 
                                                  "imgs/" + 
                                                  vehiclePaths.get(i) + 
                                                  ".png");
                        if (yVal.get(i) == 330 || yVal.get(i) == 380) {
                                vehiclesLeft.add(vehicle);
                        } else if (yVal.get(i) == 450) {
                                vehiclesMiddle.add(vehicle);
                        } else {
                                vehiclesRight.add(vehicle);
                        }
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
                if (background1.isMoving) {
                        mainBike.animate(); /* show "peddling" */
                }
                mainBike.draw(canvas);

                /* draw vehicles in order of lane for layering */
                for (Vehicle vehicle : vehiclesLeft) {
                        vehicle.draw(canvas);
                }

                for (Vehicle vehicle : vehiclesMiddle) {
                        vehicle.draw(canvas);
                }

                for (Vehicle vehicle : vehiclesRight) {
                        vehicle.draw(canvas);
                }
        }

        public void drawBackground(Background background, Graphics2D canvas) {
                canvas.drawImage(background.getBgImage(), 
                                 background.getX(), 0, null);
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
                /* top sidewalk */
                canvas.fillRect(0, 420, 1280, 20);
                /* bottom sidewalk */ 
                canvas.fillRect(0, 630, 1280, 40);

                canvas.setColor(new Color(0x383838));
                canvas.drawRect(0, 420, 1280, 20);
                canvas.drawRect(0, 630, 1280, 40);

                /* lines for sidewalk */
                canvas.setColor(new Color(0x4b4b4b));
                int topLineBottom = 450;
                int topXVal = 50;
                for (int i = 0; i < 25; i++) {
                        canvas.drawLine(topXVal, 440, 
                                        topXVal, topLineBottom);
                        topXVal += 50;
                }
        }

        public void stopSimVehicles() {
                isPaused = true;
                for (Vehicle vehicle : vehiclesLeft) { vehicle.brake(); }
                for (Vehicle vehicle : vehiclesRight) { vehicle.brake(); }
                for (Vehicle vehicle : vehiclesMiddle) { vehicle.brake(); }
        }

        public void startSimVehicles() {
                isPaused = false;
                for (Vehicle vehicle : vehiclesLeft) { vehicle.drive(); }
                for (Vehicle vehicle : vehiclesRight) { vehicle.drive(); }
                for (Vehicle vehicle : vehiclesMiddle) { vehicle.drive(); }
        }

        public void addSimVehicle(int vehicleIndex, int positionIndex, 
                                  int vehicleSpeed) {
                String newVehPath = newVehiclePaths[vehicleIndex - 1];
                Vehicle vehicle = new Car(-500, 0, vehicleSpeed, 5, 
                                 true, mainCanvas, 
                                          "imgs/" + newVehPath + ".png");
                if (positionIndex == 1) { /* left */
                        vehicle.setY(380);
                        vehiclesLeft.add(vehicle);
                } else if (positionIndex == 2) { /* middle */
                        vehicle.setY(450);
                        vehiclesMiddle.add(vehicle);
                } else { /* right */
                        vehicle.setY(510);
                        vehiclesRight.add(vehicle);
                }
                mainCanvas.repaint();
        }

        public void checkMouse(Point e) {
                Vehicle newVehicle = new Car(0, 0, 0, 0, false, mainCanvas, "");
                for (Vehicle vehicle : vehiclesLeft) { 
                        if (vehicle.wasClicked(e)) {
                                newVehicle = vehicle;
                                System.out.println(vehicle.imagePath);
                        } 
                }
                for (Vehicle vehicle : vehiclesRight) { 
                        if (vehicle.wasClicked(e)) {
                                newVehicle = vehicle;
                                System.out.println(vehicle.imagePath);
                        } 
                 }
                for (Vehicle vehicle : vehiclesMiddle) { 
                        if (vehicle.wasClicked(e)) {
                                newVehicle = vehicle;
                                System.out.println(vehicle.imagePath);
                        }  
                }

                selectedVehicle.isSelected = false;
                selectedVehicle = newVehicle;
                selectedVehicle.isSelected = true;
                mainCanvas.repaint();

        }
}

// check for collision in tick