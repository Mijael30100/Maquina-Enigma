package ModelosySimulaciones.demo.service;

import org.springframework.stereotype.Service;
import ModelosySimulaciones.demo.model.EnigmaMachine;
import ModelosySimulaciones.demo.model.Reflector;
import ModelosySimulaciones.demo.model.Rotor;

@Service
public class EnigmaService {

    private EnigmaMachine enigmaMachine;

    public EnigmaService() {
        // Constructor vacío
    }

    public boolean configureRotors(String rotor1Letter, String rotor2Letter, String rotor3Letter) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int index1 = alphabet.indexOf(rotor1Letter.toUpperCase());
        int index2 = alphabet.indexOf(rotor2Letter.toUpperCase());
        int index3 = alphabet.indexOf(rotor3Letter.toUpperCase());

        String rotor1s = alphabet.substring(index1) + alphabet.substring(0, index1);
        String rotor2s = alphabet.substring(index2) + alphabet.substring(0, index2);
        String rotor3s = alphabet.substring(index3) + alphabet.substring(0, index3);

        Rotor rotor1 = new Rotor(rotor1s, 'Q');
        Rotor rotor2 = new Rotor(rotor2s, 'E');
        Rotor rotor3 = new Rotor(rotor3s, 'V');
            
        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
        enigmaMachine = new EnigmaMachine(new Rotor[]{rotor1, rotor2, rotor3}, reflector);
            
        return true;
    }

    public String encrypt(String plaintext) {
        return enigmaMachine.encrypt(plaintext);
    }

    public String decrypt(String ciphertext) {
        return enigmaMachine.encrypt(ciphertext);  // Enigma es simétrica
    }
}
