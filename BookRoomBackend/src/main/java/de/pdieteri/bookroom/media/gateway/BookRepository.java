package de.pdieteri.bookroom.media.gateway;

import de.pdieteri.bookroom.media.entity.BookEntity;
import de.pdieteri.bookroom.shared.BookStatus;
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

    public Optional<BookEntity> create(BookEntity book){
        persist(book);
        return Optional.ofNullable(book);
    }
    public Optional<BookEntity> update(Long id, BookEntity book){
       Optional<BookEntity> bookEntity = findByIdOptional(id);
       if(bookEntity.isPresent()){
           bookEntity.get().setTitle(book.getTitle());
           bookEntity.get().setSecondtitle(book.getSecondtitle());
           bookEntity.get().setAuthorsList(book.getAuthorsList());
           bookEntity.get().setIban(book.getIban());
           bookEntity.get().setFormat(book.getFormat());
           bookEntity.get().setGenre(book.getGenre());
           bookEntity.get().setStatus(book.getStatus());
              persist(bookEntity.get());
           return Optional.of(bookEntity.get());
       }
       return Optional.empty();
    }
    public Optional<BookEntity> borrow(Long id){
        BookEntity bookEntity = getById(id);
        bookEntity.setStatus(BookStatus.BORROWED);
        persist(bookEntity);
        return Optional.ofNullable(bookEntity);
    }

    public Optional<BookEntity> ChangeStatus(BookEntity book, BookStatus status) {
        BookEntity bookEntity = getById(book.getId());
        bookEntity.setStatus(status);
        persist(bookEntity);
        return Optional.ofNullable(bookEntity);
    }
}




