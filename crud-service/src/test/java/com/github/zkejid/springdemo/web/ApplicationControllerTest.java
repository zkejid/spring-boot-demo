package com.github.zkejid.springdemo.web;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {

    public static final String TEST_TITLE = "Test title";
    public static final String TEST_CONTENT = "Test content";
    @Autowired
    private MockMvc mvc;

    /**
     * Scenario: Calling index page
     * <p/>
     * Expected: String line "TextEntity CRUD application"
     */
    @Test
    public void getIndex() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("TextEntity CRUD application")));
    }

    /**
     * Scenario: Calling create page
     * <p/>
     * Expected: String line "TextEntity CRUD application"
     */
    @Test
    public void callCreate() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/text/create")
                .param("title", TEST_TITLE)
                .param("content", TEST_CONTENT)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{}"));
    }
}