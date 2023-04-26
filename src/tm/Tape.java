/**
 * This class creates and maintains the tape of a Turing Machine
 * @Author Calvin Hatfield
 * @Author Jaden Smith
 */
package tm;

import java.util.LinkedList;
import java.util.ListIterator;

public class Tape implements TapeInterface { //Initializing the tapeIterator, and tape
    private ListIterator<Character> tapeIterator;
    private LinkedList<Character> tape;

    //Making a new Tape LinkedList which has a listIterator to traverse the list in both directions
    public Tape(String s) {
        tape = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            tape.add(s.charAt(i));
        }
        tapeIterator = tape.listIterator();
    }

    @Override
    public void move(char transition) {

        //checks for direction and adds '0' if it's at the end of the tape
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

    @Override
    public void printTape() {
        int sum = 0;
        for (int i = 0; i < tape.size(); i++) {
            System.out.print(tape.get(i));
            sum = sum + Character.getNumericValue(tape.get(i));
        }
        System.out.println();
        //System.out.println(tape.size()); //uncomment if you wish to see the tape size
        //System.out.println(sum); //uncomment if you wish to see the sum of all elements of the tape
    }
}
