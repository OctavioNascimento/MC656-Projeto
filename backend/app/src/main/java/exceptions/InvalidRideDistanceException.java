package exceptions;

public class InvalidRideDistanceException extends RuntimeException {
    public InvalidRideDistanceException() {
        super("Distância da corrida inválida. A distância deve ser maior que zero.");
    }

    public InvalidRideDistanceException(String message) {
        super(message);
    }

    public InvalidRideDistanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRideDistanceException(Throwable cause) {
        super(cause);
    }
}