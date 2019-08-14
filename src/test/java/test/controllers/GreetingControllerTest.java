package test.controllers;

import hello.controllers.GreetingController;
import hello.greetings.Greeting;
import hello.greetings.helloWorld;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicLong;

public class GreetingControllerTest {

    @Mock
    AtomicLong counter;
    @InjectMocks
    GreetingController greetingController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGreeting() {
        Greeting result = greetingController.greeting("name");
        Assert.assertEquals(result.getContent(), "Hello, name!");
    }

    @Test
    public void testHelloworld() {
        helloWorld result = greetingController.helloworld();
        Assert.assertEquals(result.getMessage(), "Hello, World!", "Expect Hello, World!");
    }
}