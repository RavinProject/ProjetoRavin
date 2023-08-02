package org.ravin.utils.exceptions;

public class DataIndisponivelException extends Exception {
    public DataIndisponivelException(String message) {
        super(message);
    }

    public DataIndisponivelException(String message, Throwable cause) {
        super(message, cause);
    }
}
