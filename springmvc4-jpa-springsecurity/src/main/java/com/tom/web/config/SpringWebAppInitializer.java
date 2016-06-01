package com.tom.web.config;

import com.tom.config.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by tom on 2016/6/1.
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{

    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class<?>[] { AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings()
    {

        return new String[] { "/" };
    }

  /*  @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{
                new DelegatingFilterProxy("springSecurityFilterChain"),
                new OpenEntityManagerInViewFilter()};
    }*/


}