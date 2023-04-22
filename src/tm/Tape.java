package tm;

import java.util.LinkedList;
import java.util.ListIterator;

public class Tape implements TapeInterface {
//    private int Capacity;
//    private int startingIndex;
    ListIterator<Character> tapeIterator;
    LinkedList<Character> Tape;

    public ListIterator<Character> listIterator(int startingIndex) {
        return listIterator(startingIndex);
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
        return 0;
    }

    @Override
    public void writeSymbol(char symbol) {

    }

    //Need to add a way to add new nodes to te list when the max size is reached

    //public void reset();

    //public String toString();
}
