package com.rahul.portfolio.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.rahul.portfolio.dto.ContactResponse;
import com.rahul.portfolio.service.ContactService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ContactController.class)
class ContactControllerTest {
    @Autowired MockMvc mvc;
    @MockBean ContactService service;

    @Test void validReturns201() throws Exception {
        when(service.submit(any(), anyString())).thenReturn(new ContactResponse(true, "ok"));
        mvc.perform(post("/api/contact").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Asha\",\"email\":\"a@b.com\",\"subject\":\"Hello\",\"message\":\"Long enough message\"}"))
                .andExpect(status().isCreated());
    }

    @Test void invalidEmailReturns400() throws Exception {
        mvc.perform(post("/api/contact").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Asha\",\"email\":\"bad\",\"subject\":\"Hello\",\"message\":\"Long enough message\"}"))
                .andExpect(status().isBadRequest());
    }
}
