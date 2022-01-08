Feature: Buying a product in PrestaShop
 Scenario Outline: Can buy a product as logged-in user
    Given User is logged in on homepage
   When User searches for the <productName>
   Then Go into <productName> page
   And Can select size: <productSize>
   And Can select quantity: <quantity>
   And Can add to cart
   Then User can proceed to checkout
   And Confirm address
   And Select delivery method: <deliveryMethod>
   And Select payment method: Pay by Check
   Then Can place an order
   And Take a screenshot for confirmation
   Examples:
   |productName                |productSize|quantity|deliveryMethod|
   |Hummingbird Printed Sweater|M          |5       |PrestaShop    |