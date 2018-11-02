package com.nemo.identity.identity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Bad username or password")
public class BadLoginException extends RuntimeException {
}
