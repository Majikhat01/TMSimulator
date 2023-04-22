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

    public void addSymbol(char symbol) {
        ListIterator.add(symbol);
    }

    public void moveLeft(char transition) {
        ListIterator.previous();
    }

    public void moveRight(char transition) {
        ListIterator.next();
    }

    public char readSymbol() {
        return 0;
    }

    public void writeSymbol(char symbol) {

    }

    //Need to add a way to add new nodes to te list when the max size is reached

    //public void reset();

    //public String toString();
}
