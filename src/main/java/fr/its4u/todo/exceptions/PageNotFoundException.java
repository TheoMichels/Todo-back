package fr.its4u.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PageNotFoundException extends Exception {

    public PageNotFoundException() {
        super(ErrorMessages.PAGE_NOT_FOUND);
    }
}
