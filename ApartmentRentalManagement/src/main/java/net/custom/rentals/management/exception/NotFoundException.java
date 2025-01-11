package net.custom.rentals.management.exception;

// exception case for when an entity was not found in the db
public class NotFoundException extends CustomException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
