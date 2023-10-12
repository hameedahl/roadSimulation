##
## Assignment: Java3 Fall 2023
## Name: Hameedah Lawal 
## Email: hlawal01@tufts.edu
##

## PURPOSE
        > Creates a window with a canvas containing the background and bike 
          needed for the simulation, a control panel at the bottom which
          will be used to control components in the scene, and a menubar 
          (no functionality at the moment).

## USAGE
        > Compile with `javac Main.java Bike.java Button.java Canvas.java 
                        Controls.java MenuBar.java`
        > Run with `java Main`

## RULES OF SIMULATION
        > At the moment, there aren't any rules, users can drive and change 
          the speed and bike color

## OBJECTS, INHERITANCES, AND HIERARCHY
        > Main (JFrame)
                > Canvas (JPanel)
                        > Bike 
                > Controls (JPanel)
                        > Button (JButton)
                                > Bike (owned by Canvas)

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
                => created 