@All @Saucelab
Feature: Verify item selection via saucelabs.

  @Positive
  Scenario Outline:01 Verify that the standard user can login to saucelabs and select three items randomly
    Given Login to saucelabs using valid credentials from file "<fileName>" sheet "<sheetName1>" and row <row>
    And Select three available items randomly
    And Click on Cart button
    And Click on Checkout button
    And Enter checkout information from file "<fileName>" sheet "<sheetName1>" and row <row>
    And Click Continue button
    When Click Finish Button
    Then Validate the confirmation message

    Examples:
      | fileName                 | sheetName1   | row |
      | TestInput_SauceLabs.xlsx | StandardUser | 0   |

  @Negative
  Scenario Outline:02 Verify that an appropriate error will be displayed if the entered user is a locked user
    Given Enter UserName from file "<fileName>" sheet "<sheetName1>" and row <row>
    And Enter Password from file "<fileName>" sheet "<sheetName1>" and row <row>
    When Click on Login button
    Then Validate the Lockedout error message

    Examples:
      | fileName                 | sheetName1    | row |
      | TestInput_SauceLabs.xlsx | LockedOutUser | 0   |
    
  @Negative
  Scenario Outline:03 Verify that an appropriate error will be displayed if the entered user credentials is invalid
    Given Enter UserName from file "<fileName>" sheet "<sheetName1>" and row <row>
    And Enter Password from file "<fileName>" sheet "<sheetName1>" and row <row>
    When Click on Login button
    Then Validate the Invalid User error message

    Examples:
      | fileName                 | sheetName1        | row |
      | TestInput_SauceLabs.xlsx | InvalidCredntials | 0   |