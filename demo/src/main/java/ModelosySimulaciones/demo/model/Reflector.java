package ModelosySimulaciones.demo.model;

public class Reflector {
    private char[] wiring;

    public Reflector(String wiring) {
        this.wiring = wiring.toCharArray();
    }

    public char reflect(char c) {
        int index = c - 'A';
        return wiring[index];
    }
}