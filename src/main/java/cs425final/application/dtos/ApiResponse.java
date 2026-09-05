package cs425final.application.dtos;

public class ApiResponse {
    private Boolean successful;
    private String message;

    public ApiResponse(Boolean successful, String message){
        this.successful = successful;
        this.message = message;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
