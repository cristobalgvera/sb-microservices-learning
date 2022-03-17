package com.nttdata.persondataapi.persondata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonDataService {
    private final PersonDataClient peopleDataClient;

    public Page<PersonData> findAll(Pageable pageable) {
        return peopleDataClient.findAll(pageable);
    }

    public PersonData findById(UUID id) {
        return peopleDataClient.findById(id);
    }
}
