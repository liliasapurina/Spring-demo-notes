package com.db.quaters;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

public class InjectRandomIntLogic implements BeanPostProcessor {
    private Random random = new Random();

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object var1, String var2) throws BeansException{
        Class<?> type = var1.getClass();
        Set<Field> fields = ReflectionUtils.getAllFields(type);
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int value = min + random.nextInt(max - min + 1);
                field.setAccessible(true);
                field.setInt(var1, value);
            }
        }
        return var1;
    }

    @Override
    public Object postProcessAfterInitialization(Object var1, String var2) throws BeansException{
        return var1;
    }
}
