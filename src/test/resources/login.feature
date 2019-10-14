Feature: login

  @login
  Scenario Outline: Attemp to log into web site with valid and invalid email addresses and passwords
  The valid email address have been pre-registered with the website
    Given I am on the mystore home page
    When I click on sign in
    When I enter "<emailaddress>" with "<password>"
    Then I should be on the "<page>" page

    Examples:
      | emailaddress      | password | page                  |
      | dummy@yahoo.co.uk | DUMMY    | My account - My Store |
      | jo1@test17.com    | wrongpwd | Login - My Store      |
      | jo292@test177.com | dummy123 | My account - My Store |
      | none@yahoo.co.uk  | abc123   | Login - My Store      |
