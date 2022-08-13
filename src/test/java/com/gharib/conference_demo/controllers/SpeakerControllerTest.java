package com.gharib.conference_demo.controllers;

import com.gharib.conference_demo.repositories.SessionRepository;
import com.gharib.conference_demo.repositories.SpeakerRepository;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.security.RunAs;
import javax.print.attribute.standard.Media;
import javax.swing.Spring;


@RunWith(SpringRunner.class)
@WebMvcTest(SpeakerController.class)
class SpeakerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpeakerRepository speakerRepository;

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/api/v1/speakers"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        verify(speakerRepository,times(1)).findAll();
    }
}