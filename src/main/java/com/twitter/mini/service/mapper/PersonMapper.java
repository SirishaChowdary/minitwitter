package com.twitter.mini.service.mapper;

import com.twitter.mini.domain.*;
import com.twitter.mini.service.dto.PersonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Person and its DTO PersonDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PersonMapper extends EntityMapper<PersonDTO, Person> {

    @Mapping(source = "person.id", target = "personId")
    PersonDTO toDto(Person person); 

    @Mapping(target = "messages", ignore = true)
    @Mapping(source = "personId", target = "person")
    @Mapping(target = "followings", ignore = true)
    Person toEntity(PersonDTO personDTO);

    default Person fromId(Long id) {
        if (id == null) {
            return null;
        }
        Person person = new Person();
        person.setId(id);
        return person;
    }
}
