package com.mastercard.challenge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by ysedn on Jul 13, 2020
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAreCitiesConnected() throws Exception {
        MvcResult result = mockMvc.perform(get("/connected?origin=Dallas&destination=Houston")).andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        assertTrue("true".equals(content));

        result = mockMvc.perform(get("/connected?origin=Boston&destination=Houston")).andExpect(status().isOk()).andReturn();
        content = result.getResponse().getContentAsString();
        assertTrue("false".equals(content));

    }


}
