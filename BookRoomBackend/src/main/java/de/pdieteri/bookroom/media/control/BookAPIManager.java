package de.pdieteri.bookroom.media.control;

import de.pdieteri.bookroom.media.boundary.DTOs.BookRequestDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;
import de.pdieteri.bookroom.media.entity.BookAPIService;
import de.pdieteri.bookroom.media.entity.BookEntity;
import de.pdieteri.bookroom.media.entity.BookService;

import javax.inject.Inject;
import java.util.Optional;

public class BookAPIManager implements BookAPIManagement {

    @Inject
    BookAPIService api;


    @Override
    public BookResonseDTO borrow(BookRequestDTO book) {
        return api.borrow(book.id);
    }
}
