package com.tom.web.config;

import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by tom on 2016/6/1.
 */
@Configuration
@ComponentScan(basePackages = { "com.tom.web"})
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
Logger logger= LoggerFactory.getLogger(WebMvcConfig.class);
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        super.addViewControllers(registry);
        registry.addViewController("login/form").setViewName("login");
        registry.addViewController("welcome").setViewName("welcome");
        registry.addViewController("admin").setViewName("admin");
    }

    @Bean
    public ViewResolver getJspViewResolver()
    {
        InternalResourceViewResolver url = new InternalResourceViewResolver();
        //classpath:/templates/hello.jsp
        url.setPrefix("/WEB-INF/classes/templates/");
        url.setSuffix(".jsp");
        url.setOrder(1);
        return url;
    }
    @Bean
    public FreeMarkerViewResolver getFmViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(true);
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setContentType("text/html; charset=UTF-8");
        resolver.setOrder(0);
        return resolver;
    }
    @Bean
    public FreeMarkerConfigurer freemarkerConfig() throws IOException, TemplateException {
        FreeMarkerConfigurationFactory factory = new FreeMarkerConfigurationFactory();
        factory.setTemplateLoaderPath("classpath:templates");
        factory.setDefaultEncoding("UTF-8");
        FreeMarkerConfigurer result = new FreeMarkerConfigurer();
        result.setConfiguration(factory.createConfiguration());
        return result;
    }
    @Bean
    public ViewResolver contentNegotiatingViewResolver(
            ContentNegotiationManager manager) {
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
        resolvers.add(getFmViewResolver());
        resolvers.add(getJspViewResolver());


        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setViewResolvers(resolvers);
        resolver.setContentNegotiationManager(manager);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

    @Bean(name = "messageSource")
    public MessageSource configureMessageSource()
    {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver()
    {
        SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.put("org.springframework.dao.DataAccessException", "error");
        b.setExceptionMappings(mappings);
        return b;
    }
}
