package com.mingo.helper;

import com.mingo.constant.Global;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Map.Entry;
import java.util.Properties;


public class CustomizedPropertyConfigurer extends PropertyPlaceholderConfigurer {

    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {
        super.processProperties(beanFactory, props);
        for (Entry<Object, Object> entry : props.entrySet()) {
            Global.SPRING_PROPERTIES.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
        }
    }

}
