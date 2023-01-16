package de.pdieteri.bookroom.media.control;

import de.pdieteri.bookroom.media.entity.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookManagement {

    public List<BookEntity> getAllBooks();
    public BookEntity getById(Long id);

    public BookEntity getByIsbn(String isbn);
    public Optional<BookEntity> create(BookEntity book);

    Optional<BookEntity> update(Long id, BookEntity book);

    public Optional<BookEntity> borrow(Long id);

}
