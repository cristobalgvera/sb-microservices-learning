package com.nttdata.microserviceslearning.person;

import com.nttdata.microserviceslearning.person.dto.PersonDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Value;

@Mapper(componentModel = "spring")
public abstract class PersonMapper {
    private static final String MAP_BALANCER = "MAP_BALANCER";

    @Value("${config.balancer.test}")
    private String balancer;

    @Mapping(target = "balancer", source = "balancer", qualifiedByName = MAP_BALANCER)
    public abstract PersonDto toDto(Person person);

    @Named(MAP_BALANCER)
    protected String mapBalancer(String entityBalancer) {
        return balancer;
    }
}
