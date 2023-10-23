package com.example.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfiguration2 implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        String[] list = registry.getBeanDefinitionNames();
        for(String n: list){
            System.out.println(n);
        }
        registry.removeBeanDefinition("getProxies");
        registry.registerBeanDefinition("getProxies", registry.getBeanDefinition("getProxies2") );
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    class TestBean2 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Bean("testBean2")
    public TestBean2 testBean(){
        return new TestBean2();
    }

    @Bean
    public List<String> getProxies2(){
        return List.of("printix-device", "printix-oxpd-device");
    }
}
