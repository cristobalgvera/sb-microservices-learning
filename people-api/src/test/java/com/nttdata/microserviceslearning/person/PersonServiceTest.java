package com.nttdata.microserviceslearning.person;

import com.nttdata.microserviceslearning.person.dto.PersonDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
    @InjectMocks
    private PersonService underTest;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @Captor
    private ArgumentCaptor<Person> personCaptor;

    @Test
    void itShouldFindAll() {
        // Given
        var pageable = Pageable.unpaged();
        var people = List.of(new Person(), new Person());
        var expected = new PersonDto();

        given(personRepository.findAll(pageable))
                .willReturn(new PageImpl<>(people));

        given(personMapper.toDto(any(Person.class)))
                .willReturn(expected);

        // When
        var actual = underTest.findAll(pageable);

        // Then
        verify(personRepository).findAll(pageable);
        verify(personMapper, times(people.size())).toDto(personCaptor.capture());

        assertThat(personCaptor.getAllValues())
                .containsExactlyInAnyOrderElementsOf(people);
        assertThat(actual)
                .hasSize(people.size())
                .containsExactlyInAnyOrder(expected, expected);
    }

    @Test
    void itShouldFindById() {
        // Given
        var id = UUID.randomUUID();
        var person = new Person();
        var expected = new PersonDto();

        given(personRepository.findById(id))
                .willReturn(Optional.of(person));

        given(personMapper.toDto(person))
                .willReturn(expected);

        // When
        var actual = underTest.findById(id);

        // Then
        assertThat(actual).isSameAs(expected);
    }

    @Test
    void itShouldThrowWhenPersonIsNotFound() {
        // Given
        var id = UUID.randomUUID();

        given(personRepository.findById(id))
                .willThrow(new EntityNotFoundException(id.toString()));

        // When
        // Then
        assertThatThrownBy(() -> underTest.findById(id))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining(String.valueOf(id));
    }
}