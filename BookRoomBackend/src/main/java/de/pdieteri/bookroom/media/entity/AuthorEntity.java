package de.pdieteri.bookroom.media.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class AuthorEntity {

    @Id
    @Column(name ="id")
    @GeneratedValue(generator = "id")
    private Long id;
    private String firstname;
    private String lastname;

    @ManyToMany
    private List<BookEntity> books = new ArrayList<>();
    public AuthorEntity(){}

    public AuthorEntity(Long id, String firstname, String lastname, List<BookEntity> books) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }
    public AuthorEntity(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;

    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
