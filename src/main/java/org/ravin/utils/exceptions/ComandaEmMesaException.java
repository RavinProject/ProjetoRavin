package org.ravin.utils.exceptions;

public class ComandaEmMesaException extends Exception {
    public ComandaEmMesaException(String message) {
        super(message);
    }

    public ComandaEmMesaException(String message, Throwable cause) {
        super(message, cause);
    }
}
