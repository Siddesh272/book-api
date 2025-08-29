package com.example.demo.book;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<BookResponse> list(){
        return repo.findAll().stream()
               .map(b->new BookResponse(b.getId(),b.getTitle(),b.getAuthor(),b.getPrice()))
               .toList();
    }
    public BookResponse get(Long id){
        Book b=repo.findById(id)
               .orElseThrow(()->new BookNotFoundExecption(id));
        return new BookResponse(b.getId(),b.getTitle(),b.getAuthor(),b.getPrice());
    }
    public BookResponse create(BookRequest req){
        if(repo.existsByTitleAuthor(req.getTitle(), req.getAuthor())){
            throw new DuplictaeBookexception(req.getTitle(), req.getAuthor());
        }
        Book saved=repo.save(new Book(null,req.getTitle(),req.getAuthor(),req.getPrice()));
        return new BookResponse(saved.getId(),saved.getTitle(),saved.getAuthor(),saved.getPrice());
    }
    public BookResponse update(long id,BookRequest req){
        Book exist=repo.findById(id).orElseThrow(()->new BookNotFoundExecption(id));
        exist.setTitle(req.getTitle());
        exist.setAuthor(req.getAuthor());
        exist.setPrice(req.getPrice());
        Book saved=repo.save(exist);
        return new BookResponse(saved.getId(),saved.getTitle(),saved.getAuthor(),saved.getPrice());
    }
    public void delete(Long id){
        boolean rem=repo.deleteById(id);
        if(!rem) throw new BookNotFoundExecption(id);
    }
}
