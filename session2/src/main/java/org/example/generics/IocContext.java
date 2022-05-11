package org.example.generics;

import java.util.HashMap;
import java.util.Map;

public class IocContext {
    private Map<String, Object> beansByName = new HashMap<>();

    public void addBean(String name, Object bean) {
        beansByName.put(name, bean);
    }

    public Object getBean(String name) {
        return beansByName.getOrDefault(name, null);
    }

    public <T> T getBean(String name, Class<T> cls) {

        Object bean = beansByName.getOrDefault(name, null);
        if (!cls.isInstance(bean)) {
            return null;
        }

        return cls.cast(bean);
    }
}
