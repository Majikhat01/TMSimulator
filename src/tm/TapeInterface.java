package tm;

import java.util.ListIterator;

public interface TapeInterface {

    /**
     * adds a symbol from the input string to the Tape
     * @param symbol the symbol to add to the tape
     */
    public void addSymbol(char symbol);

    /**
     * moves the Tape one space to the left
     * @param transition
     */
    public void moveLeft(char transition);

    /**
     * moves the Tape one space to the right
     * @param transition
     */
    public void moveRight(char transition);

    /**
     * reads the symbol under the tape head
     * @return the character read
     */
    public char readSymbol();

    /**
     * writes a symbol to the tape, replacing the current symbol
     * @param symbol the symbol to be written
     */
    public void writeSymbol(char symbol);
}
