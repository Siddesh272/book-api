package com.example.demo.book;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private final Map<Long,Book> store=new ConcurrentHashMap<>();
    private final AtomicLong seq=new AtomicLong(0);

    public List<Book> findAll(){
        return new ArrayList<>(store.values());
    }
    public Optional<Book> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }
    public Book save(Book book){
        if(book.getId()==null){book.setId(seq.incrementAndGet());}
        store.put(book.getId(), book);
        return book;
    }
    public boolean deleteById(Long id){ return store.remove(id)!=null;}
    public boolean existsByTitleAuthor(String title,String author){
        return store.values().stream().anyMatch(b->b.getTitle().equalsIgnoreCase(title)
                && b.getAuthor().equalsIgnoreCase(author));
    }
    
}
