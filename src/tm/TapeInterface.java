package tm;

public interface TapeInterface {

    /**
     * moves the Tape one space to the left or right depending on
     * the character read from the tape
     * @param transition
     */
    void move(char transition);

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

    /**
     * prints the contents of the tape (visited sections of the tape) to the console
     */
    public void printTape();
}
