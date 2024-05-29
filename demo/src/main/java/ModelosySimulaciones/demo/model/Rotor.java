package ModelosySimulaciones.demo.model;

public class Rotor {
    private char[] wiring;
    private int position;

    public char[] getWiring() {
        return this.wiring;
    }

    public void setWiring(char[] wiring) {
        this.wiring = wiring;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public char getNotch() {
        return this.notch;
    }

    public void setNotch(char notch) {
        this.notch = notch;
    }
    private char notch;

    public Rotor(String wiring, char notch) {
        this.wiring = wiring.toCharArray();
        this.notch = notch;
        this.position = 0;
    }

    public boolean atNotch() {
        return wiring[position] == notch;
    }

    public void step() {
        this.position = (this.position + 1) % 26;
    }

    public char forward(char c) {
        int index = (c - 'A' + position) % 26;
        return wiring[index];
    }

    public char backward(char c) {
        int index = (c - 'A' - position + 26) % 26;
        for (int i = 0; i < 26; i++) {
            if (wiring[i] == (char) ('A' + index)) {
                return (char) (i + 'A');
            }
        }
        return c; // Default case (should not happen ideally)
    }
}
