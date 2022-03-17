package com.nttdata.persondataapi.persondata;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "people-api", url = "http://localhost:8081")
public interface PersonDataClient {
    @GetMapping("/v1/people")
    Page<PersonData> findAll(Pageable pageable);

    @GetMapping("/v1/people/{id}")
    PersonData findById(@PathVariable UUID id);
}
