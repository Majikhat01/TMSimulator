package tm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TMSimulator {

    //take in input string(fileName)
    public static void main(String[] args) {
        TM tm = new TM();

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
                tm.addSigma((Character) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





        //transition will be parsed based on (sigma+1)*(states-1) / (states-1)
            //don't forget to check for too many/too little transitions


        //once parsed through everything the TM should be fully set up and ready to read the input string(tape)


    }
}
