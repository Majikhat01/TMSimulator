package tm;

import java.util.LinkedList;
import java.util.ListIterator;

public class Tape implements TapeInterface {
    private ListIterator<Character> tapeIterator;
    private LinkedList<Character> tape;

    public Tape(String s) {
        tape = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            tape.add(s.charAt(i));
        }
        tapeIterator = tape.listIterator();
    }

    @Override
    public void addSymbol(char symbol) {
        tapeIterator.add(symbol);
    }

    @Override
    public void move(char transition) {
        if (transition == 'R') {
            if (tapeIterator.hasNext()) {
                tapeIterator.next();
                if (!tapeIterator.hasNext()) {
                    tapeIterator.add('0');
                }
            } else {
                tapeIterator.add('0');
            }
        } else if (transition == 'L') {
            if (tapeIterator.hasPrevious()) {
                tapeIterator.previous();
                if (!tapeIterator.hasPrevious()) {
                    tapeIterator.add('0');
                    tapeIterator.previous();
                }
            } else {
                tapeIterator.add('0');
                tapeIterator.previous();
                if (!tapeIterator.hasPrevious()) {
                    tapeIterator.add('0');
                    tapeIterator.previous();
                }
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

    //Need to add a way to add to the list when the max size is reached(not sure what josh really meant here)
    //Should only add a blank(0) to the list if there is a transition being read but no symbol.
    public void addBlank(char transition) {
        if (transition == 'R'); {
            if(!tapeIterator.hasNext()) {
                tape.add('0');
            }
        }
        if (transition == 'L'); {
            if(!tapeIterator.hasPrevious()) {
                tape.addFirst('0');
            }
        }
    }


    //public String toString(); //Probably not needed other than for debugging
}
