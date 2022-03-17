package com.nttdata.microserviceslearning.person;

import com.nttdata.microserviceslearning.person.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
