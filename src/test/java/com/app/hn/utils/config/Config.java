package com.app.hn.utils.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Archivo config.properties no encontrado.");
            }
            props.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error al leer config.properties", ex);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
