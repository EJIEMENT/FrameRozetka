Feature: rozetka
  As a user
  Im able to add products to my wish list

  Scenario Outline: Check count of item in wish list
    Given User open rozetka home page
    And User search item by '<item>'
    And User add two product to wish list
    And User is navigate to wish list
    Then There should be two products in wish list
    Examples:
      | item         |
      | Phone        |
      | Powerstation |


  Scenario Outline: Check item price
    Given User open rozetka home page
    And User search item by '<item>'
    And User choose first product
    Then There should be the price less than '<price>'
    Examples:
      | item      | price  |
      | microwave | 100000 |