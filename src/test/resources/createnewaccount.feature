Feature: Account creation
  Users needing to purchase items from the webite need to create a new account

  Background: Navgigate to the homepage and select login
    Given I am on the mystore home page
    When I click on sign in
    Then I should be on the "Login - My Store" page

  @createaccount
  Scenario: Create new account using all available fields, mandatory and optional
    When I create and account with my email address
    And register personal information
      | Title | FN     | LN     | Password | DOB      | SignUp | Offers | Firstname | Lastname | Company | Addr1    | Addr2  | City     | State    | Zip   | Country       | Additional      | Mobile      | Phone     | Alias      |
      | Mr    | testjo | testow | dummy123 | 1-1-1980 | yes    | yes    | testjo    | testow   | mycomp  | 1 Street | Floor1 | New York | New York | 12345 | United States | additional text | 12345678901 | 012341234 | Alias name |
    Then I should be on the "My account - My Store" page


  Scenario: Create new account using only mandatory fields
    When I create and account with my email address
    And register personal information
      | Title | FN     | LN     | Password | DOB | SignUp | Offers | Firstname | Lastname | Company | Addr1    | Addr2 | City     | State    | Zip   | Country       | Additional | Mobile      | Phone | Alias |
      |       | testjo | testow | dummy123 |     |        |        | testjo    | testow   |         | 1 Street |       | New York | New York | 12345 | United States |            | 12345678901 |       | Alias |
    Then I should be on the "My account - My Store" page


  Scenario: Failed attempt to create new account with missing mandatory field
    When I create and account with my email address
    And register personal information
      | Title | FN     | LN     | Password | DOB | SignUp | Offers | Firstname | Lastname | Company | Addr1    | Addr2 | City     | State    | Zip   | Country       | Additional | Mobile      | Phone | Alias |
      |       |        | testow | dummy123 |     |        |        | testjo    | testow   |         | 1 Street |       | New York | New York | 12345 | United States |            | 12345678901 |       | Alias |
    Then I should be on the "Login - My Store" page
