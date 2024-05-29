package ModelosySimulaciones.demo.dto;

public class EnigmaResponse {
    private boolean success;

    public EnigmaResponse() {}

    public EnigmaResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
