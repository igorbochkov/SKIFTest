package exception;

public class ElementAlreadyExistException extends RuntimeException {

    public ElementAlreadyExistException(String message) {
        super(message);
    }
}
