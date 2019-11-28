package exception;

public class InvalidPathException extends AppException{
    public InvalidPathException(String message) {
        super("Error with Path!" + message);
    }
}
