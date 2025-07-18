@Suite @Transferencias
Feature: CP02 - Realizar transferencia a cuentas propias

  Background: Usuario autenticado en la aplicación
  Given el usuario ha iniciado sesión correctamente en la aplicación

@TransaccionACuentasPropias
Scenario: 1 - Realizar una transferencia exitosa entre cuentas propias
When el usuario navega a la sección de transferencias a cuentas propias
And el usuario completa el formulario de transferencia con los siguientes datos:
And el usuario confirma la transacción
Then el sistema muestra el comprobante de la transacción exitosa