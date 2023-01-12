package de.pdieteri.bookroom.media.boundary;


import de.pdieteri.bookroom.media.boundary.DTOs.AuthorResponseDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;
import de.pdieteri.bookroom.media.control.BookManagement;
;
import de.pdieteri.bookroom.media.entity.BookEntity;
import io.quarkus.hal.HalCollectionWrapper;
import io.quarkus.hal.HalEntityWrapper;

import io.quarkus.resteasy.reactive.links.InjectRestLinks;
import io.quarkus.resteasy.reactive.links.RestLink;
import io.quarkus.resteasy.reactive.links.RestLinksProvider;

import org.jboss.resteasy.reactive.common.util.RestMediaType;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Path("/media/books")
@Produces({ MediaType.APPLICATION_JSON, RestMediaType.APPLICATION_HAL_JSON })
@Consumes(RestMediaType.APPLICATION_HAL_JSON)
@Transactional
@RequestScoped
public class BookResource {

    @Inject
    BookManagement bookManagement;
    @Inject
    RestLinksProvider linksProvider;
    @GET
    @RestLink(rel = "list")

    @InjectRestLinks
    public HalCollectionWrapper getAllBooks(){
        List<BookEntity> response = bookManagement.getAllBooks();
        Collection<BookResonseDTO> resonseList = response.stream().map(BookResonseDTO.Converter::toDTO).collect(Collectors.toList());
        Collection<HalEntityWrapper> halWrapperList = resonseList.stream().map(HalEntityWrapper::new).collect(Collectors.toList());
        HalCollectionWrapper collectionWrapper = new  HalCollectionWrapper(halWrapperList, "books",Link.fromPath("/media/books/").rel("self").build() );
        collectionWrapper.addLinks(Link.fromPath("/media/books/1").rel("first-entry").build());
        return collectionWrapper;
    }

    @GET
    @Path("{id}")
    @RestLink(rel = "self")
    @InjectRestLinks
    public HalEntityWrapper getBookById(Long id){
        BookEntity response = bookManagement.getBookById(id);
        BookResonseDTO resonseDTO = BookResonseDTO.Converter.toDTO(response);
        HalEntityWrapper entityWrapper = new HalEntityWrapper(resonseDTO, Link.fromPath("/media/books/"+ id ).rel("self").build());
        for (AuthorResponseDTO author : resonseDTO.authorsList) {
            entityWrapper.addLinks(Link.fromPath("/media/author/"+ author.uuid ).rel("author").build());
        }
        return entityWrapper;
    }
}
