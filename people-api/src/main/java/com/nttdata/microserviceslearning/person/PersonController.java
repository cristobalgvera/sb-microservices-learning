package com.nttdata.microserviceslearning.person;

import com.nttdata.microserviceslearning.person.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/people")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public ResponseEntity<Page<PersonDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(personService.findAll(pageable));
    }
}
