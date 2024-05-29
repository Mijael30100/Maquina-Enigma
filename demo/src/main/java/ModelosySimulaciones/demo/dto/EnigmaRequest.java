package ModelosySimulaciones.demo.dto;

public class EnigmaRequest {
    private String rotor1Letter;
    private String rotor2Letter;
    private String rotor3Letter;

    // Constructor vacío
    public EnigmaRequest() {}

    public EnigmaRequest(String rotor1Letter, String rotor2Letter, String rotor3Letter) {
        this.rotor1Letter = rotor1Letter;
        this.rotor2Letter = rotor2Letter;
        this.rotor3Letter = rotor3Letter;
    }

    public String getRotor1Letter() {
        return this.rotor1Letter;
    }

    public void setRotor1Letter(String rotor1Letter) {
        this.rotor1Letter = rotor1Letter;
    }

    public String getRotor2Letter() {
        return this.rotor2Letter;
    }

    public void setRotor2Letter(String rotor2Letter) {
        this.rotor2Letter = rotor2Letter;
    }

    public String getRotor3Letter() {
        return this.rotor3Letter;
    }

    public void setRotor3Letter(String rotor3Letter) {
        this.rotor3Letter = rotor3Letter;
    }
}
