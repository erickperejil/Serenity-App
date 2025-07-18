package com.app.hn.utils.drivers;

// Asegúrate de que la ruta a tu clase Config sea la correcta
import com.app.hn.utils.config.Config;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class SauceAndroidDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        System.out.println("Instanciando SauceAndroidDriver personalizado desde config.properties");

        // 1. Configuración específica de Sauce Labs leída desde el archivo de config
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", Config.get("sauce.username"));
        sauceOptions.setCapability("accessKey", Config.get("sauce.accesskey"));
        sauceOptions.setCapability("appiumVersion", "latest"); // Se puede mantener o añadir a config
        sauceOptions.setCapability("build", Config.get("sauce.build"));
        sauceOptions.setCapability("name", Config.get("sauce.test.name"));

        // 2. Capacidades generales leídas desde el archivo de config
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", Config.get("android.platform.name"));
        capabilities.setCapability("appium:deviceName", Config.get("android.device.name"));
        capabilities.setCapability("appium:platformVersion", Config.get("android.platform.version"));
        capabilities.setCapability("appium:automationName", Config.get("android.automation.name"));
        capabilities.setCapability("appium:app", Config.get("android.app.id"));

        // 3. Anidar las opciones de Sauce Labs dentro de las capacidades principales
        capabilities.setCapability("sauce:options", sauceOptions);

        try {
            // 4. Construir la URL desde el archivo de config
            URL sauceUrl = new URL(Config.get("sauce.url"));
            System.out.println("Intentando conectar con Sauce Labs en: " + sauceUrl);
            AndroidDriver driver = new AndroidDriver(sauceUrl, capabilities);
            System.out.println("Driver de Sauce Labs creado con éxito");
            return driver;
        } catch (Exception e) {
            System.err.println("Error al crear el AndroidDriver para Sauce Labs:");
            e.printStackTrace();
            throw new RuntimeException("No se pudo instanciar el AndroidDriver con Sauce Labs", e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}