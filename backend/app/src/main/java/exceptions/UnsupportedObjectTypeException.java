package exceptions;

public class UnsupportedObjectTypeException extends RuntimeException {
    public UnsupportedObjectTypeException() {
        super("Tipo de objeto não suportado.");
    }
}