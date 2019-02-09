# Nixie-Pi-Clock
Java code for a nixie tube clock built with a Raspberry Pi Zero W  

# Installation Instructions
1: Transfer NixiePieClock.jar to the docuents folder of your Raspberry Pi  
2: Type "sudo crontab -e" into a new terminal  
3:If it asks which editor to use, select "nano"  
4: Scroll to the very bottom of the document using the arrow keys   
5: add the following to the very bottom of the document  
@reboot sudo java -jar "home/pi/Documents/NixiePieClock.jar"  
6: Press the following keys in order to exit and save the document  
Ctrl + X  
Y  
Enter  
7: connect your multimeter to pins 34 and 38 on your pi  
(use this page for help http://pi4j.com/pins/model-zerow-rev1.html)  
8: if the pins are alternating between 3.5V and 0V, you have set up the program correctly
