package de.pdieteri.bookroom.media.boundary.DTOs;

import de.pdieteri.bookroom.media.entity.BookEntity;

public class BookUpdateDTO {
    public String title;
    public String secondtitle;
    public String iban;
    public String format;
    public String genre;

public BookUpdateDTO(String title, String secondtitle, String iban, String format, String genre) {
        this.title = title;
        this.secondtitle = secondtitle;
        this.iban = iban;
        this.format = format;
        this.genre = genre;
    }
    public static class Converter{
        public static BookUpdateDTO toDTO(BookEntity entity){
            return new BookUpdateDTO(
                    entity.getTitle(),
                    entity.getSecondtitle(),
                    entity.getIban(),
                    entity.getFormat(),
                    entity.getGenre()
            );
        }
        public static BookEntity toEntity(BookUpdateDTO dto){
            return new BookEntity(
                    dto.title,
                    dto.secondtitle,
                    dto.iban,
                    dto.format,
                    dto.genre
            );
        }
    }

}
