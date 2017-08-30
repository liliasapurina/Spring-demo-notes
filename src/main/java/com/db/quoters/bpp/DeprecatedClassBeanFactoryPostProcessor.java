package com.db.quoters.bpp;

import com.db.quoters.DeprecatedClass;
import org.reflections.Reflections;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

public class DeprecatedClassBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> deprecatedClasses = beanFactory.getBeansWithAnnotation(DeprecatedClass.class);
        for (String s : deprecatedClasses.keySet()) {
            String newBeanName = deprecatedClasses.get(s).getClass().getAnnotation(DeprecatedClass.class).value().getName();
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(s);
            beanDefinition.setBeanClassName(newBeanName);
            beanDefinition.setBeanClass(deprecatedClasses.get(s).getClass().getAnnotation(DeprecatedClass.class).value());
            System.out.println(beanDefinition);
        }
    }
}
