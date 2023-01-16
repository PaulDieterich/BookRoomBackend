package de.pdieteri.bookroom.media.entity;

import de.pdieteri.bookroom.media.gateway.BookRepository;
import de.pdieteri.bookroom.shared.BookStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class BookHandler implements BookService {

    @Inject
    BookRepository bookRepository;


    public List<BookEntity> getAll(){
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
    public Optional<BookEntity> borrow(Long id) {
        BookEntity book = bookRepository.getById(id);
        return bookRepository.changeStatus(book, BookStatus.BORROWED);
    }
    @Override
    public Optional<BookEntity> returnBook(BookEntity book) {
      return bookRepository.changeStatus(book, BookStatus.AVAILABLE);
    }

    @Override
    public Optional<BookEntity> update(Long id, BookEntity book) {
        Optional<BookEntity> bookEntity = bookRepository.update(id, book);
        return bookEntity;

    }

    @Override
    public Optional<BookEntity> changeStatus(BookEntity book, BookStatus status) {
        Optional<BookEntity> bookEntity = bookRepository.changeStatus(book, status);
        return bookEntity;
    }

}
