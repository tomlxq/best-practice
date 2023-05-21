package com.tom.example1.config;

import com.tom.example1.domain.PathVersionHandlerMapping;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * WebMvcConfiguration
 *
 * @author TomLuo
 * @date 2023年05月13日 5:13
 */
@Configuration
public class WebMvcConfiguration implements WebMvcRegistrations {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new PathVersionHandlerMapping();
    }

}