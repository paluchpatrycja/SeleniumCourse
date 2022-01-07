Feature: Creating new address in already existing account
  Scenario Outline: Can create new address as logged-in user
    Given Logged-in user is on new address page
    When User fills out form with data: <alias>, <address>, <zipCode>, <city>, <selectCountry>, <phoneNumber>
    Then Click SAVE button
    And The note 'Address successfully added!' on the green box will appear
    Examples:
    |alias |address    |zipCode|city  |selectCountry |phoneNumber|
    |PatPal|ul. Jana 23|11-222 |Warsaw|United Kingdom|111222333  |

