Feature: hello world

  Scenario Outline: client with a name makes call to GET /hello
    When The client with name <name> calls /hello
    Then The client with name <name> receives <expected>
    Examples:
      | name  | expected    |
      | Pippo | Ciao Pippo! |

  Scenario Outline: client with no name makes call to GET /hello
    When The client with no name calls /hello
    Then The client with no name receives <expected>
    Examples:
      | expected    |
      | Ciao mondo! |
