package com.udacity.DogRestAPI.web;

import com.udacity.dogrestapi.service.DogService;
import com.udacity.dogrestapi.web.DogController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogService dogService;

    @Test
    @WithMockUser
    public void retrieveDogs() throws Exception {
        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    @WithMockUser
    public void retrieveDogBreed() throws Exception {
        mockMvc.perform(get("/dogs/breed"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    @WithMockUser
    public void retrieveDogBreedById() throws Exception {
        mockMvc.perform(get("/dogs/1/breed"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById(Long.valueOf("1"));
    }

    @Test
    @WithMockUser
    public void retrieveDogNames() throws Exception {
        mockMvc.perform(get("/dogs/name"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogNames();
    }
}
