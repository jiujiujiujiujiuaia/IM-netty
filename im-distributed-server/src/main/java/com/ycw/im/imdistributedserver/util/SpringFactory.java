package com.ycw.im.imdistributedserver.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author yuchunwei
 * 如果注册到spring容器中的类是实现了ApplicationContextAware接口的话，在
 * 加载spring配置文件时，会自动调用setApplicationContext方法，获得springcontent
 * 这样做的好处是，可以动态的通过spring容器获得spring容器中的bean
 */
@Component
public class SpringFactory implements ApplicationContextAware {
    private static ApplicationContext context;

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

}   
