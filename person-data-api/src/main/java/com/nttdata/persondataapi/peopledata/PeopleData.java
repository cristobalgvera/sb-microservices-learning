package com.nttdata.persondataapi.peopledata;

import java.time.LocalDateTime;
import java.util.UUID;

public record PeopleData(
        UUID id,
        String username,
        String name,
        String surname,
        LocalDateTime bornDate,
        String address
) {
}
