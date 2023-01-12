package de.pdieteri.bookroom.media.control;

import de.pdieteri.bookroom.media.entity.AuthorEntity;
import de.pdieteri.bookroom.media.entity.BookEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import java.awt.print.Book;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookManger implements BookManagement {

    AuthorEntity a1 = new AuthorEntity(UUID.randomUUID(), "Hans", "Peter");
    List<AuthorEntity> authors = List.of(a1);
    BookEntity b1 = new BookEntity(1L,"HarryPotter", "Der Stein der Weisen", authors, "Buch", "gebunden" ,"Fantasy");

    List<BookEntity> books = List.of(b1);

    @Override
    public List<BookEntity> getAllBooks() {
        return books;
    }

    @Override
    public BookEntity getBookById(Long id) {
        return b1;
    }
}
