package com.experimentation.fullspringproject.application.rest;

import java.io.InvalidObjectException;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(InvalidObjectException.class)
  private ResponseEntity<ProblemDetail> handleInvalidObject(InvalidObjectException e) {
    var sw = new StringWriter();
    var pw = new PrintWriter(sw);
    e.printStackTrace(pw);

    var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(409), sw.toString());
    problemDetail.setTitle(e.getMessage());

    return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
  }
}
