package org.example.reflection;

import org.example.annotation.AutoInjectable;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    Properties properties = getProperties();

    /**
     * takes an object of any class as a parameter and, using reflection mechanisms,
     * searches for fields marked with the AutoInjectable annotation and
     * initializes these fields with instances of classes that are specified as an
     * implementation of the corresponding interface in the properties file
     * @param object object whose fields should be initialized
     * @return the same object, but with initialized fields
     * @throws Exception an exception is thrown if incorrect information is written in the properties file
     */
    public Object inject(Object object) throws Exception {
        Field[] fields = object.getClass().getDeclaredFields();
        Class c;
        for (Field field : fields) {
            field.setAccessible(true);
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation.annotationType().equals(AutoInjectable.class)) {
                    c = Class.forName(properties.get(field.getType().getName()).toString());
                    field.set(object, c.newInstance());
                }
            }
        }
        return object;
    }

    /**
     * takes information from the properties file
     * @return object of the Properties type, containing information from the properties file
     */
    private Properties getProperties() {
        FileInputStream fis;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/application.properties");
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
