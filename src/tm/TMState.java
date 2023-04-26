/**
 * This class creates and maintains a Turing Machine state
 * @Author Calvin Hatfield
 * @Author Jaden Smith
 */
package tm;

import fa.State;

import java.util.HashMap;
import java.util.Map;

public class TMState extends State {

    private Map<Character, Transition> transitions;

    //constructor
    public TMState(String name) {
        super(name);
        transitions = new HashMap<>();
    }

    /**
     * returns the transition information as an object
     * @param readSymbol the sigma symbol of the transition needed
     * @return Transition object
     */
    public Transition getTransition(char readSymbol) {
        return transitions.get(readSymbol);
    }

    /**
     * gets the write symbol of a transition
     * @param readSymbol the sigma symbol of the transition needed
     * @return the char to write to the tape
     */
    public char getWriteSymbol(char readSymbol) {
        char writeSymbol = getTransition(readSymbol).writeSymbol;
        return writeSymbol;
    }

    /**
     * gets the next state to go to in a transition
     * @param readSymbol the sigma symbol of the transition needed
     * @return the next state to go to in a transition
     */
    public TMState getToState(char readSymbol) {
        if (transitions.containsKey(readSymbol)) {
            TMState returnState = getTransition(readSymbol).toState;
            return returnState;
        }
        return null;
    }

    /**
     * gets the direction to move the head on the tape of a transition
     * @param readSymbol the sigma symbol of the transition needed
     * @return the direction to move the head as a char
     */
    public char getMoveSymbol(char readSymbol) {
        char moveSymbol = this.getTransition(readSymbol).moveSymbol;
        return moveSymbol;
    }

    /**
     * adds a transition to the state
     * @param nextState the next state to go to on the transition
     * @param readSymbol the sigma symbol that needs to be read in order to make the transition
     * @param writeSymbol the sigma symbol to write on the transition
     * @param moveSymbol the direction to move the head on the tape on the transition
     */
    public void addTransition(TMState nextState, char readSymbol, char writeSymbol, char moveSymbol) {
        char key = readSymbol;
        Transition value = new Transition(nextState, writeSymbol, moveSymbol);

        transitions.put(key, value);
    }

    /**
     * A transition class used to maintain transition objects
     */
    public static class Transition {
        private TMState toState;
        private char writeSymbol;
        private char moveSymbol;

        public Transition(TMState nextState, char writeSymbol, char moveSymbol) {
            this.toState = nextState;
            this.writeSymbol = writeSymbol;
            this.moveSymbol = moveSymbol;
        }
    }
}
