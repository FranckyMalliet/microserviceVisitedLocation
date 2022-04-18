package microserviceVisitedLocation.controllers;

import microserviceVisitedLocation.services.VisitedLocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class VisitedLocationControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private static MockMvc mockMvc;

    @Autowired
    private VisitedLocationService visitedLocationService;

    @BeforeEach
    public void setupMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void givenAUUID_CreateARandomVisitedLocation() throws Exception {
        //GIVEN
        UUID userId = UUID.randomUUID();

        //THEN
        mockMvc.perform(get("/createVisitedLocation")
                        .param("userId", String.valueOf(userId)))
                .andExpect(status().isOk());
    }
}
