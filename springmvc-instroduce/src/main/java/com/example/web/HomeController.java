package com.example.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: TOM
 * Date: 2016/5/21
 * email: beauty9235@gmail.com
 * Time: 15:50
 */
@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = {"", "/"})
    public String index() {
        return "index";
    }

    @RequestMapping(value = "message", method = RequestMethod.GET)
    public ModelAndView message() {
        return new ModelAndView("message", "message", "Say hi for Freemarker.");

    }
}
