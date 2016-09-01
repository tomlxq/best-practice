package com.example;

/**
 * Created by tom on 2016/8/31.
 * ").addResourceLocations("/");
 * }
 * }
 */
/*@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("*/
/**").addResourceLocations("/");
 }
 }*/
/*

@Configuration
public class MyWebMvcConfig {

    @Bean
    public WebMvcConfigurerAdapter forwardToIndex() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                // forward requests to /admin and /user to their index.html
                registry.addViewController("/").setViewName(
                        "forward:/index.html");

            }
        };
    }

}*/
