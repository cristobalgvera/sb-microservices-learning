package com.nttdata.microserviceslearning;

import com.nttdata.microserviceslearning.person.PersonController;
import com.nttdata.microserviceslearning.person.PersonRepository;
import com.nttdata.microserviceslearning.person.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MicroservicesLearningApplicationTests {
    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() {
        assertThat(personController).isNotNull();
    }

}
