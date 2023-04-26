* Project 3 / Turing Machine Simulator	
* CS361 - Section 2
* 04/21/23
* @Authors: Calvin Hatfield, Jaden Sims
**************************************************


OVERVIEW/HOW THE PROGRAM WORKS:*************************************************************************

The turing machine takes in a file that contains the data needed to run a simulation, such as the total 
number of states, the number of symbols, the defined transitions, and the input string. The TMSimulator.java 
does all the IO of the simulator, which includes all the parsing logic to break down the file into different 
parts, and using that for simulation and initialization. TM.java implements TMInterface.java which does all the logic
of the turing machine which consists of the adding of states, transitions, sigma, whether the TM accepts, etc.
TMState is an extension of a fa State.java class from previous projects, but was adjusted to work for a turing 
machine simulation. Tape.java implements TapeInterface.java which is a double linked list that uses
a list iterator to move left and right depending on the 'R' or 'L' read when simulating the transitions of the 
turing machine. When running a simulation on given file, the console should give messages as to what it is 
currently doing while running. This helps to show the user the state of the simulation.

INCLUDED FILES:******************************************************************************************


fa package:
FAInterface.java
State.java

tm package:
* Tape.java
* TapeInterface.java
* TM.java
* TMInterface.java
* TMSimulator.java
* TMState.java
* README


COMPILING AND RUNNING:***********************************************************************************


 To compile the files:
 $ javac tm.TMSimulator.java
 
 To run the files:
 $ java tm.TMSimulator.java < filename >
 
Ex: $ java tm.TMSimulator.java file0.txt

EXPECTED BEHAVIOR:***************************************************************************************


 When the TMSimulator.java is passed a file containing the correctly formatted turing machine inputs and the
simulator is run, it will begin to simulate the turing machine and tape. It should then output to the console
"States added" when it finishes loading the states, "sigma added" when the sigma is done loading, 
then "transitions added" once those are done loading. After which the Simulator should output to the console that
the simulation is "running" with a dot(.) showing up every few seconds to indicate that the simulation is still going.
Once the simulation is complete, it should send the output to the console, followed by the length of the output and the
sum of the symbols in the simulation.
