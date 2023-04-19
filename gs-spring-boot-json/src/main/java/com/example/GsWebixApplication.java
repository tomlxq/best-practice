package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class GsWebixApplication implements CommandLineRunner {
    /**
     * -Dos.name=linux
     */
    final Environment environment;

    @Override
    public void run(String... args) throws Exception {
        log.info("~~{}",  System.getProperty("os.name"));
        log.info("~~{}", environment.getProperty("os.name"));
    }


    public static void main(String[] args) {
        //-Dos.name=linux
        System.setProperty("os.name", "Linux");
        SpringApplication.run(GsWebixApplication.class, args);
    }
}
