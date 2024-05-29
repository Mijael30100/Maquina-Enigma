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
                System.out.println(c);
                stepRotors();
                c = passThroughRotorsForward(c);
                System.out.println(c);
                c = reflector.reflect(c);
                System.out.println(c);
                c = passThroughRotorsBackward(c);
                System.out.println(c);
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    private void stepRotors() {
        System.out.println("Rotor positions before stepping: " + rotors[0].getPosition() + ", " + rotors[1].getPosition() + ", " + rotors[2].getPosition());
    
        if (rotors[1].atNotch() && rotors[0].atNotch() ) {
            rotors[2].step();
            System.out.println("Stepped rotor 3");
        }
        if (rotors[0].atNotch()) {
            rotors[1].step();
            System.out.println("Stepped rotor 2");
        }
        rotors[0].step();
        System.out.println("Stepped rotor 1");
    
        System.out.println("Rotor positions after stepping: " + rotors[0].getPosition() + ", " + rotors[1].getPosition() + ", " + rotors[2].getPosition());
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
