package com.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
@WebAppConfiguration
@ContextConfiguration
public class TestUserController {

    private static Logger log = LoggerFactory.getLogger(TestUserController.class);

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testSelectPdsPbAcInfo() {

        String userName = "admin";

       try {
           MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/getByUsername").contentType(MediaType.TEXT_HTML_VALUE).param("userName",userName)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
           int status = mvcResult.getResponse().getStatus();
           Assert.assertEquals(200, status);
           MockHttpServletResponse response = mvcResult.getResponse();
           response.setCharacterEncoding("UTF-8");
           String result = response.getContentAsString();
           Assert.assertNotNull(result);
           log.info("[返回结果]:{}", result);

       } catch (Exception e){
           e.printStackTrace();
       }


    }
}
