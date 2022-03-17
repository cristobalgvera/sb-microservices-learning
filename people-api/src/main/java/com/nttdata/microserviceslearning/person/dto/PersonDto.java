package com.nttdata.microserviceslearning.person.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PersonDto(
        UUID id,
        String username,
        String name,
        String surname,
        LocalDateTime bornDate,
        String address
) {
}
