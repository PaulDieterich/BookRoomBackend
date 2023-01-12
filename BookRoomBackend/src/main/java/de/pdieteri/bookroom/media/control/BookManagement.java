package de.pdieteri.bookroom.media.control;

import de.pdieteri.bookroom.media.entity.BookEntity;

import java.util.List;

public interface BookManagement {

    public List<BookEntity> getAllBooks();
    public BookEntity getBookById(Long id);
}
