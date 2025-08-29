package com.example.demo.book;

public class BookNotFoundExecption extends RuntimeException{
   public BookNotFoundExecption(Long id){
    super("Book not found: "+ id);
   }
}
