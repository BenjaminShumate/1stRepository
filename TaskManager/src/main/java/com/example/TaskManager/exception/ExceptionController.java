package com.example.TaskManager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
   @ExceptionHandler(value = UserNotFound.class)
   public ResponseEntity<Object> exception(UserNotFound exception) {
      return new ResponseEntity<>("<h1><font color=\"red\">The user does not exist.</font></h1><a href=\"login\">Click here to return to the login menu</a>", HttpStatus.NOT_FOUND);
   }
}
