# My Personal Project

My personal project will be an "online" banking system software. This will give the user the ability to
first create an account/multiple accounts and to access said accounts. While accessing the account, the 
user will have the option to deposit money, withdraw money and potentially gamble their life savings away :)
via an integrated mini-game of chance which is connected to their account balance (if I have enough time 
and is reasonably in scope for difficulty and time for CPSC 210). Not too sure of who will use this, but if 
I ever decide to open a bank, I could use this application as a starting basis. The reason of why I am 
choosing to make a banking application is mainly because I couldn't think of anything cooler to do and I am
running out of time to choose something for the project, but also because when I started coding, I tried to 
make the same thing, but failed miserably because I didn't understand basic coding concepts O_o. In also want to
try and implement some real-life algorithms myself (such as ***Luhns Algorithm***)

## Possible additions:
- Credit score system based off of income and timely payments
- Ability to open up credit accounts => Would implement Luhns Algorithm as validity checker
- Ability to open up mortgage based on credit score
- Move money between accounts
- Mini stock market. Stock prices would go up or down based on randomness (I feel like this might be too ambitious)
 

## User Stories
As a user, I want to be able to be able to create multiple bank accounts

As an admin, I want to be able to view all created accounts

As a user, I want to be able to have my account be password/pin protected

As a user, I want to be able to deposit and withdraw money from my account

As a user, I want to be able to close/delete a bank account

As a user, I want to be able to save my account

As a user, I want to be able to load my account

## Instructions for Grader
- To generate a Bank Account (X) click on the <b>Create Account</b> button in the main menu. This will add a new Bank 
Account (X) to an Account List (Y) accessible via an admin password.

- To generate the second required event, click any of the buttons given after you created you account. For example, you 
can deposit money, withdraw money, delete your account etc.

- When you run the application, you will see a giant picture of Lebron James as the background. This is my visual component.
or if you would prefer, you can click on the button of animated Gunna, Young Thug, and Future pushing a blue 3D cube with
a 'P' on it.

- To save the state of the application to file, click the <b>Log out</b> button. This will save your data 

- To load the state of the application from file, click the <b>Load Accounts</b> button that is in the main menu

All JSON related code is from: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo <br>
GUI was made referencing: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete 