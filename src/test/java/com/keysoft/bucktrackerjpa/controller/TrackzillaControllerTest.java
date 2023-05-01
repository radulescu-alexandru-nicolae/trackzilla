package com.keysoft.bucktrackerjpa.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(secure=false)
public class TrackzillaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addApplication() throws Exception {
        String mockApplicationJson = "{\"name\":\"Test Application\",\"description\":\"A test application.\",\"owner\":\"Kesha Williams\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/tza/application/")
                .accept(MediaType.APPLICATION_JSON).content(mockApplicationJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        assertEquals("http://localhost/application/1",
                response.getHeader(HttpHeaders.LOCATION));
    }

    @Test
    public void findApplication() throws Exception {

        addApplication();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/tza/application/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"name\":\"Test Application\",\"description\":\"A test application.\",\"owner\":\"Kesha Williams\"}";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void updateApplication() throws Exception {
        addApplication();

        String mockApplicationJson = "{\"id\":1,\"name\":\"Test Application Updated\",\"description\":\"An updated test application.\",\"owner\":\"Kesha Williams\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/tza/application/")
                .accept(MediaType.APPLICATION_JSON).content(mockApplicationJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expected = "{\"id\":1,\"name\":\"Test Application Updated\",\"description\":\"An updated test application.\",\"owner\":\"Kesha Williams\"}";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void deleteApplication() throws Exception {
        addApplication();

        String mockApplicationJson = "{\"id\":1,\"name\":\"Test Application Updated\",\"description\":\"An updated test application.\",\"owner\":\"Kesha Williams\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/tza/application/1")
                .accept(MediaType.APPLICATION_JSON).content(mockApplicationJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }

    @Test
    public void addTicket() throws Exception {
        addApplication();

        String mockTicketJson = "{\"title\": \"Multiple Assignees Needed\", \"description\" : \"There are cases where we need to assign a ticket to more than one person.\", \"application\": {\"id\":\"1\"},\"status\": \"Open\"}";


        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/tza//ticket")
                .accept(MediaType.APPLICATION_JSON).content(mockTicketJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

}
