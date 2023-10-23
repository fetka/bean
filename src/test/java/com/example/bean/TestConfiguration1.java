package com.example.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfiguration1 {
    class TestBean1 {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Bean("testBean1")
    public TestBean1 testBean() {
        return new TestBean1();
    }

    @Bean
    public List<String> getProxies(){
        return List.of("printix-device");
    }
}
