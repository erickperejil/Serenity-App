@Suite @Login
Feature: CP01 - Validar inicio de sesion

  Background: Validar el inicio de sesion con credenciales validas e invalidas

    Given el usuario entra a la app

  @ValidCredentials
  Scenario: 1 - Validar con credenciales correctas
    When ingresa credenciales validas
    Then la aplicacion muestra el modulo principal
