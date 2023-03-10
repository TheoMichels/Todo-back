package fr.its4u.todo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends Exception {

    public TaskNotFoundException() {
        super(ErrorMessages.TASK_NOT_FOUND);
    }
}
