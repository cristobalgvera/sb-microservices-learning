package com.nttdata.microserviceslearning.person;

import com.nttdata.microserviceslearning.person.dto.PersonDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto toDto(Person person);
}
