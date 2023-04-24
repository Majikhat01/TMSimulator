package tm;

import fa.State;

import java.util.HashMap;
import java.util.Map;

public class TMState extends State {

    private Map<Character, Transition> transitions;

    boolean isStart;

    public TMState(String name) {

        super(name);
        transitions = new HashMap<>();
    }

    public void setStartState(boolean trueFalse) {
        isStart = trueFalse;
    }

    public boolean isStartState() { return isStart; }

    public Transition getTransition(char readSymbol) {
        return transitions.get(readSymbol);
    }

    public char getWriteSymbol(char readSymbol) {
        char writeSymbol = getTransition(readSymbol).writeSymbol;
        return writeSymbol;
    }

    public TMState getToState(char readSymbol) {
        if (transitions.containsKey(readSymbol)) {
            TMState returnState = getTransition(readSymbol).toState;
            return returnState;
        }
        return null;
    }

    public char getMoveSymbol(char readSymbol) {
        char moveSymbol = this.getTransition(readSymbol).moveSymbol;
        return moveSymbol;
    }

    public void addTransition(TMState nextState, char readSymbol, char writeSymbol, char moveSymbol) {
        char key = readSymbol;
        Transition value = new Transition(nextState, writeSymbol, moveSymbol);

        transitions.put(key, value);
    }

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
