package com.nttdata.microserviceslearning.person;

import com.nttdata.microserviceslearning.person.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public Page<PersonDto> findAll(Pageable pageable) {
        return personRepository
                .findAll(pageable)
                .map(personMapper::toDto);
    }

    public PersonDto findById(UUID id) {
        var person = personRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with id '%s' not found".formatted(id)));

        return personMapper.toDto(person);
    }
}
