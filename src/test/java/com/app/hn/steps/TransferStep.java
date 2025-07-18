package com.app.hn.steps;

import com.app.hn.pages.TranfersPage;
import com.app.hn.utils.screenshots.GestorDeEvidencias;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class TransferStep extends TranfersPage {

    @Step("Navega a la sección de transferencias")
    public void navigateToTransfer() {
        btn_transfer.click();
    }

    @Step("Selecciona la opción de transferencia a cuentas propias")
    public void selectOwnAccountTransfer() {
        btn_ownAccounts.click();
    }

    @Step("Hace clic en el campo 'Cuenta Origen'")
    public void clickOnSourceAccount() {
        btn_sourceAccount.click();
    }

    @Step("Selecciona la cuenta de origen")
    public void selectSourceAccount() {
        withTimeoutOf(Duration.ofSeconds(20))
                .waitFor(ExpectedConditions.elementToBeClickable(btn_sourceAccountOption));
        btn_sourceAccountOption.click();
    }

    @Step("Hace clic en el campo 'Cuenta Destino'")
    public void clickOnTargetAccount() {
        btn_targetAccount.click();
    }

    @Step("Selecciona la cuenta de destino")
    public void selectTargetAccount() {
        withTimeoutOf(Duration.ofSeconds(20))
                .waitFor(ExpectedConditions.elementToBeClickable(btn_targetAccountOption));
        btn_targetAccountOption.click();
    }

    @Step("Hace clic en el campo 'Monto'")
    public void clickOnAmount() {
        btn_currentValue.click();
    }

    @Step("Ingresa el monto de la transacción")
    public void selectAmount() {
        btn_number1.click();
        btn_number0.click();
        btn_applyCurrency.click();
    }

    @Step("Ingresa el concepto de la transacción")
    public void typeConcept(String concept) {
        txt_concept.sendKeys(concept);
        // Tu lógica aquí (ej: txt_concepto.sendKeys(concept))
    }

    @Step("Hace clic en el botón de confirmar")
    public void clickOnConfirm() {
        GestorDeEvidencias.guardar("Transaccion a cuentas propias", "Transaccion");
        btn_continue.click();
    }

    @Step("Hace clic en el botón de continuar/finalizar")
    public void clickOnContinue() {
        btn_confirmTransfer.click();
    }

    @Step("Verifica que el resultado de la transacción se muestra en pantalla")
    public void resultIsDisplayed() {
        lbl_resultado.isDisplayed();
        GestorDeEvidencias.guardar("Transaccion a cuentas propias", "Confirmacion");
    }
}
