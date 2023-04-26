package com.dancehub.backend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DanceClassControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetCourses() throws Exception {

        mockMvc.perform(get("/course/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.length()").value(greaterThanOrEqualTo(5)))
                .andExpect(jsonPath("$[0].instructor").exists())
                .andExpect(jsonPath("$[0].location").exists())
                .andExpect(jsonPath("$[0].dance_school").exists())
                .andExpect(jsonPath("$[0].dance_class_name").exists())
                .andExpect(jsonPath("$[0].weekday").exists())
                .andExpect(jsonPath("$[0].start_time").exists())
                .andExpect(jsonPath("$[0].end_time").exists());
    }

}