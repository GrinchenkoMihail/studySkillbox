package myExeption;

public class NotValidPhoneException extends RuntimeException {
    public NotValidPhoneException(String message) {
        super(message);
    }

}
