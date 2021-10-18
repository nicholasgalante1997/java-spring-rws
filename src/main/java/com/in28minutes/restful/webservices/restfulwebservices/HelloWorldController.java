package com.in28minutes.restful.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * The below annotation indicates that this class is a restful controller,
 * and that it contains paths that are intended to be valid http endpoints;
 * */
@RestController
public class HelloWorldController {
    /**
     * The below annotation mapping corresponds to the "GET" http method,
     * which is what this method expects to handle, at the indicated
     * path, which is /hello-world
     * */
    @GetMapping(path = "/hello-world")
    public String helloWorld () {
        System.out.println("logger: handling incoming \"GET\" request");
        return "Hello World";
    };

    @GetMapping(path = "/hello-world/echo/{pathVariable}")
    public String helloWorld (@PathVariable String pathVariable) {
        System.out.println("logger: handling incoming \"GET\" request");
        return pathVariable;
    };
}
