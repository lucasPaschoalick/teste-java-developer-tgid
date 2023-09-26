package br.com.tgid.teste.exception;

public class InvalidCompanyException extends RuntimeException {
    public InvalidCompanyException(String message) {
        super(message);
    }
}
