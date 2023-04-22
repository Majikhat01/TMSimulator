package tm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

            //2nd line create sigma
            for (int i = 0; i < numSigma; i++) {
                tm.addSigma((char) i);
            }

            //transition will be parsed based on (sigma+1)*(states-1) / (states-1)
                //don't forget to check for too many/too little transitions
            for (int i = 0; i < numStates; i++) {
                for (int j = 0; j < (numSigma + 1); j++) {
                    String[] line = br.readLine().split(",");
                    String toState = line[0];
                    char readSym = (char) ('0'+j);
                    char writeSym = line[1].charAt(0);
                    char move = line[2].charAt(0);

                    tm.addTransition(Integer.toString(i), toState, readSym, writeSym, move);
                }
            }

            TMState currState = tm.getState("0");

            //read input string
            for (char character : br.readLine().toCharArray()) {
                char writeSymbol = currState.getWriteSymbol(character);
                character = writeSymbol;

            }


        } catch (IOException e) {
            e.printStackTrace();
        }







        //once parsed through everything the TM should be fully set up and ready to read the input string(tape)


    }
}
