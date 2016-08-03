package com.example;

		import org.slf4j.Logger;
		import org.slf4j.LoggerFactory;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class GsWebixApplication {
	private static final Logger logger = LoggerFactory.getLogger(GsWebixApplication.class);
	@RequestMapping(value={"","/"})
	public String index(){
		logger.debug("########");
		//return "index";
		return "redirect:index.html";
	}
	public static void main(String[] args) {
		SpringApplication.run(GsWebixApplication.class, args);
	}
}
