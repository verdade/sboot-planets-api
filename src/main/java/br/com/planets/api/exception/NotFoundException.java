package br.com.planets.api.exception;

public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NotFoundException(String id) {
        super(id);
    }
}
