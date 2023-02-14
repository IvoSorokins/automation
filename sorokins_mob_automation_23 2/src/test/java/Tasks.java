import dataobjects.User;
import dataobjects.tempUser;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import screens.*;
import utils.TestProperties;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;




public class Tasks {
    private AndroidDriver driver;
    public SignUpScreen signUpScreen;

    public ConfirmRegistration confirmRegistration;

    public AddToCart addToCart;

    public LogOutAfterSignUp logOutAfterSignUp;

    public InvalidCredentialsScreen invalidCredentialsScreen;

    public NotificationScreen notificationScreen;

    public String tempEmail= tempUser.unTempEmail; //For creating manual account

    public String tempPassword=tempUser.unTempPassword;//For creating manual account









    @BeforeMethod(description="Starts each session",groups=("StartUp"),alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = TestProperties.setDesiredCapabilities();
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");


        URL remoteUrl = new URL(TestProperties.getProperty("appiumURL"));

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        signUpScreen = new SignUpScreen(driver);
        confirmRegistration = new ConfirmRegistration(driver);
        addToCart = new AddToCart(driver);
        logOutAfterSignUp = new LogOutAfterSignUp(driver);
        invalidCredentialsScreen = new InvalidCredentialsScreen(driver);
        notificationScreen = new NotificationScreen(driver);
        driver.resetApp();
    }

    @BeforeTest
    public void Notification(){
        notificationScreen.clickNext();//skips notification page which pops up everytime app is reseted
    }
    @Test(description ="Part 1 Sign Up", groups = {"TC1"},enabled=true, priority = 0)
    public void SignUp() {
        signUpScreen.start_clickSignUp();
        signUpScreen.AcceptTerms();
        signUpScreen.enterCredentials();
        signUpScreen.createAccount();
        signUpScreen.validate_NextScreen();
        Reporter.log("Screen Validated!");
        signUpScreen.validate_Email_Adrress();
        Reporter.log("Email Registered and Validated!");
        signUpScreen.continueButton();
        Reporter.log("Succesfully signed up new User!");
    }
    @Test(description ="Part 2",groups = {"TC2"},priority=1,enabled =true)
    public void ConfirmRegistration(){
        confirmRegistration.clickLoginButton();
        confirmRegistration.loginEnterCredentials();
//        confirmRegistration.skipConsent(); When first time logged into fresh account
        confirmRegistration.skipButton();
        confirmRegistration.goToMyAccount();
        confirmRegistration.validateProfileEmail();
    }

    @Test(description="Part 3",groups={"TC3"},priority=2,enabled=true, dataProvider = "user-data", dataProviderClass = UserData.class)
    public void InvalidCredentials(User user){
        logOutAfterSignUp.clickmyAccountButton();
        logOutAfterSignUp.clickLogOut();
        invalidCredentialsScreen.getToSignIn();
        invalidCredentialsScreen.fillEmail(user.getEmail());
        invalidCredentialsScreen.fillPassword(user.getPassword());
        invalidCredentialsScreen.clickNextButton();
        String errorMessage = invalidCredentialsScreen.getErrorMessage();
        assert errorMessage.equals(user.getErrorMessage());
        Reporter.log("Error message :"+errorMessage+"\nExpected Error Message: "+user.getErrorMessage());
        }
    @Test(description = "Part 4",groups = {"TC4"},enabled=true, priority=3)
    public void AddItemToCart(){
        confirmRegistration.clickLoginButton();
        confirmRegistration.loginEnterCredentials();
        confirmRegistration.skipConsent();
        confirmRegistration.skipButton();
        addToCart.clickDashboard();
        addToCart.clickCategory();
        addToCart.chooseCategory();
        addToCart.clickShowAll();
        addToCart.clickFirstItem();
        String itemName = addToCart.getName();
        String itemPrice = addToCart.getPrice();
        addToCart.AddtoCart();
        addToCart.ChooseSize();
        addToCart.CheckCart();
        String cartName = addToCart.cartName();
        String cartPrice =addToCart.cartPrice();
        Assert.assertEquals(cartName, itemName, "Cart Name does not match category item!");
        Assert.assertEquals(cartPrice, itemPrice, "Cart Price does not match category price for item!");
    }
    @AfterMethod(description="Runs after each test",groups=("CleanUp"),alwaysRun = true)
    public void lastCleanUp() {
        driver.quit();}


}


