/*
 * Copyright (c) 2020. Marc Kandel
 */

package com.mkandel.checklists;

import com.mkandel.checklists.utils.categories.IntegrationTest;
import org.junit.After;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Category(IntegrationTest.class)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { DbAdapter.class })
public abstract class BaseIntegrationTest {

    @Autowired
    protected WebApplicationContext wac;

//    @Autowired
//    protected UserRepository userRepository;

    protected MockMvc mockMvc;

    @Before
    public void baseSetup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @After
    public void baseTearDown() {
    }
}
