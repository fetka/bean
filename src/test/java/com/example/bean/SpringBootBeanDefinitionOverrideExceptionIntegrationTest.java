package com.example.bean;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfiguration1.class, TestConfiguration2.class})
public class SpringBootBeanDefinitionOverrideExceptionIntegrationTest {

    @Autowired
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @BeforeEach
    public void setup() {
//        System.exit(1);
    }

    @Test
    public void whenBeanOverridingAllowed_thenTestBean2_overridesTestBean1() {
        Object testBean2 = applicationContext.getBean("testBean2");

        assertThat(testBean2.getClass()).isEqualTo(TestConfiguration2.TestBean2.class);
    }

    //     List.of("printix-device", "printix-oxpd-device");
    @Test
    public void proxiesTest() {
        String newService = "printix-oxpd-device";
//        Object list = applicationContext.getBean("getProxies");

        Object list2 = applicationContext.getBean("getProxies2");
        String [] names = applicationContext.getBeanDefinitionNames();

//        DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) applicationContext.getAutowireCapableBeanFactory();
//        registry.destroySingleton("TestConfiguration1");
//
//        AbstractBeanDefinition definition = BeanDefinitionBuilder
//                .genericBeanDefinition("TestConfiguration1")
//                .addPropertyValue("class", applicationContext.getBean("getProxies2"))
//                .getBeanDefinition();
//
//        System.out.println(definition.toString());
//        ((DefaultListableBeanFactory) configurableListableBeanFactory).removeBeanDefinition("ant");

//        System.out.println(list.toString());
//        Predicate<Boolean> listPredicate =
//                d -> (list.containsAll(List.of("printix-device", "printix-oxpd-device")));
        List<String> list3 = (List<String>) applicationContext.getBean("getProxies");
        List<String> list4 = (List<String>) applicationContext.getBean("getProxies2");
        System.out.println("list3= " + list3);
        System.out.println("list4= " + list4);
        for( String name: names){
            System.out.println(name);
        }
//        assertThat(list3.contains(newService)).isTrue();
//        assertThat(list.contains("printix-device")).isTrue();
//        assertThat(list.size()).isEqualTo(2);
//        Object list2 = applicationContext.getBean("getProxies2");

    }


}
