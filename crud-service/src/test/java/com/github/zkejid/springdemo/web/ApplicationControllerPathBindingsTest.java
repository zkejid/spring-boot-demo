package com.github.zkejid.springdemo.web;

import com.github.zkejid.springdemo.entities.TextEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Matchers.anyObject;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

/**
 * Path bindings tests for {@link ApplicationController} layer. Tests should check correctness of path bindings
 * for all controller methods.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerPathBindingsTest {

    private static final String TITLE = "hello";
    private static final String CONTENT = "world";

    @SuppressWarnings("unused") //cause autowired
    @Autowired
    private MockMvc mockMvc;

    /**
     * Scenario: {@link ApplicationController#create(TextEntity)} is called on /create
     * Expected: successful call of controller method
     */
    @Test
    public void createTest() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/create")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .param("title", TITLE)
//                        .param("content", CONTENT)
//        )
//                .andExpect(status().isOk())
//                .andExpect(handler().handlerType(ApplicationController.class))
//                .andExpect(handler().methodCall(on(ApplicationController.class).create(anyObject())));
    }
}