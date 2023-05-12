package nl.rowendu.beerservice.web.controller;

/**
 * Created by ronlangeveld on 12/05/2023
 */

public record ErrorResponse(int status, String message) {
    public ErrorResponse {
        if (status < 400 || status >= 600) {
            throw new IllegalArgumentException("Invalid HTTP status code");
        }
    }
}

