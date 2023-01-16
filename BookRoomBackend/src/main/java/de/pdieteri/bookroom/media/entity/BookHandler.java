package de.pdieteri.bookroom.media.entity;

import de.pdieteri.bookroom.media.gateway.BookRepository;
import de.pdieteri.bookroom.media.shared.BookStatus;

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

    public boolean create(BookEntity book){
        return bookRepository.create(book);
    }

    @Override
    public Optional<BookEntity> borrow(BookEntity book) {
        BookEntity bookEntity = bookRepository.getById(book.getId());
        bookEntity.setStatus(BookStatus.BORROWED);
        return bookRepository.update(bookEntity);
    }
    @Override
    public Optional<BookEntity> returnBook(BookEntity book) {
        BookEntity bookEntity = bookRepository.getById(book.getId());
        bookEntity.setStatus(BookStatus.AVAILABLE);
        return bookRepository.update(bookEntity);
    }

    @Override
    public Optional<BookEntity> update(Long id, BookEntity book) {
        BookEntity bookEntity = bookRepository.getById(id);
        if(bookEntity != null){
            bookEntity.setTitle(book.getTitle());
            bookEntity.setSecondtitle(book.getSecondtitle());
            if(book.getAuthorsList() != null || book.getAuthorsList().size() > 0){
                bookEntity.setAuthorsList(book.getAuthorsList());
            }
            bookEntity.setIban(book.getIban());
            bookEntity.setFormat(book.getFormat());
            bookEntity.setGenre(book.getGenre());
            bookEntity.setStatus(book.getStatus());
            bookRepository.persist(bookEntity);
            return Optional.of(bookEntity);
        }
        return Optional.empty();

    }

    @Override
    public Optional<BookEntity> ChangeStatus(BookEntity book, BookStatus status) {
        BookEntity bookEntity = bookRepository.getById(book.getId());
        bookEntity.setStatus(status);
        return Optional.ofNullable(bookEntity);
    }

}
