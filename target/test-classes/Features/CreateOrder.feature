Feature: Create order 


  Scenario: User is able to place order
  User is logged in and clicks on create service order
 		Given user is on login page
    When user enters username and password
    And clicks on login button
    And user click on new order
    And click on services
    When user selects the hospital "Example"
    And user selects the service "Communal"
    And user selects the pickup option "Vet Pickup"
    And user selects the delivery option
    And user selects the pickup date
    And user selects the delivery date
    And user enters the family information
    And user selects the contact preferences
    And user enters the contact preferences
    And family enters the pet information
    And user clicks the next step button
    And the user clicks on the step three button
    And the user clicks the submit button
    And the user clicks view order
    Then the user will navigate to the order
    
    