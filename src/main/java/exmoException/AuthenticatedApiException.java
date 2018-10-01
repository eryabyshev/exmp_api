package exmoException;

public class AuthenticatedApiException extends Exception {
    public AuthenticatedApiException(String errorMessage){
        super(errorMessage);
    }
}
