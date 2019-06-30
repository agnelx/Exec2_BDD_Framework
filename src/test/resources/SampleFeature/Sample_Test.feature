Feature: Automated Test of MyStore Add to cart 


Background: User navigates to Home page of Mystore 
	Given You are in Home page of Mystore with URL "http://automationpractice.com/index.php" 
	
@smoke 
Scenario: Customer place a order and add to cart 
	When Navigates to "Tshirt" Section 
	Then Click on to any item from list 
	And Click on to add to Cart 
	And Click proceed to checkout 
	Then Check do we have "1" item in Cart 
	And Close the browser