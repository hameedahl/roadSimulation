/*
 *  
 *  Assignment: Java7 Fall 2023
 *  Name: Hameedah Lawal 
 *  Email: hlawal01@tufts.edu
 *  Holds data for the simulation and keeps track 
 *  of any updates made
 * 
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

public class Model {
        ArrayList<Vehicle> vehiclesLeft = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehiclesMiddle = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehiclesRight = new ArrayList<Vehicle>();
        String[] lanes = {"Select Lane", "Left Lane", 
                          "Middle Lane", "Right Lane"};
        int[] laneVal = {380, 450, 510};
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
        double zoom = 1, streetZoom = 0, vehicleZoom = 1;

        /* HTML instructions for dialogue box */
        String instructions = 
        """
        <html>
            <div>
                <span style='color: blue;'><b>How To Win: Add as many 
                vehicles as you can while still keeping the <br> collision count 
                low <i>(Tip: Use different lanes and speed)</i><b><br>
                </span>
                <ul>
                   <li><i><span style='color: blue;'>Adding Vehicles</i></span>
                   → on the bottom left corner of the screen: <br> pick a car,
                   lane, and initial speed, then hit "Add Vehicle"<b><br>
                   (+500 points)</b><br><br>

                   <li><i><span style='color: blue;'>Modifying Vehicles</i>
                   </span>→ click on a vehicle until a red box <br> outlines it
                   (pause the simulation, if needed). On the bottom <br>
                   right corner of the screen, change the speed, lane, or
                   remove it <br><b>(-10 points)</b>. <br><br>
                   
                   <li><i><span style='color: blue;'>Collisions</i>
                   </span>→ When a vehicle collides with another <b>
                   (-50 points)</b>, <br>both take "damage" and slow down 
                   until they eventually<br> come to a stop, and are removed
                   from the simulation <br><b>(-10 points)</b>
                </ul>
            </div>
        </html>       
        """;

        /* data for adding vehicles to sim */
        String[] newVehiclePaths = {"car_grey",  "bike_blue", "sports_car", 
                                    "car_blue", "bike_green", "red_vintage", 
                                    "black_vintage", "fast_car", "jeep", 
                                    "bike_orange", "car_green", 
                                    "sliver_hatchback", "cop_car", "bike_pink",
                                    "blue_sport_sedan", "motorcycle_red", 
                                    "motorcycle_black", "bike_red"};
        String[] newVehicles = {"Select Vehicle", 
                                "Grey Sedan", "Blue Bike", "Red Sports Car", 
                                "Blue SUV", "Green Bike", "Red Vintage Coupe", 
                                "Black Vintage Coupe", "Green Sports Car", 
                                "Jeep", "Orange Bike", "Green SUV", 
                                "Sliver Hatchback", "Cop Car", "Pink Bike", 
                                "Blue Sport Sedan", "Red Motorcycle", 
                                "Black Motorcycle", "Red Bike"};
        
        public Model(Canvas canvas, Controls stateControls) {
                this.mainCanvas = canvas;
                this.statePanel = stateControls.statePanel;
                /* have 2nd background already drawn for looping */
                background1 = new Background(0,0, 15, 
                                             mainCanvas, backgroundPath);
                background2 = new Background(2132,0, 15, 
                                             mainCanvas, backgroundPath);
                
                selectedVehicle = new Car("", 0, 0, 0, 0, 
                                          false, mainCanvas, "");
                selectedVehicle.lane = -1;
                statePanel.updateCarCount(vehicleCount);
                collision = new CollisionDetection(this, statePanel);
        }

        public void addPlayerBike() {
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
                canvas.drawImage(background.getImage(), 
                                 background.getX(), background.getY(), 
                                 background.getWidth(), 
                                 background.getHeight(), null);
        }
        
        public void drawRoad(Graphics2D canvas) {
                /* street */
                canvas.setColor(new Color(0x41413E));
                canvas.fillRect(0, (int) (450 + streetZoom), 
                                1280, (int) (180 + streetZoom));

                /* lanes */
                canvas.setColor(Color.white);
                int lanesLineX = 0;

                for (int i = 0; i < 9; i++) {
                        /* upper lane */
                        canvas.fillRect(lanesLineX, 
                                        (int) (510 + (streetZoom * 2)), 
                                        100, 6); 
                        canvas.fillRect(lanesLineX, 
                                        (int) (570 + (streetZoom * 2)),
                                        100, 6);
                        lanesLineX += 150;
                }
                drawSideWalk(canvas);
        }

        public void drawSideWalk(Graphics2D canvas) {
                /* top sidewalk step */
                double scaledZoom = (streetZoom / 2);
                canvas.setColor(new Color(0x737373));
                canvas.fillRect(0, (int) (440 + streetZoom), 
                                1280, (int) (10 + scaledZoom)); 
                canvas.setStroke(new BasicStroke(3));
                canvas.drawRect(0, (int) (440 + streetZoom), 
                                1280, (int) (10 + scaledZoom));

                canvas.setColor(new Color(0x919191));
                /* top sidewalk */
                canvas.fillRect(0, (int) (420 + streetZoom), 
                                1280, (int) (20 + scaledZoom));
                /* bottom sidewalk */ 
                canvas.fillRect(0, (int) (630 + streetZoom), 
                                1280, (int) (40 + scaledZoom));
                
                canvas.setColor(new Color(0x383838));
                canvas.drawRect(0, (int) (420 + streetZoom), 
                                1280, (int) (20 + scaledZoom));
                canvas.drawRect(0, (int) (630 + streetZoom), 
                                1280, (int) (40 + scaledZoom));

                /* lines for sidewalk */
                canvas.setColor(new Color(0x4b4b4b));
                int topLineBottom = 450;
                int topXVal = 50;
                for (int i = 0; i < 25; i++) {
                        double scaleZoom = streetZoom * 1.5;
                        canvas.drawLine(topXVal, (int) (440 + scaleZoom), 
                                        topXVal, 
                                        (int) (topLineBottom + scaleZoom));
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

        public void changeLanes(Vehicle vehicle, boolean printChange) {
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

        public void addToLane(Vehicle vehicle, int lane) {
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

        public void removeVehicle(Vehicle vehicle, boolean isDamaged) {
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
                        msg = "The " + vehicle.name + 
                        " sustained significant damage and had to be towed";
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
        
        public void zoom() {
                scaleBackground();
                scaleVehicles();
                mainCanvas.repaint();
        }

        public void scaleBackground() {
                Image image = background1.getImage();
                int scaledWidth = (int) (image.getWidth(null) * zoom);
                int scaledHeight = (int) (image.getHeight(null) * zoom);
                int x = (image.getWidth(null) - scaledWidth) / 2;
                int y = (image.getHeight(null) - scaledHeight) / 2;

                background1.setX(x);                                
                background1.setY(y);
                background1.setWidth(scaledWidth);                                
                background1.setHeight(scaledHeight);
        }

        public void scaleVehicles() {
                for (Vehicle vehicle : vehiclesLeft) {
                        scaleVehiclesHelper(vehicle);
                }

                for (Vehicle vehicle : vehiclesMiddle) {
                        scaleVehiclesHelper(vehicle);
                }

                for (Vehicle vehicle : vehiclesRight) {
                        scaleVehiclesHelper(vehicle);
                }
        }

        public void scaleVehiclesHelper(Vehicle vehicle) {
                Image image = vehicle.getImage();
                double h = image.getHeight(null),
                       w = image.getWidth(null);
                double area = (w * vehicleZoom) * (h * vehicleZoom), 
                       ratio = (w * vehicleZoom) / (h * vehicleZoom);

                /* maintain aspect ratio */
                double scaledWidth = Math.sqrt(ratio * area);
                double scaledHeight = area / scaledWidth;

                double y = (streetZoom + laneVal[vehicle.lane]) + 
                            ((h - scaledHeight) / 20);

                vehicle.setWidth((int) scaledWidth);                                
                vehicle.setHeight((int) scaledHeight);         
                vehicle.setY((int) y);
        }
}