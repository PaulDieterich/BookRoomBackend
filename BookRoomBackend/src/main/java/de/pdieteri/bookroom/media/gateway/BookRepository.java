package de.pdieteri.bookroom.media.gateway;

import de.pdieteri.bookroom.media.entity.BookEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class BookRepository implements PanacheRepository<BookEntity> {

    public BookEntity getAll(){
        return find("select b from BookEntity b").firstResult();
    }
    public BookEntity getBookByIsbn(String isbn){
        return find("isbn", isbn).firstResult();
    }

}




