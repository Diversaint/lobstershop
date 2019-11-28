package exception;

public class CartException extends AppException {
    public CartException(String message) {
        super("Cart error" + message);
    }
}
