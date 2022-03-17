package com.nttdata.persondataapi.peopledata;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "people-api", url = "http://localhost:8081")
public interface PeopleDataClient {
    @GetMapping("/v1/people")
    Page<PeopleData> findAll(Pageable pageable);
}
