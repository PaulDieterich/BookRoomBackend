package de.pdieteri.bookroom.media.control;

import de.pdieteri.bookroom.media.boundary.DTOs.BookRequestDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;
import de.pdieteri.bookroom.media.entity.BookEntity;

import java.util.Optional;

public interface BookAPIManagement{
        public BookResonseDTO borrow(BookRequestDTO book);

}
