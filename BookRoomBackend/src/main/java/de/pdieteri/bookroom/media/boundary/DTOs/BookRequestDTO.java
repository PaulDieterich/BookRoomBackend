package de.pdieteri.bookroom.media.boundary.DTOs;

public class BookRequestDTO {


    public Long id;
    public String title;

    public String isbn;

    public BookRequestDTO(Long id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
    }


}
