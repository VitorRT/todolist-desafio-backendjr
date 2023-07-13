package br.com.vitorbarberino.desafiotodolist.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public record RestNotValidException(
    String field, String message
) { }
