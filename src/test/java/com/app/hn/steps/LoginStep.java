package com.app.hn.steps;

import com.app.hn.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginStep extends LoginPage {
    @Step("Esperar que la app abra")
    public void waitApp() {
        System.out.println("Esperando a que el botón 'Sign-In' esté disponible...");

        withTimeoutOf(Duration.ofSeconds(35))
                .waitFor(ExpectedConditions.elementToBeClickable(btn_signIn));

        System.out.println("¡La aplicación está lista para interactuar!");
    }

    @Step("Abrir manualmente la app")
    public void openApp() {
        System.out.println("app abierta");
    }

    @Step("Click en boton Sign-in")
    public void clickSignIn() {
        waitFor(btn_signIn).isVisible();
        btn_signIn.click();
    }

    @Step("Ingresar usuario")
    public void typeUsername(String username){
        txt_username.sendKeys(username);
    }

    @Step("Ingresar contraseña")
    public void typePassword(String password){
        txt_password.sendKeys(password);
    }

    @Step("Click en el boton login")
    public void clickLogin(){
        waitFor(btn_logIn).isClickable();
        btn_logIn.click();
    }

    @Step("Esperar el acceso")
    public void waitForHome(){
        withTimeoutOf(Duration.ofSeconds(25))
                .waitFor(ExpectedConditions.elementToBeClickable(btn_cancelPopUp));

        try {
            Thread.sleep(5000); // 5000 milisegundos = 5 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println("Haciendo clic en el botón.");
        btn_cancelPopUp.click();
    }


}
