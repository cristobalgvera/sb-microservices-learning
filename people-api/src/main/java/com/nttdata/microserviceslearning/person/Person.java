package com.nttdata.microserviceslearning.person;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "people")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Person extends AbstractPersistable<UUID> {
    @Column(nullable = false, unique = true)
    private String username;
    private String name;
    private String surname;
    private LocalDateTime bornDate;
    private String address;
    private String balancer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) Objects.requireNonNull(o);
        return getId() != null && Objects.equals(getId(), person.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
