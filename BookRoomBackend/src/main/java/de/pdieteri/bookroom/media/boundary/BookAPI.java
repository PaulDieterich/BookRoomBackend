package de.pdieteri.bookroom.media.boundary;

import de.pdieteri.bookroom.media.boundary.DTOs.BookRequestDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;

public interface BookAPI {

    public BookResonseDTO borrow(BookRequestDTO book);
}
