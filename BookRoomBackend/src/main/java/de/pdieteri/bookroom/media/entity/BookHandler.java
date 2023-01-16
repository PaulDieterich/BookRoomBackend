package de.pdieteri.bookroom.media.entity;

import de.pdieteri.bookroom.media.gateway.BookRepository;
import de.pdieteri.bookroom.shared.BookStatus;

import javax.inject.Inject;
import java.util.Optional;

public class BookHandler implements BookService {

    @Inject
    BookRepository bookRepository;


    public BookEntity getAll(){
        return bookRepository.getAll();
    }

    @Override
    public BookEntity getById(Long id) {
        return null;
    }

    @Override
    public BookEntity getByIsbn(String isbn) {
        return null;
    }

    public Optional<BookEntity> create(BookEntity book){
        return bookRepository.create(book);
    }

    @Override
    public Optional<BookEntity> borrow(BookEntity book) {
       return bookRepository.borrow(book.getId());
    }
    @Override
    public Optional<BookEntity> returnBook(BookEntity book) {
      return bookRepository.ChangeStatus(book, BookStatus.AVAILABLE);
    }

    @Override
    public Optional<BookEntity> update(Long id, BookEntity book) {
        Optional<BookEntity> bookEntity = bookRepository.update(id, book);
        return bookEntity;

    }

    @Override
    public Optional<BookEntity> ChangeStatus(BookEntity book, BookStatus status) {
        Optional<BookEntity> bookEntity = bookRepository.ChangeStatus(book, status);
        return bookEntity;
    }

}
