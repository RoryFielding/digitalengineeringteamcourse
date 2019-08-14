package test.greetings;

import hello.greetings.helloWorld;
import org.testng.Assert;
import org.testng.annotations.Test;

public class helloWorldTest {

    @Test
    void setup() {
        System.out.println("Setting up helloWorld test");
    }

    @Test
    void testMessage(){
        System.out.println("Test Message");
        helloWorld testHelloWorld = new helloWorld("test message");
        Assert.assertEquals("test message", testHelloWorld.getMessage(), "test message");
    }
}
