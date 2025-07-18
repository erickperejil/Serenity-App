package com.app.hn.definitions;

import com.app.hn.pages.TranfersPage;
import com.app.hn.steps.LoginStep;
import com.app.hn.steps.TransferStep;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;

public class TransferDef {

    TranfersPage transferPage;

    @Steps
    LoginStep login;

    @Steps
    TransferStep transfer;

    @Given("el usuario ha iniciado sesión correctamente en la aplicación")
    public void login() {
        // Aquí puedes reutilizar los pasos de login o asegurar que la sesión está activa.
        // Ejemplo:
        login.waitApp();
        login.clickSignIn();
        login.typeUsername("jgarcia3");
        login.typePassword("Ficohsa2025");
        login.clickLogin();
        login.waitForHome();
    }

    @When("el usuario navega a la sección de transferencias a cuentas propias")
    public void navigateToTransfer() {
        transfer.navigateToTransfer();
        transfer.selectOwnAccountTransfer();
    }

    @And("el usuario completa el formulario de transferencia con los siguientes datos:")
    public void completeForm() {
       transfer.clickOnSourceAccount();
       transfer.selectSourceAccount();
       transfer.clickOnTargetAccount();
       transfer.selectTargetAccount();
       transfer.clickOnAmount();
       transfer.selectAmount();
       transfer.typeConcept("prueba de automatizacion");
       transfer.clickOnConfirm();
    }

    @And("el usuario confirma la transacción")
    public void confirmTransaction() {
        transfer.clickOnContinue();
    }

    @Then("el sistema muestra el comprobante de la transacción exitosa")
    public void showResults() {
        transfer.resultIsDisplayed();
    }
}
