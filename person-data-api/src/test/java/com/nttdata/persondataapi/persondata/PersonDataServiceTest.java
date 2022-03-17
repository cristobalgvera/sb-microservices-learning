package com.nttdata.persondataapi.persondata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonDataServiceTest {
    @InjectMocks
    private PersonDataService underTest;

    @Mock
    private PersonDataClient peopleDataClient;

    @Test
    void itShouldFindAll() {
        // Given
        var pageable = Pageable.unpaged();
        var expected = List.of(new PersonData(), new PersonData());

        given(peopleDataClient.findAll(pageable))
                .willReturn(new PageImpl<>(expected));

        // When
        var actual = underTest.findAll(pageable);

        // Then
        verify(peopleDataClient).findAll(pageable);

        assertThat(actual.getContent()).isEqualTo(expected);
    }

    @Test
    void itShouldFindById() {
        // Given
        var id = UUID.randomUUID();
        var expected = new PersonData();

        given(peopleDataClient.findById(id))
                .willReturn(expected);

        // When
        var actual = underTest.findById(id);

        // Then
        verify(peopleDataClient).findById(id);

        assertThat(actual).isSameAs(expected);
    }
}