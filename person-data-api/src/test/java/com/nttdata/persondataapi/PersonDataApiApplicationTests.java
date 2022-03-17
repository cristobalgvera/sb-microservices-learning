package com.nttdata.persondataapi;

import com.nttdata.persondataapi.persondata.PersonDataController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonDataApiApplicationTests {
    @Autowired
    private PersonDataController personDataController;

    @Test
    void contextLoads() {
        assertThat(personDataController).isNotNull();
    }

}
