package ModelosySimulaciones.demo.model;

public class EnigmaMachine {
    private Rotor[] rotors;
    private Reflector reflector;

    public EnigmaMachine(Rotor[] rotors, Reflector reflector) {
        this.rotors = rotors;
        this.reflector = reflector;
    }

    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toUpperCase(c);
                stepRotors();
                c = passThroughRotorsForward(c);
                c = reflector.reflect(c);
                c = passThroughRotorsBackward(c);
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    private void stepRotors() {    
        if (rotors[1].atNotch() && rotors[0].atNotch() ) {
            rotors[2].step();
        }
        if (rotors[0].atNotch()) {
            rotors[1].step();
        }
        rotors[0].step();
        }
    

    private char passThroughRotorsForward(char c) {
        for (Rotor rotor : rotors) {
            c = rotor.forward(c);
        }
        return c;
    }

    private char passThroughRotorsBackward(char c) {
        for (int i = rotors.length - 1; i >= 0; i--) {
            c = rotors[i].backward(c);
        }
        return c;
    }
}
