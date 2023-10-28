##
## Assignment: Java5 Fall 2023
## Name: Hameedah Lawal 
## Email: hlawal01@tufts.edu
##

## PURPOSE
        > Creates a window with a canvas containing the background, the player
          (the bike), other types of vehicles needed for the simulation, and a 
          control panel at the bottom which can be used to control components 
          in the scene.

## USAGE
        > Compile with `javac Background.java Controls.java Model.java 
                        SimControls.java Bike.java DropDown.java 
                        PlayerButton.java Slider.java Canvas.java Main.java
                        PlayerControls.java Spinner.java Car.java MenuBar.java
                        SimButton.java Vehicle.java`
        > Run with `java Main`

## RULES OF SIMULATION
        > users can drive and change the speed and bike color
        > add new vehicles to the simulation by picking a car, lane, and
          initial speed, then hit "add vehicle"

## OBJECTS, INHERITANCES, AND HIERARCHY
        > Main (JFrame)
                > Model
                        > Vehicle
                                > Bike (Vehicle)
                                > Car (Vehicle)
                                > Background (Vehicle)
                > Canvas (JPanel)
                > Controls (JPanel)
                        > SimControls (Controls)
                                > SimButton (Button)
                                        > Background (owned by Model)
                                > Slider (JSlider)
                                > DropDown (JComboBox)
                                > Spinner (JSpinner)
                        > PlayerControls (Controls)
                                > PlayerButton (Button) 
                                        > Background (owned by Model)
                                > Slider (JSlider)
                                
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