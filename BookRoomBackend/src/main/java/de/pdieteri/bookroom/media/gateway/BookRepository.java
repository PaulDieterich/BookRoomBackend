package de.pdieteri.bookroom.media.gateway;

import de.pdieteri.bookroom.media.entity.BookEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.Optional;

public class BookRepository implements PanacheRepository<BookEntity> {

    public BookEntity getAll(){
        return find("select b from BookEntity b").firstResult();
    }

    public BookEntity getById(Long id){
        return find("select b from BookEntity b where b.id = ?1", id).firstResult();
    }
    public BookEntity getByIsbn(String isbn){
        return find("isbn", isbn).firstResult();
    }

    public boolean create(BookEntity book){
        persist(book);
        return true;
    }
    public Optional<BookEntity> update(BookEntity book){
       Optional<BookEntity> bookEntity = findByIdOptional(book.getId());
       if(bookEntity.isPresent()){
           bookEntity.get().setTitle(book.getTitle());
           bookEntity.get().setSecondtitle(book.getSecondtitle());
           bookEntity.get().setAuthorsList(book.getAuthorsList());
           bookEntity.get().setIban(book.getIban());
           bookEntity.get().setFormat(book.getFormat());
           bookEntity.get().setGenre(book.getGenre());
           bookEntity.get().setStatus(book.getStatus());
           return Optional.of(bookEntity.get());
       }
       return Optional.empty();
    }

}




