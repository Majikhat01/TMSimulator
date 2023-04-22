package tm;

import java.util.LinkedList;
import java.util.ListIterator;

public class Tape implements TapeInterface {
    ListIterator<Character> tapeIterator;
    LinkedList<Character> Tape;

    public Tape() {
        Tape = new LinkedList();
        tapeIterator = Tape.listIterator();
    }

    @Override
    public void addSymbol(char symbol) {
        tapeIterator.add(symbol);
    }

    @Override
    public void move(char transition) {
        if (transition == 'R') {
            tapeIterator.next();
        } else if (transition == 'L') {
            tapeIterator.previous();
        }
    }

    @Override
    public char readSymbol() {
        return tapeIterator.next();
    }

    @Override
    public void writeSymbol(char symbol) {
        tapeIterator.set(symbol);
    }

    //Need to add a way to add to the list when the max size is reached(not sure what josh really meant here)
    //Should only add a blank(0) to the list if there is a transition being read but no symbol.
    public void addBlank(char transition) {
        if (transition == 'R'); {
            if(!tapeIterator.hasNext()) {
                Tape.add('0');
            }
        }
        if (transition == 'L'); {
            if(!tapeIterator.hasNext()) {
                Tape.add('0');
            }
        }
    }


    //public String toString(); //Probably not needed other than for debugging
}
