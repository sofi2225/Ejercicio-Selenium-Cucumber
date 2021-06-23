Feature: Ejercicio con Cucumber

Scenario: Click All Tabs

Given Initalize driver in Chrome and login with username "sofi@tdc.com" and password "SSALES1234" 

When User is on Service Page

Then Click on all tabs if button new present click and the cancel 



#@Skip
Scenario: Create Accounts 

Given Initalize driver in Chrome and login with username "sofi@tdc.com" and password "SSALES1234" 

When User is on Account Page

Then Create "2" complete accounts and "1" account with empty name field 
And Create account with previous account name 




Scenario: Edit Accounts 

Given Initalize driver in Chrome and login with username "sofi@tdc.com" and password "SSALES1234" 

When User is on Account Page

Then Modify <Rating>, <Upsell_Opportunity> and <Type> on crated last account 

Examples:
|Rating					|Upsell_Opportunity	|Type				|
|Warm						|Yes							  |Prospect		|





Scenario: Employee Number

Given Initalize driver in Chrome and login with username "sofi@tdc.com" and password "SSALES1234" 
And User is on Account Page

When User populate employee number with "1431655766"

Then Verify error message "Empleados: valor fuera del rango válido en campo numérico: 1431655766"



 