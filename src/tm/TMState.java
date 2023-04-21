package tm;

import fa.State;

import java.util.HashMap;
import java.util.Map;

public class TMState extends State {

    private Map<Character, Transition> transitions = new HashMap<>();

    boolean isStart;

    public TMState(String name) {

        super(name);
        transitions = new HashMap<>();
    }

    public void setStartState(boolean trueFalse) {
        isStart = trueFalse;
    }

    public boolean isStartState() {
        return isStart;
    }

    private static class Transition {
        private TMState toState;
        private char writeSymbol;
        private char moveSymbol;

        public void addTransition(TMState nextState, char writeSymbol, char moveSymbol) {
            this.toState = nextState;
            this.writeSymbol = writeSymbol;
            this.moveSymbol = moveSymbol;
        }
    }
}
