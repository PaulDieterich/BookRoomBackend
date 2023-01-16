package de.pdieteri.bookroom.media.entity;

import de.pdieteri.bookroom.shared.BookStatus;

import java.util.Optional;

public interface BookService {

        public BookEntity getAll();
        public BookEntity getById(Long id);
        public BookEntity getByIsbn(String isbn);
        public Optional<BookEntity> create(BookEntity book);

        public Optional<BookEntity> borrow(BookEntity book);

        public Optional<BookEntity> returnBook(BookEntity book);
        Optional<BookEntity> update(Long id, BookEntity book);
        public Optional<BookEntity> ChangeStatus(BookEntity book, BookStatus status);

}
