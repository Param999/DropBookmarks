package com.param.dropbookmarks.resources;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.MediaType;

import static org.junit.Assert.*;

public class HelloResourceTest {

    @ClassRule
    public static final ResourceTestRule RULE = ResourceTestRule.builder().addResource(new HelloResource()).build();

    @Test
    public void testGetGreetings(){
        String expected = "Hello Dropwizard";
        String actual = RULE
                .getJerseyTest()
                .target("hello")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertEquals(expected, actual);
    }

    @Test
    public void testHelloSecuredGreetings(){
        String expected = "Hello Secured Dropwizard";
        String actual = RULE
                .getJerseyTest()
                .target("hello/secure")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertEquals(expected, actual);
    }

}
