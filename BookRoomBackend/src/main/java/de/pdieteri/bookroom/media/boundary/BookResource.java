package de.pdieteri.bookroom.media.boundary;


import de.pdieteri.bookroom.media.boundary.DTOs.AuthorResponseDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookResonseDTO;
import de.pdieteri.bookroom.media.boundary.DTOs.BookUpdateDTO;
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
import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
    public HalCollectionWrapper getAll(){
        List<BookEntity> response = bookManagement.getAllBooks();
        Collection<BookResonseDTO> resonseList = response.stream().map(BookResonseDTO.Converter::toDTO).collect(Collectors.toList());
        Collection<HalEntityWrapper> halWrapperList = resonseList.stream().map(HalEntityWrapper::new).collect(Collectors.toList());
        halWrapperList.stream().forEach(halEntityWrapper -> halEntityWrapper.addLinks(Link.fromUri("/media/books").rel("list").build()));
        HalCollectionWrapper collectionWrapper = new  HalCollectionWrapper(halWrapperList, "books",Link.fromPath("/media/books/").rel("self").build() );
        collectionWrapper.addLinks(Link.fromPath("/media/books/1").rel("first-entry").build());
        return collectionWrapper;
    }

    @GET
    @Path("{id}")
    @RestLink(rel = "self")
    @InjectRestLinks
    public HalEntityWrapper getById(Long id){
        BookEntity response = bookManagement.getById(id);
        BookResonseDTO resonseDTO = BookResonseDTO.Converter.toDTO(response);
        HalEntityWrapper entityWrapper = new HalEntityWrapper(resonseDTO, Link.fromPath("/media/books/"+ id ).rel("self").build());
        for (AuthorResponseDTO author : resonseDTO.authorsList) {
            entityWrapper.addLinks(Link.fromPath("/media/author/"+ author.uuid ).rel("author").build());
        }
        return entityWrapper;
    }
    @PUT
    @Path("{id}")
    @RestLink(rel = "update")
    @InjectRestLinks
    public HalEntityWrapper update(Long id, BookUpdateDTO bookUpdateDTO){
        BookEntity book = BookUpdateDTO.Converter.toEntity(bookUpdateDTO);
        Optional<BookEntity> response = bookManagement.update(id, book);
        BookResonseDTO resonseDTO = BookResonseDTO.Converter.toDTO(response.get());
        HalEntityWrapper entityWrapper = new HalEntityWrapper(resonseDTO, Link.fromPath("/media/books/"+ id ).rel("self").build());
        for (AuthorResponseDTO author : resonseDTO.authorsList) {
            entityWrapper.addLinks(Link.fromPath("/media/author/"+ author.uuid ).rel("author").build());
        }
        return entityWrapper;
    }
}
