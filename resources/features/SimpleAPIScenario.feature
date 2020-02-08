Feature: Exchange Rate API related tests

  @smoke @regression @api
  Scenario Outline: user sends get exchange rate for <ticker symbol> request
    When user sends GET exchange rate api request for "<ticker symbol>"
    Then "<status code>" should be returned

    Examples:
      | ticker symbol | status code |
      | USD           | 200         |
      | EUR           | 200         |
      | CAD           | 200         |
      | JPY           | 200         |

  @smoke @regression @api @apiNegative
  Scenario Outline: user tries to get exchange rates for invalid currency
    When user sends GET exchange rate api request for "<ticker symbol>"
    Then "<status code>" should be returned
    And error message with following "<mandatory field>" should be returned

    Examples:
      | ticker symbol | status code | mandatory field        |
      | XXX           | 404         |  unsupported_code      |

