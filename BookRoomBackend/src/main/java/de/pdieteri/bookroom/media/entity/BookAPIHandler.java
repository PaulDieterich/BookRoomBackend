package de.pdieteri.bookroom.media.entity;

import de.pdieteri.bookroom.media.boundary.BookAPI;
import de.pdieteri.bookroom.media.boundary.DTOs.BookRequestDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BookAPIHandler implements BookAPIService {

    @Override
    public BookResonseDTO borrow(Long id) {
        return null;
    }
}
