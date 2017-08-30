package com.db.quoters.bpp;

import com.db.quoters.DeprecatedClass;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Map;

public class DeprecatedClassBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> deprecatedClasses = beanFactory.getBeansWithAnnotation(DeprecatedClass.class);
        for (String deprecatedClassName : deprecatedClasses.keySet()) {
            String newBeanName = deprecatedClasses.get(deprecatedClassName).getClass().getAnnotation(DeprecatedClass.class).value().getName();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(deprecatedClassName);
            beanDefinition.setBeanClassName(newBeanName);
            ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition(deprecatedClassName, beanDefinition);
        }
    }
}
