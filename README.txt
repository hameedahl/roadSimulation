##
## Assignment: Java6 Fall 2023
## Name: Hameedah Lawal 
## Email: hlawal01@tufts.edu
##

## PURPOSE
        > Mini highway simulation game; control/manage the highway and 
          avoid accidents

## USAGE
        > Compile with `javac Background.java CollisionDetection.java 
                        ScrollList.java Spinner.java Bike.java Controls.java 
                        Model.java SimButton.java StatePanel.java Canvas.java
                        DropDown.java PlayerButton.java SimControls.java
                        Vehicle.java Car.java Main.java PlayerControls.java
                        Slider.java
        > Run with `java Main`

## RULES OF SIMULATION
        > add as many cars as you can while still keeping the collision 
          count low (tip: use different lanes and speeds)
        > add new vehicles to the simulation——on the bottom left corner of the
          screen: pick a car, lane, and initial speed, then hit "add vehicle"
          (+500 points)
        > when a vehicle collides with another (-50 points), both cars take 
          "damage" and slow down until it eventually comes to a stop,
          and is removed (-10 points) from the simulation 
        > update vehicles in the simulation——click on a vehicle until you 
          see a red box around it (pause the simulation if needed); on the 
          bottom right corner of the screen change the speed, lane, or
          remove it (-10 points).
        > users can drive and change the speed and bike color 
          (planning on either removing the bike or adding more 
          functionality to it by next assignment because it doesn't do much
          at the moment)
        
## OBJECTS, INHERITANCES, AND HIERARCHY
        > Main (JFrame)
                > Model
                        > Vehicle
                                > Bike (Vehicle)
                                > Car (Vehicle)
                                > Background (Vehicle)
                        > CollisionDetection
                        > StatePanel (owned by Controls)
                        > Canvas
                > Canvas (JPanel)
                > Controls (JPanel)
                        > StatePanel (JPanel)
                                > JLabels
                > Controls (JPanel)
                        > SimControls (Controls)
                                > SimButton (Button)
                                        > Background (owned by Model)
                                > Slider (JSlider)
                                > DropDown (JComboBox)
                                > Spinner (JSpinner)
                                > ScrollList (JScrollPane)
                        > PlayerControls (Controls)
                                > PlayerButton (Button) 
                                        > Background (owned by Model)
                                > Slider (JSlider)
                                > ScrollList (JScrollPane)
                                
## CHANGELOG
        > 9/29/23 
                => created window, painted "sky" background and road
                => added control panel for driving, honking, braking, and 
                   changing lanes
        > 10/6/23 
                => organized/created classes——gave Main less to do
                => added border layout and moved control panel
                => created Bike class to store bike info like speed, color etc.
                => added different bike colors and images
                => added Menubar
                => added Button class; each button has an ID and an action 
                   listener to control simulation
                => added sidewalk and background
                => started driving animation
        > 10/13/23
                => lowered scale
                => added more lanes
                => created Vehicle and Model class
                => created Car and Background subclass and made Bike 
                   a subclass of Vehicle
                => added new vehicles to simulation
                => added scrolling background
        > 10/20/23
                => added simulation controls
                => new cars can be added to the simulation 
                => disabled/enabled buttons when interacted with
        > 10/29/23
                => added a state
                => removed cars that were original added at the start of the
                   simulation to leave creative control to users
                => added mouse picking——click on a vehicle to change its lane,
                   speed, or to remove it
                => added collision detection between vehicles
                => updated game rules (score is based on cars in simulation
                   and the number of collisions)
                => added a state panel that displays/keep tracks of the total
                   collisions, cars, and player score 