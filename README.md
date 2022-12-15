# My Personal Project

My personal project will be an "online" banking system software. This will give the user the ability to
first create an account/multiple accounts and to access said accounts. While accessing the account, the 
user will have the option to deposit money, withdraw money and potentially gamble their life savings away :)
via an integrated mini-game of chance which is connected to their account balance (if I have enough time 
and is reasonably in scope for difficulty and time for CPSC 210). Not too sure of who will use this, but if 
I ever decide to open a bank, I could use this application as a starting basis. The reason of why I am 
choosing to make a banking application is mainly because I couldn't think of anything cooler to do and I am
running out of time to choose something for the project, but also because when I started coding, I tried to 
make the same thing, but failed miserably because I didn't understand basic coding concepts O_o.

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
Or if you would prefer, you can click on the button of animated Gunna, Young Thug, and Future pushing a blue 3D cube with
a 'P' on it.

- To save the state of the application to file, click the <b>Log out</b> button. This will save your data 

- To load the state of the application from file, click the <b>Load Accounts</b> button that is in the main menu

All JSON related code is from: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo <br>
GUI was made referencing: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Complete 

### Phase 4: Task 2
Event code is referenced from: https://github.students.cs.ubc.ca/CPSC210/AlarmSystem
Example EventLog (It prints the account creation again when I load my account list, 
I don't know why):

Thu Dec 01 15:40:15 PST 2022 <br>
Created account: Name: test1, Password: pass, Balance: 100.0 <br>
Thu Dec 01 15:40:15 PST 2022 <br>
Added Bank account test1 to Account list <br>
Thu Dec 01 15:40:19 PST 2022 <br>
Deposited $500.0 to test1's account <br>
Thu Dec 01 15:40:22 PST 2022 <br>
Withdrew: $200.0 from test1's account <br>
Thu Dec 01 15:40:32 PST 2022 <br>
Created account: Name: test2, Password: pass, Balance: 7000.0 <br>
Thu Dec 01 15:40:32 PST 2022 <br>
Added Bank account test2 to Account list <br>
Thu Dec 01 15:40:34 PST 2022 <br>
Created account: Name: test2, Password: pass, Balance: 7000.0 <br>
Thu Dec 01 15:40:34 PST 2022 <br>
Added Bank account test2 to Account list <br>
Thu Dec 01 15:40:39 PST 2022 <br>
Created account: Name: test2, Password: pass, Balance: 7000.0 <br>
Thu Dec 01 15:40:39 PST 2022 <br>
Added Bank account test2 to Account list <br>
Thu Dec 01 15:40:43 PST 2022 <br>
Cleared all accounts

### Phase 4: Task 3
I think I did alright on my UML diagram. I was unable to find any design where no lines would cross,
so I went with the design that had minimum amount of crosses. It is a little crammed, but It is the 
best I could do with all of my classes. 

If I had more time to work on this project, I think I would try and implement the ability to log back 
into an account that was already created and saved, so a user could create an account, log out and exit 
the application, re-open the application, then be able to log back into their previous made account and 
deposit or withdraw some money etc. Refactor-wise, I would like to not have a separate class for each option
the user can choose. I only did it because of how I made my UI design because I liked it opening a new 
window on a button press. If it was not for that, I would definitely try and condense a bit.
