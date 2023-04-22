package tm;

import fa.FAInterface;
import fa.State;

import java.util.Set;

public interface TMInterface extends FAInterface {


    @Override
    public TMState getState(String name);

    /**
     * Adds the transition to the TM's delta data structure
     * @param fromState is the label of the state where the transition starts
     * @param toState is the label of the state where the transition ends
     * @param writeSym is the symbol to write to the tape
     * @param move is the direction the tape will move
     * @return true if successful and false if one of the states don't exist or the symbol in not in the alphabet
     */
    public  boolean addTransition(String fromState, String toState,char readSym, char writeSym, char move);

}
