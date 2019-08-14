package test.greetings;

import hello.greetings.Greeting;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GreetingTest {

    @Test
    void setup() {
        System.out.println("Setting up greeting test");
    }

    @Test
    void testId(){
        System.out.println("Test Id");
        Greeting testGreeting = new Greeting(1, "test");
        Assert.assertEquals(1, testGreeting.getId(), "Initial Id is 1");
    }

    @Test
    void testContent(){
        System.out.println("Test Content");
        Greeting testGreeting = new Greeting(1, "test");
        Assert.assertEquals("test", testGreeting.getContent(), "Content is test");
    }

}
