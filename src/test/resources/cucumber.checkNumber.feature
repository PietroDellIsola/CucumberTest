Feature: check numbers

  Scenario Outline: client makes call to POST /checkNumber
    When The client send the body request <request> with a number
    Then The client receives <expected>
    Examples:
      | request      | expected                   |
      | {"number":1} | Il numero è dispari!       |
      | {"number":2} | Il numero è pari!          |
      | {}           | Nessun numero specificato! |