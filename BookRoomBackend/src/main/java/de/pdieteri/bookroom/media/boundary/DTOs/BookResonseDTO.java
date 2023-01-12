package de.pdieteri.bookroom.media.boundary.DTOs;

import de.pdieteri.bookroom.media.entity.BookEntity;

import javax.json.bind.annotation.JsonbPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonbPropertyOrder({"id", "title", "secondtitle","iban","format", "genre","authorsList"})
public class BookResonseDTO {
    public Long id;
    public String title;
    public String secondtitle;

    public List<AuthorResponseDTO> authorsList = new ArrayList<>();
    public String iban;
    public String format;
    public String genre;

    public BookResonseDTO(Long id, String title, String secondtitle, List<AuthorResponseDTO> authorsList, String iban, String format, String genre) {
        this.id = id;
        this.title = title;
        this.secondtitle = secondtitle;
        this.authorsList = authorsList;
        this.iban = iban;
        this.format = format;
        this.genre = genre;
    }
    public static class Converter{
        public static  BookResonseDTO toDTO(BookEntity entity){
            List<AuthorResponseDTO> authors = entity.getAuthorsList().stream().map(AuthorResponseDTO.Coverter::toDTO).toList();
            return new BookResonseDTO(
                    entity.getId(),
                    entity.getTitle(),
                    entity.getSecondtitle(),
                    authors,
                    entity.getIban(),
                    entity.getFormat(),
                    entity.getGenre() );
        }
    }
}
