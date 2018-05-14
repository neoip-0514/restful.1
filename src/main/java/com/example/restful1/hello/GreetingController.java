package com.example.restful1.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
	
	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET)
	public Greeting greeting2(@PathVariable(name="name") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
}
