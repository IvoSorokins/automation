# Framework Requirements
	● Use Page Object Model (POM)
		○ for each element provide XPath and UiSelector strategies. If the element has an ID, then use the ID, but still provide XPath and UiSelector.
		○ Use @AndroidFindBy annotation, put all strategies and values on a single line
		○ Element selectors should be chosen with good practices in mind
	● Have a config.properties file. Add all your static properties(options) here.
	● Have a testng.xml file with examples of:
		○ running all tests from a class
		○ running one specific test
		○ ignoring two specific tests
		○ running all tests with a group
		In order to have all these different test execution settings, for each create a separate
		.xml file - all-class-tests.xml, one-test.xml, ignore-two.xml, group-tests.xml
	● Enable the default TestNG report
		○ log some information to the report. Anything that you think is useful to have. If
		nothing comes to mind, then log comments.
	● Structure your project with packages, understandable class, method, variable, etc.
	names.
		○ It's okay to combine some screens into one class. For example,
		RegistractionScreens.java. This could cover all screens that are for the
		registrations. But if you see that class gets too big and complex, better to split.
	● Test class
		○ Use @BeforeTest, @BeforeMethod, @AfterMethod, @AfterTest annotations
		○ tests are well written and structured, easy to understand

#	Tests to automate
	1. Register a new user: Fill out the Create account form, submit the form, validate the next
	screen is Confirm Registration, and the email address you used is the same here.
	2. Registered users can Log in, and log out: You need to create an account manually. Then
	use the credentials to automate the login, get to HomeScreen (main of the application),
	go to the My Account -> Profile, and validate that e-mail you is the same as the one at
	the top of the Profile screen.
	3. Users can't Log in with Invalid credentials: The app displays a proper error message
	based on input data. Fields are also checked for improper input data format. Use invalid
	credentials to log in and validate the error messages.
	a. Use @DataProvider
	4. Logged-in user on the Home Screen scrolls down to any clothing category (pick one),
	taps on it, taps on the first item on the screen, save the name and the price of the item,
	and tap ADD TO CART. Go to the Cart and validate that the item name and price
	matches to one saved before.
	a. Note: Validate the name and the price. If the name of the opened item is too long
	and you see '…' use 'contains' in XPath (appropriate in UiSelector) to check for a
	substring in the item name in the Cart screen.
	b. Note: When rerunning the test, make sure that the Cart is empty. So, clear the
	Cart manually, or reset the app.
