# CovidVaccineSlotChecker

This is JAVA project built with the help of JAVA Swings for GUI interface to check the Covid vaccination available slots across Karnataka for different districts. This program hits the coWin slots/availability API and the data is formatted according to the need. 

This app just checks the slot and provides an alert if it is available. Once it is available, please log in to https://selfregistration.cowin.gov.in/ and book the slots.

# Tech Stack
 - JAVA 11
 - REST Assured is used to interact with API's
 - Apache Maven for build and dependency management
 - JAVA Swings for GUI interface

# How to Use this ?

 - Need to install JAVA in your system
 - Clone this project to your local to make any changes or to access the code.
 - Run the file CovidVaccineSlotChecker.java
 - Download the CovidVaccineSlotChecker.jar file and execute it.

# Runs on:
 - Windows latest version
 - MAC OS
 - Linux OS
 
 # How it works ?
  - When the .jar is file is executed or .java classfile is run, a GUI interface will be opened.
  - Select the three inputs to run the script.
     - Select District: Filter the districts
     ![CovidVaccineSlotChecker](https://github.com/sriharshab88/CovidVaccineSlotChecker/blob/master/src/test/resources/GUI_1.png)
    
    - Time interval: Time gap (seconds) between each iteration
     
     - Iterations: Number of iterations to run
     ![CovidVaccineSlotChecker](https://github.com/sriharshab88/CovidVaccineSlotChecker/blob/master/src/test/resources/GUI_2.png)

(These checks are done to avoid the rate limiting which is for ~100 requests in 5 minutes per IP)
  
  - Click on 'Run' button the API's will be hit and the available slots are listed with a beep for each iteration.
  ![CovidVaccineSlotChecker](https://github.com/sriharshab88/CovidVaccineSlotChecker/blob/master/src/test/resources/GUI_3.png)
 
 - If the vaccination slots are not available, then a message is shown in the console.
  ![CovidVaccineSlotChecker](https://github.com/sriharshab88/CovidVaccineSlotChecker/blob/master/src/test/resources/GUI_4.png)
  
 # Contact for any queries or clarifications:
 Email: sriharsha.b.88@gmail.com
