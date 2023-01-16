package de.pdieteri.bookroom.media.entity;

import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;

public interface BookAPIService {


    public BookResonseDTO borrow(Long id);
}
