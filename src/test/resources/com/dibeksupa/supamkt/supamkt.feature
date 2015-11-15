Feature: Supermarket Check Out -  Implement a Supermarket checkout that calculates the total price of a number of items.
   

  Scenario: buy 3 (equals) items and pay for 2

    Given The customer bought this items
      | id | name            | price | discount |
      | 1  | mazing porridge | 5     | true     |
      | 1  | mazing porridge | 5     | true     |
      | 1  | mazing porridge | 5     | true     |
    And I apply the discount "ThreexTwo"

    And The system process the items

    Then CheckOut result will contain "ThreexTwo"

  Scenario: buy 2 (equals) items for a special price

    Given The customer bought this items
      | id | name            | price | discount | discountedPrice |
      | 1  | mazing porridge | 500   | true     | 400             |
      | 1  | mazing porridge | 500   | true     | 400             |

    And I apply the discount "Discountx2"

    And The system process the items

    Then CheckOut result will contain "Discountx2"

  Scenario: buy 3 (in a set of items) and the cheapest is free

    Given The customer bought this items
      | id | name             | price | discount |
      | 1  | mazing porridge  | 500   | true     |
      | 2  | star goat milk   | 300   | true     |
      | 2  | star goat milk   | 300   | true     |
      | 3  | star goat butter | 200   | true     |

    And I apply the discount "CheapeastOfThreexFree"

    And The system process the items

    Then CheckOut result will contain "CheapeastOfThreexFree"

  Scenario: for each N (equals) items X, you get K items Y for free
   
    Given The customer bought this items
      | id | name            | price | discount |
      | 1  | mazing porridge | 500   | true     |
      | 1  | mazing porridge | 500   | true     |
      | 1  | mazing porridge | 500   | true     |
      | 1  | mazing porridge | 500   | true     |
      | 2  | star goat milk  | 300   | true     |
      | 2  | star goat milk  | 300   | true     |
      | 2  | star goat milk  | 300   | true     |
      | 2  | star goat milk  | 300   | true     |
    And I apply the discount "CouponDiscount"

    And The system process the items

    Then CheckOut result will contain "CouponDiscount"