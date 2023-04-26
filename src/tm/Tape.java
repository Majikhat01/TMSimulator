package tm;

import java.util.LinkedList;
import java.util.ListIterator;

public class Tape implements TapeInterface { //Initializing the tapeIterator, and tape
    private ListIterator<Character> tapeIterator;
    private LinkedList<Character> tape;

    /**
     * Adds a symbol to the list.
     * @param s is string passed
     */
    public Tape(String s) { //Making a new Tape LinkedList which has a listIterator to traverse the list in both directions
        tape = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            tape.add(s.charAt(i));
        }
        tapeIterator = tape.listIterator();
    }
    /**
     * Adds a symbol to the list.
     * @param symbol is the symbol the TM will add to the Tape list
     */
    @Override
    public void addSymbol(char symbol) { //
        tapeIterator.add(symbol);
    }

    @Override
    public void move(char transition) {
        if (transition == 'R') {
            if (tapeIterator.hasNext()) {
                tapeIterator.next();
                if (!tapeIterator.hasNext()) {
                    tapeIterator.add('0');
                    tapeIterator.previous();
                }
            } else {
                tapeIterator.add('0');
            }
        } else if (transition == 'L') {
            if (!tapeIterator.hasPrevious()) {
                tapeIterator.add('0');
                tapeIterator.previous();
            } else {
                tapeIterator.previous();
            }
        }
    }

    @Override
    public char readSymbol() {
        if (!tapeIterator.hasNext()) {
            tapeIterator.previous();
            return tapeIterator.next();
        } else {
            tapeIterator.next();
            return tapeIterator.previous();
        }
    }

    @Override
    public void writeSymbol(char symbol) {
        tapeIterator.set(symbol);
    }

    public void printTape() {
        int sum = 0;
        for (int i = 0; i < tape.size(); i++) {
            System.out.print(tape.get(i));
            sum = sum + Character.getNumericValue(tape.get(i));
        }
        System.out.println();
        System.out.println(tape.size());
        System.out.println(sum);
    }
}
