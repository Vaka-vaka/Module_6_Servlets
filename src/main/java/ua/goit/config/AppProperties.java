/**
 * ProjectManagementSystem. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 04.11.2021
 */

package ua.goit.config;

import java.io.IOException;
import java.util.*;

public class AppProperties {

    private static AppProperties value;
    private final Properties properties;

    private AppProperties() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        this.properties = new Properties();
        try {
            properties.load(classLoader.getResourceAsStream("application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        if(value == null) {
            value = new AppProperties();
        }
        return value.properties;
    }
}
