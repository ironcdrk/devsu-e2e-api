Feature: Pruebas API para registro y login en DemoBlaze

  Background:
    * url baseUrl
    * def randomId = new Date().getTime()
    * def username = 'user_' + randomId
    * def password = 'Password123'

  Scenario: Crear un nuevo usuario en signup
    Given path 'signup'
    And request
      """
      {
        "username": "#(username)",
        "password": "#(password)"
      }
      """
    When method post
    Then status 200

  Scenario: Intentar crear un usuario ya existente en signup
    Given path 'signup'
    And request
      """
      {
        "username": "#(username)",
        "password": "#(password)"
      }
      """
    When method post
    Then status 200

    Given path 'signup'
    And request
      """
      {
        "username": "#(username)",
        "password": "#(password)"
      }
      """
    When method post
    Then status 200
    And match response.errorMessage == 'This user already exist.'

  Scenario: Login con usuario y password correctos
    Given path 'signup'
    And request
      """
      {
        "username": "#(username)",
        "password": "#(password)"
      }
      """
    When method post
    Then status 200

    Given path 'login'
    And request
      """
      {
        "username": "#(username)",
        "password": "#(password)"
      }
      """
    When method post
    Then status 200
    #And match response.Auth_token == '#string'
    And match response contains 'Auth_token:'

  Scenario: Login con usuario y password incorrectos
    Given path 'login'
    And request
      """
      {
        "username": "#(username)",
        "password": "WrongPassword123"
      }
      """
    When method post
    Then status 200
    And match response.errorMessage == 'User does not exist.'