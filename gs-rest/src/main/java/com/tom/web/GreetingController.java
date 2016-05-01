package com.tom.web;

/**
 * Created by tom on 2016/5/1.
 */
import java.util.concurrent.atomic.AtomicLong;

import com.tom.pojo.Greeting;
import com.tom.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController extends BaseController{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

        @RequestMapping("/person")
        public @ResponseBody
        Person showPerson() {
            //logger.debug("{}","test changes!");
            return new Person("tom","tom@gmail.com");
        }

}