package com.nttdata.microserviceslearning.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PersonMapperTest {
    @InjectMocks
    private PersonMapperImpl underTest;

    @Test
    void itShouldMapUsername() {
        // Given
        var expected = new Person();
        expected.setUsername("username");

        // When
        var actual = underTest.toDto(expected);

        // Then
        assertThat(actual.getUsername()).isEqualTo(expected.getUsername());
    }

    @Test
    void itShouldMapName() {
        // Given
        var expected = new Person();
        expected.setName("name");

        // When
        var actual = underTest.toDto(expected);

        // Then
        assertThat(actual.getName()).isEqualTo(expected.getName());
    }

    @Test
    void itShouldMapSurname() {
        // Given
        var expected = new Person();
        expected.setSurname("surname");

        // When
        var actual = underTest.toDto(expected);

        // Then
        assertThat(actual.getSurname()).isEqualTo(expected.getSurname());
    }

    @Test
    void itShouldMapAddress() {
        // Given
        var expected = new Person();
        expected.setAddress("address");

        // When
        var actual = underTest.toDto(expected);

        // Then
        assertThat(actual.getAddress()).isEqualTo(expected.getAddress());
    }

    @Test
    void itShouldMapBornDate() {
        // Given
        var expected = new Person();
        expected.setBornDate(LocalDateTime.of(2000, 1, 1, 0, 0));

        // When
        var actual = underTest.toDto(expected);

        // Then
        assertThat(actual.getBornDate()).isEqualTo(expected.getBornDate());
    }
}