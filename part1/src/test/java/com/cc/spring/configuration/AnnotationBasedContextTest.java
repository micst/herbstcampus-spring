package com.cc.spring.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cc.spring.service.UserTaskService;
import org.springframework.context.annotation.Bean;

//@RunWith(SpringRunner.class)

public class AnnotationBasedContextTest {

	@Autowired
	AnnotationConfigApplicationContext ctx;
	
	@Before
	public void setup() {
    	ctx = new AnnotationConfigApplicationContext();
    	ctx.register(AppContext.class);    	
        ctx.refresh();
        ctx.start();
	}

	@After
	public void tearDown() {
        ctx.close();
	}

    @Test
    public void testStartup() {
        assertNotNull(ctx.getBean(UserTaskService.class));
    }

}
