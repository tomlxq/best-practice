package com.example.goodcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RawController
 *
 * @author TomLuo
 * @date 2023年03月24日 6:23
 */
@RestController
public class RawController {


    private TestService testService;

    @PostMapping("/testRaw")
    public Double test(@RequestBody TestDTO testDTO) {
        try {
            Double result = this.testService.service(testDTO);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

}