package de.pdieteri.bookroom.media.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="Books")
//@JsonbPropertyOrder({"uuid", "title", "secondtitle", "iban", "format"})
public class BookEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue

    private Long id;
    private String title;
    private String secondtitle;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<AuthorEntity> authorsList = new ArrayList<>();
    private String iban;
    private String format;
    public String genre;

    public BookEntity(){}

    public BookEntity(Long id, String title, String secondtitle, List<AuthorEntity> authorsList, String iban, String format, String genre) {
        this.id = id;
        this.title = title;
        this.secondtitle = secondtitle;
        this.authorsList = authorsList;
        this.iban = iban;
        this.format = format;
        this.genre = genre;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSecondtitle() {
        return secondtitle;
    }

    public void setSecondtitle(String secondtitle) {
        this.secondtitle = secondtitle;
    }

    public List<AuthorEntity> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<AuthorEntity> authorsList) {
        this.authorsList = authorsList;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
