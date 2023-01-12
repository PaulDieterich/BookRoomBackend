package de.pdieteri.bookroom.media.boundary.DTOs;

import de.pdieteri.bookroom.media.entity.AuthorEntity;

import java.util.UUID;

public class AuthorResponseDTO {

    public UUID uuid;
    public String firstname;
    public String lastname;

    public AuthorResponseDTO(UUID uuid, String firstname, String lastname) {
        this.uuid = uuid;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public static class Coverter{
        public static AuthorResponseDTO toDTO(AuthorEntity entity){
            return new AuthorResponseDTO(
              entity.getUuid(),
              entity.getFirstname(),
                entity.getLastname()
            );
        }
    }
}
