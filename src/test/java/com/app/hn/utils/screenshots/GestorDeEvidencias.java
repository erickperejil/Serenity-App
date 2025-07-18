package com.app.hn.utils.screenshots;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorDeEvidencias {

    private static final String EVIDENCIAS_BASE_DIR = "target/evidencias";

    /**
     * Guarda una captura de pantalla en una ruta personalizada.
     * @param nombreFeature El nombre del feature o caso de prueba (se usará para crear una subcarpeta).
     * @param nombrePaso    Un nombre descriptivo para la evidencia (se usará en el nombre del archivo).
     */
    public static void guardar(String nombreFeature, String nombrePaso) {
        try {
            // 1. Limpiar el nombre del feature para usarlo como nombre de carpeta
            String sanitizedFeatureName = nombreFeature.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
            Path targetDirectory = Paths.get(EVIDENCIAS_BASE_DIR, sanitizedFeatureName);
            Files.createDirectories(targetDirectory);

            // 2. Tomar la captura de pantalla
            WebDriver driver = Serenity.getDriver();
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // 3. Crear un nombre de archivo único con la fecha y hora
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date());
            String newFileName = String.format("%s_%s.png", nombrePaso, timestamp);

            // 4. Mover el archivo a la carpeta de destino
            Path destinationPath = targetDirectory.resolve(newFileName);
            Files.copy(screenshot.toPath(), destinationPath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Evidencia guardada en: " + destinationPath);

        } catch (Exception e) {
            System.err.println("Error al guardar evidencia: " + e.getMessage());
            e.printStackTrace();
        }
    }
}