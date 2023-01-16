package de.pdieteri.bookroom.media.boundary;

import de.pdieteri.bookroom.media.boundary.DTOs.BookRequestDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;
import de.pdieteri.bookroom.media.control.BookAPIManagement;
import de.pdieteri.bookroom.media.entity.BookEntity;

import javax.inject.Inject;

public class BookAPIResource implements BookAPI {

    @Inject
    BookAPIManagement api;

    @Override
    public BookResonseDTO borrow(BookRequestDTO book) {
        return api.borrow(book);
    }

}

