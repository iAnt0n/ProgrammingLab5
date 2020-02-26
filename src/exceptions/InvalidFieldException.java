package exceptions;

/**
 * Исключение, обозначающее наличие полей в классе, несоответствующих условиям
 */
public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException(String message) {
        super(message);
    }
}
