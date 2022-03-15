Feature: This is feature contains all scenarios involves user

  @GetList
  Scenario: Verify that the status code return 200 when user get user list
    When user sen get request to get list user then the response show the list user

  @CreateUser
  Scenario Outline: Verify that admin can create user
    When The admin can create new user with "<name>" and "<job>"
    Then check if the user is added with "<name>"
    Examples:
      | name     | job    |
      | morpheus | leader |
      | tuyen    | member |
    @Delete
    Scenario Outline: delete successfully
      When user sent delete request with "<id>" then the user delete successfully
      Examples:
        | id |
        | 2 |


