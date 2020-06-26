Feature: Removing item from the cart

  As a user, I want to be able to remove an item from the cart

  Background:
    Given User navigates to the allegro website


  Scenario: Add item to the cart
    When User searches for "iPhone 11 PRO"
    And will go to the eny item page
    And will add item to the cart
    And remove item from the cart
    Then the cart is empty