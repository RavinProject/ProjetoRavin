package org.ravin.utils.exceptions;

public class MesaNaoDisponivelException extends Exception {
    public MesaNaoDisponivelException(String message) {
        super(message);
    }

    public MesaNaoDisponivelException(String message, Throwable cause) {
        super(message, cause);
    }
}
