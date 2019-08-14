package hello.controllers;

import java.util.concurrent.atomic.AtomicLong;

import hello.greetings.Greeting;
import hello.greetings.helloWorld;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "Hello, %s!";
    private static final String SECONDTEMPLATE = "Hello, World!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(TEMPLATE, name));
    }

    @GetMapping("/helloWorld")
    public helloWorld helloworld() {
        return new helloWorld(String.format(SECONDTEMPLATE));
    }

}