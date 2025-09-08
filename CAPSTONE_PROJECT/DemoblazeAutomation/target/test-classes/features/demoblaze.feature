Feature: Demoblaze Multiple Product Purchase

  Scenario: Signup, Login, Add multiple products to cart, place order and logout
    Given I signup with username "Peeyush1717" and password "goku@1717"
    And I login with username "Peeyush1717" and password "goku@1717"
    When I add the following products to the cart
      | Category | Product        |
      | Laptops  | Sony vaio i5   |
      | Phones   | Samsung galaxy s6 |
    And I place the order with details Name "Peeyush Pal Singh", Country "India", City "Agra", CreditCard "9900990099", Month "09", Year "2025"
    Then the order should be placed successfully
    And I log out from the application