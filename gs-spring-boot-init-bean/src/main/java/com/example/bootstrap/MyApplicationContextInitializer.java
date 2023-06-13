package com.example.bootstrap;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * MyApplicationContextInitializer
 *
 * @author TomLuo
 * @date 2023年06月04日 15:36
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>/*, BeanDefinitionRegistryPostProcessor*/ {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // 注意，如果你同时还使用了 spring cloud，这里需要做个判断，要不要在 spring cloud applicationContext 中做这个事
        // 通常 spring cloud 中的 bean 都和业务没关系，是需要跳过的
        applicationContext.addBeanFactoryPostProcessor(new MyBeanDefinitionRegistryPostProcessor());
    }

   /* @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 手动注册一个 BeanDefinition
        registry.registerBeanDefinition("systemConfigService", new RootBeanDefinition(SystemConfigService.class));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }*/
}