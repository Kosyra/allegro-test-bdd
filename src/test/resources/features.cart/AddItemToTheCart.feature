Feature: Adding item to the cart

  As a user, I want to be able to set a minimum price for an item and add a used item to the cart

  Background:
    Given User navigates to the allegro website


  Scenario Outline: Add used item more than 200PLN to the cart
    When User searches for <Item>
    And Set minimum price to <Price> PLN
    And check used checkbox
    And will go to the eny item page
    And will add item to the cart
    Then the item is added to the cart

    Examples: Different items and minimum prices
    |Item           | Price |
    |"iPhone 6S"    | 200   |
    |"iPhone 11 PRO"| 3000  |