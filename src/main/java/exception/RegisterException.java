package exception;

public class RegisterException extends AppException {
    public RegisterException(String message) {
        super("Error with Registration!" + message);
    }
}
