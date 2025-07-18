package com.app.hn.definitions;

import com.app.hn.steps.LoginStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class LoginDef {
    @Steps
    LoginStep login;

    @Given("el usuario entra a la app")
    public void userNavigateTo(){
        login.waitApp();
    }

    @When("ingresa credenciales validas")
    public void userLoginWithValidCredentials(){
        login.clickSignIn();
        login.typeUsername("jgarcia3");
        login.typePassword("Ficohsa2025");
        login.clickLogin();
    }

    @Then("la aplicacion muestra el modulo principal")
    public void systemShowProductosModule(){
        System.out.println("jsjs");
    }
}
