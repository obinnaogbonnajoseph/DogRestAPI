package com.udacity.DogRestAPI.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllDogs401() {
        var response =
                restTemplate.getForEntity("http://localhost:" + port + "/dogs", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.UNAUTHORIZED));
    }

    @Test
    public void getAllDogs() {
        var response =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity("http://localhost:" + port + "/dogs", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreeds() {
        var response =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity("http://localhost:" + port + "/dogs/breed", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreedByID() {
        var response =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity("http://localhost:" + port + "/dogs/1/breed", String.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogNames() {
        var response =
                restTemplate
                        .withBasicAuth("admin", "password")
                        .getForEntity("http://localhost:" + port + "/dogs/name", List.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
