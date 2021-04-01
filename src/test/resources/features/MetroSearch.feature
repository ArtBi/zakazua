@SOME_JIRA_TASK
Feature: User should be able to search items on Metro portal


  @SmokeTest
  Scenario Outline: Verify that metro portal returns right count of items
    Given Metro portal is opened
    When I search the following item <item>
    Then On the page are present more then <minimum_count> items

    Examples:
      | item    | minimum_count |
      | "банан" | 5             |
      | "кава"  | 3             |