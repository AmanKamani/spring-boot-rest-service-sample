package jb.production.restwebservice.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// declare as a controller
@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/r/hello-world")
    public String requestHelloWorld(){
        return "Request - Hello World";
    }

    @GetMapping(path = "/hello-world")
    public Integer helloWorld(){
        return 10;
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWrold(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world-bean/{message}")
    public HelloWorldBean helloWrold(@PathVariable String message){
        return new HelloWorldBean(String.format("Hello World, %s", message));
    }
}
