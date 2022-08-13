package com.gharib.conference_demo.controllers;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebMvc
public class SpeakerIntegrationTest {
    @LocalServerPort
    private  int port;
    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void list() throws Exception {
        ResponseEntity<List> response = this.testRestTemplate.getForEntity("http://localhost:"+port+"/api/v1/speakers",List.class);
        Assert.assertEquals(response.getStatusCode(),HttpStatus.OK);
    }

}


