
@selenium
Feature: Teste das funções do restpoint

  Scenario: Teste de criação de usuario
    Given Open the Chrome and launch the applications
    When start create a user with firstName as "LOLA" and lastName as "paluza" and email as "lollapaluza@gmail.com" and phone as "988923140" and company as "lollaPaluza"
    Then I verify the status in step if "200"
