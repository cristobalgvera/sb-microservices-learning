package com.nttdata.persondataapi.peopledata;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeopleDataService {
    private final PeopleDataClient peopleDataClient;

    public Page<PeopleData> findAll(Pageable pageable) {
        return peopleDataClient.findAll(pageable);
    }
}
