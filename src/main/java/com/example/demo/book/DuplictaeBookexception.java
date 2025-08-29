package com.example.demo.book;

public class DuplictaeBookexception extends RuntimeException{
    public DuplictaeBookexception(String title,String author){
        super("Book already exists: " + title + " by " + author);
    }
}
