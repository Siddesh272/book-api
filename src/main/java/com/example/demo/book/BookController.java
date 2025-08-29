package com.example.demo.book;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService svc;
    public BookController(BookService svc){this.svc=svc;}
    
    @GetMapping
    public List<BookResponse> list(){return svc.list();}
    
    @GetMapping("/{id}")
    public BookResponse get(@PathVariable Long id){return svc.get(id);}
    
    @PostMapping
    public ResponseEntity<BookResponse> create(@Valid @RequestBody BookRequest req){
        BookResponse created=svc.create(req);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public BookResponse update(@PathVariable Long id,@Valid @RequestBody BookRequest req){return svc.update(id, req);}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
