package tm;

import java.util.HashSet;
import java.util.Set;

public class TM implements TMInterface{

    private Set<TMState> states;
    private Set<TMState> finalStates;
    private Set<Character> sigma;
    private Tape tmTape;

    //Constructor
    public TM() {
        states = new HashSet<>();
        finalStates = new HashSet<>();
        sigma = new HashSet<>();
    }

    //public methods
    @Override
    public boolean addState(String name) {
        for (TMState state : states) {
            if (state.getName().equals(name)) {
                return false;
            }
        }

        states.add(new TMState(name));
        return true;
    }

    @Override
    public boolean setFinal(String name) {
        boolean added = false;

        for (TMState state : states) {
            if (state.getName().equals(name)) {
                finalStates.add(state);
                added = true;
            }
        }

        return added;
    }

    @Override
    public boolean setStart(String name) {
        boolean startSet = false;

        if (states.contains(getState(name))) {

            for (TMState state : states) {
                if (state.isStart) {
                    state.setStartState(false);
                }
            }

            for (TMState state : states) {
                if (state.getName().equals(name)) {
                    state.setStartState(true);
                    startSet = true;
                }
            }
        }

        return startSet;
    }

    @Override
    public void addSigma(char symbol) { sigma.add(symbol); }

    @Override
    public boolean accepts(String s) {

        boolean doesAccept = false;
        tmTape = new Tape(s);

        TMState currState = this.getState("0");


        //input is the string of the tape, accepts takes the string and passes it to TapeInterface.java
        while (!finalStates.contains(currState)) {
            char readSymbol = tmTape.readSymbol();

            if (currState.getToState(readSymbol) == null) {
                return false;
            } else {
                char writeSymbol = currState.getWriteSymbol(readSymbol);
                char move = currState.getMoveSymbol(readSymbol);
                currState = currState.getToState(readSymbol);
                tmTape.writeSymbol(writeSymbol);
                tmTape.move(move);
            }
        }

        if (isFinal(currState.getName())) {
            doesAccept = true;
        }

        return doesAccept;
    }

    @Override
    public Set<Character> getSigma() {
        Set<Character> returnSigma = new HashSet<>(sigma);
        return returnSigma;
    }

    @Override
    public TMState getState(String name) {
        for (TMState state : states) {
            if (state.getName().equals(name)) {
                return state;
            }
        }

        return null;
    }

    @Override
    public boolean addTransition(String fromState, String toState, char readSym, char writeSym, char move) {
        if (getState(fromState) == null) {
            return false;
        } else if (getState(toState) == null) {
            return false;
        } else if (!sigma.contains(readSym)){
            return false;
        } else if (!sigma.contains(writeSym)) {
            return false;
        } else if (move == 'R' || move == 'L') {
            getState(fromState).addTransition(getState(toState), readSym, writeSym, move);
            return true;
        }
        return false;
    }

    @Override
    public String readTape() {
        String returnString = null;
        returnString = tmTape.toString();
        return returnString;
    }

    @Override
    public boolean isFinal(String name) {
        boolean isAFinal = false;

        for (TMState state : finalStates) {
            if (state.getName().equals(name)) {
                isAFinal = true;
                break;
            }
        }

        return isAFinal;
    }

    @Override
    public boolean isStart(String name) {
        boolean isTheStart = false;

        for (TMState state: states) {
            if (state.isStartState() && state.getName().equals(name)) {
                isTheStart = true;
                break;
            }
        }

        return isTheStart;
    }



}
