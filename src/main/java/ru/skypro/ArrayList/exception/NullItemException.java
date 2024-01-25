package ru.skypro.ArrayList.exception;

public class NullItemException extends RuntimeException {
    public NullItemException() {
    }
    public NullItemException(String message) {
        super (message);
    }

    public NullItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullItemException(Throwable cause) {
        super(cause);
    }

    public NullItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStrackTrace) {
        super (message, cause, enableSuppression, writableStrackTrace);
    }
}
