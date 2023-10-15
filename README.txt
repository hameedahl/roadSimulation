##
## Assignment: Java4 Fall 2023
## Name: Hameedah Lawal 
## Email: hlawal01@tufts.edu
##

## PURPOSE
        > Creates a window with a canvas containing the background, the player
          (the bike), other types of vehicles needed for the simulation, and a 
          control panel at the bottom which can be used to control components 
          in the scene.

## USAGE
        > Compile with `javac Main.java Bike.java Button.java Canvas.java 
                        Controls.java MenuBar.java Model.java Background.java
                        Vehicle.java`
        > Run with `java Main`

## RULES OF SIMULATION
        > At the moment, there aren't any rules, users can drive and change 
          the speed and bike color

## OBJECTS, INHERITANCES, AND HIERARCHY
        > Main (JFrame)
                > Model
                        > Vehicle
                                > Bike (Vehicle)
                                > Car (Vehicle)
                        > Background (Vehicle)
                > Canvas (JPanel)
                > Controls (JPanel)
                        > Button (JButton)
                                > Background (owned by Model)

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
                =>