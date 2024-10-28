package com.enuygun.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//properties den bir değişken oluşturur ve dosyayı yükler
public class ConfigReader {
    private final Properties properties;

    public ConfigReader(String filePath) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Gelen anahtara göre properties dosyasından aldığı değeri döndürür
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
