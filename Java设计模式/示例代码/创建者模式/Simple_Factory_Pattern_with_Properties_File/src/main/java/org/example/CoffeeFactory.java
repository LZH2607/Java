package org.example;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    private static Map<String, Coffee> m = new HashMap<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("project.properties");
        try {
            properties.load(inputStream);
            Set<Object> keys = properties.keySet();
            for (Object key : keys) {
                String className = properties.getProperty((String) key);
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                m.put((String) key, coffee);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Coffee createCoffee(String name) {
        return m.get(name);
    }
}
