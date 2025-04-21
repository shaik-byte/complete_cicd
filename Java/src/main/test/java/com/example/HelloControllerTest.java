package com.example.codekamikaze;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void helloShouldReturnWelcomeMessage() {
        String body = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
        assertThat(body).isEqualTo("Hello, welcome to CodeKamikaze");
    }
}
