Feature: Adding item to the cart

  Background:
    Given User navigates to the allegro website


  Scenario: Add used item more than 200PLN to the cart
    When User searches for "iPhone 6S"
    And Set minimum price to 200 PLN
    And check used checkbox
    And will go to the eny item page
    And will add item to the cart
    Then the item is added to the cart