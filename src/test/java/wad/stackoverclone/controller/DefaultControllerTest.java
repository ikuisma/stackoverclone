package wad.stackoverclone.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getHomeShouldReturnStatusOk() throws Exception {
        this.mvc.perform(get("/home"))
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingUrlShouldRedirectToHome() throws Exception {
        this.mvc.perform(get("/trolololo"))
                .andExpect(redirectedUrl("/home"))
                .andExpect(status().is3xxRedirection());
    }

}
