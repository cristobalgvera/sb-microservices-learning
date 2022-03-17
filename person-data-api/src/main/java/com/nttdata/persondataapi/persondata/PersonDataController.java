package com.nttdata.persondataapi.persondata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/people-data")
@RequiredArgsConstructor
public class PersonDataController {
    private final PersonDataService peopleDataService;

    @GetMapping
    public ResponseEntity<Page<PersonData>> findAll(Pageable pageable) {
        return ResponseEntity.ok(peopleDataService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonData> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(peopleDataService.findById(id));
    }
}
