/*
 *  
 *  Assignment: Java6 Fall 2023
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
import java.util.ArrayList;

public class Model {
        ArrayList<Vehicle> vehiclesLeft = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehiclesMiddle = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehiclesRight = new ArrayList<Vehicle>();
        String[] lanes = {"Select Lane", "Left Lane", 
                          "Middle Lane", "Right Lane"};
        int vehicleCount, score = 0;

        Bike mainBike;
        String backgroundPath = "imgs/background.png";
        Canvas mainCanvas;
        StatePanel statePanel;
        Background background1, background2;
        int bikeIdx = 0;
        boolean isPaused = false;
        Vehicle selectedVehicle;
        CollisionDetection collision;

        /* data for adding vehicles to sim */
        String[] newVehiclePaths = {"car_grey", "sports_car", 
                                    "car_blue", "red_vintage", "black_vintage",
                                    "fast_car", "jeep", "car_green",
                                    "sliver_hatchback", "cop_car", 
                                    "blue_sport_sedan", "motorcycle_red", 
                                    "motorcycle_black"};
        String[] newVehicles = {"Select Vehicle", "Grey Sedan", 
                                "Red Sports Car", "Blue SUV",
                                "Red Vintage Coupe", "Black Vintage Coupe",
                                "Green Sports Car", "Jeep", "Green SUV",
                                "Sliver Hatchback", "Cop Car", 
                                "Blue Sport Sedan", "Red Motorcycle", 
                                "Black Motorcycle"};
        
        public Model(Canvas canvas, Controls stateControls) {
                this.mainCanvas = canvas;
                this.statePanel = stateControls.statePanel;
                /* have 2nd background already drawn for looping */
                background1 = new Background(0,0, 15, 
                                             mainCanvas, backgroundPath);
                background2 = new Background(2132,0, 15, 
                                             mainCanvas, backgroundPath);
                createVehicles();
                selectedVehicle = new Car("", 0, 0, 0, 0, 
                                          false, mainCanvas, "");
                selectedVehicle.lane = -1;
                statePanel.updateCarCount(vehicleCount);
                collision = new CollisionDetection(this, statePanel);
        }

        public void createVehicles() {
                /* add bike to sidewalk */
                mainBike = new Bike(550, 360, 15, 5, 
                                    false, mainCanvas, 
                                    "imgs/bike.png");
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
                statePanel.updateState("Simulation paused.");

        }

        public void startSimVehicles() {
                isPaused = false;
                for (Vehicle vehicle : vehiclesLeft) { vehicle.drive(); }
                for (Vehicle vehicle : vehiclesRight) { vehicle.drive(); }
                for (Vehicle vehicle : vehiclesMiddle) { vehicle.drive(); }
                statePanel.updateState("");
        }
                                        
        public void addSimVehicle(String name, int vehicleIndex, 
                                  int positionIndex, int vehicleSpeed) {
                if (vehicleIndex < 0 || positionIndex < 1) {
                        statePanel.updateState("Error: Invalid insertion");
                        return;
                }
                String newVehPath = newVehiclePaths[vehicleIndex - 1];
                Vehicle vehicle = new Car(name, -500, 0, vehicleSpeed, 5, 
                                 true, mainCanvas, 
                                          "imgs/" + newVehPath + ".png");
                addToLane(vehicle, positionIndex - 1);
                statePanel.updateCarCount(++vehicleCount);
                score += 500;
                statePanel.updateScore(score);
                statePanel.updateState("Added a " + vehicle.name);

        }

        public void checkMouse(Point e) {
                Vehicle newVehicle = new Car("NULL", 0, 0, 0, 0, 
                                             false, mainCanvas, "");
                for (Vehicle vehicle : vehiclesLeft) { 
                        if (vehicle.wasClicked(e)) {
                                newVehicle = vehicle;
                        } 
                }
                for (Vehicle vehicle : vehiclesRight) { 
                        if (vehicle.wasClicked(e)) {
                                newVehicle = vehicle;
                        } 
                 }
                for (Vehicle vehicle : vehiclesMiddle) { 
                        if (vehicle.wasClicked(e)) {
                                newVehicle = vehicle;
                        }  
                }

                selectedVehicle.isSelected = false;
                selectedVehicle = newVehicle;
                selectedVehicle.isSelected = true;
                if (selectedVehicle.name == "NULL") {
                        statePanel.selectedLabel.setText("");
                } else {
                        statePanel.updateSelected(selectedVehicle.name, 
                                                  lanes[selectedVehicle.lane + 1], 
                                                  selectedVehicle.getSpeed());
                }
                mainCanvas.repaint();
        }

        void changeLanes(Vehicle vehicle, boolean printChange) {
                int oldLane = vehicle.lane;
                vehicle.lane = (oldLane + 1) % 3; /* loop through lanes */

                /* remove vehicle from old lane */
                if (oldLane == 0) { /* left */
                        vehiclesLeft.remove(vehicle);
                } else if (oldLane == 1) { /* middle */
                        vehiclesMiddle.remove(vehicle);
                } else { /* right */
                        vehiclesRight.remove(vehicle);
                }

                if (printChange) {
                        statePanel.updateSelected(vehicle.name, 
                                                  lanes[vehicle.lane + 1], 
                                                  vehicle.getSpeed());
                }
                addToLane(vehicle, vehicle.lane);
        }

        void addToLane(Vehicle vehicle, int lane) {
                /* add to new lane */
                if (lane == 0) { /* left */
                        vehicle.setY(380);
                        vehicle.lane = lane;
                        vehiclesLeft.add(vehicle);
                } else if (lane == 1) { /* middle */
                        vehicle.setY(450);
                        vehicle.lane = lane;
                        vehiclesMiddle.add(vehicle);
                } else { /* right */
                        vehicle.setY(510);
                        vehicle.lane = lane;
                        vehiclesRight.add(vehicle);
                }
                mainCanvas.repaint();
        }

        void removeVehicle(Vehicle vehicle, boolean isDamaged) {
                String msg = "";
                /* add to new lane */
                if (vehicle.lane == 0) { /* left */
                        vehiclesLeft.remove(vehicle);
                } else if (vehicle.lane == 1) { /* middle */
                        vehiclesMiddle.remove(vehicle);
                } else { /* right */
                        vehiclesRight.remove(vehicle);
                }
                statePanel.updateCarCount(--vehicleCount);
                if (isDamaged) {
                        msg = "The " + vehicle.name + " sustained significant damage and had to be towed";
                        score = (score - 50 < 0) ? 0: score - 50;
                } else {
                        msg = "Removed the " + vehicle.name;
                        score = (score - 10 < 0) ? 0: score - 10;
                }
                statePanel.updateScore(score);
                statePanel.updateState(msg);
                statePanel.selectedLabel.setText("");
                mainCanvas.repaint();
        }
}