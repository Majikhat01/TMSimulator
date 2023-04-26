/**
 * This program is a Turing Machine simulator.
 * It takes in a file as an argument
 * The file contains the encoding of a turing machine and an input string
 * @Author Calvin Hatfield
 * @Author Jaden Smith
 */
package tm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class TMSimulator {

    //take in input string(fileName)
    public static void main(String[] args) {
        TMInterface tm = new TM();

        //parse the file
        try {
            BufferedReader br = new BufferedReader((new FileReader(args[0])));
            int numStates = Integer.parseInt(br.readLine());
            int numSigma = Integer.parseInt(br.readLine()) + 1;

            //1st line creates states
            for (int i = 0; i < numStates; i++) {
                tm.addState(Integer.toString(i));
            }

            //set the final state
            tm.setFinal(Integer.toString(numStates-1));

            //2nd line creates sigma
            for (int i = 0; i < numSigma; i++) {
                tm.addSigma((char) ('0' + i));
            }

            //decodes and adds the transitions to the states
            //transitions are parsed based on (sigma+1)*(states-1) / (states-1)
            for (int i = 0; i < numStates-1; i++) { //tracks the state
                for (int j = 0; j < (numSigma); j++) { //tracks the sigma
                    String[] line = br.readLine().split(",");
                    String toState = line[0];
                    char readSym = (char) ('0'+j);
                    char writeSym = line[1].charAt(0);
                    char move = line[2].charAt(0);

                    tm.addTransition(Integer.toString(i), toState, readSym, writeSym, move);
                }
            }

            //read input string
            String inputString = br.readLine();
            if (inputString == null) {
                inputString = "0";
            }

            //check if the input string is accepted by the TM
            if (tm.accepts(inputString)) {
                tm.readTape();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
