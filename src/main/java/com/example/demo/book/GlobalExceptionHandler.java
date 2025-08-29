package com.example.demo.book;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(BookNotFoundExecption.class)
    public ResponseEntity<ApiError> handleNotFound(BookNotFoundExecption ex,HttpServletRequest req){
      ApiError err=new ApiError(HttpStatus.NOT_FOUND.value(),"Not Found",ex.getMessage(),req.getRequestURI());
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    
    @ExceptionHandler(DuplictaeBookexception.class)
    public ResponseEntity<ApiError> handleDuplictae(DuplictaeBookexception ex,HttpServletRequest req){
      ApiError err=new ApiError(HttpStatus.CONFLICT.value(),"Conflict",ex.getMessage(),req.getRequestURI());
      return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
    }
    
}
