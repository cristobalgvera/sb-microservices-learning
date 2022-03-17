package com.nttdata.persondataapi.persondata;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public final class PersonData {
    private UUID id;
    private String username;
    private String name;
    private String surname;
    private LocalDateTime bornDate;
    private String address;
}
