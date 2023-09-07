@tag
  Feature: purchase the order from ecoomerce website
     Background:
       Given I landed on ecommerce page
     @Regression
     Scenario Outline:Positive test for submitting the order
       Given Log in with username <name> and password <password>
       When i add product <productname> to cart
       And checkout <productname> and submit the order
       Then "THANKYOU FOR THE ORDER." message is displayed on conformation page
       Examples:
         | name              | password | productname|
         | anala@example.com | Anala@123| ZARA COAT 3|