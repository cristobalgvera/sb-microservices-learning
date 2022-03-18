package com.nttdata.microserviceslearning.person.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public final class PersonDto {
    private UUID id;
    private String username;
    private String name;
    private String surname;
    private LocalDateTime bornDate;
    private String address;
    private String balancer;
}
