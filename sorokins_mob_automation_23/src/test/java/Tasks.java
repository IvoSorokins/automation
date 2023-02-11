import dataobjects.User;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.*;
import screens.LogOutScreen;
import screens.LoginScreen;
import screens.ConfirmRegistration;
import screens.Part1.SignUpScreen;
import utils.TestProperties;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;




public class Tasks {
    private AndroidDriver driver;
    public SignUpScreen signUpScreen;
    public ConfirmRegistration confirmRegistration;

    public LoginScreen loginScreen;

    public LogOutScreen logOutScreen;




    @BeforeMethod(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = TestProperties.setDesiredCapabilities();
        desiredCapabilities.setCapability("appium:udid", "emulator-5554");


        URL remoteUrl = new URL(TestProperties.getProperty("appiumURL"));

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        signUpScreen = new SignUpScreen(driver);
        confirmRegistration = new ConfirmRegistration(driver);
        loginScreen = new LoginScreen(driver);
        logOutScreen = new LogOutScreen(driver);
    }
    @Test(description ="Part 1 Sign Up", groups = {"TC1"},enabled=true, priority = 0)
    public void SignUp(User user) {
        signUpScreen.start_clickSignUp();
        signUpScreen.AcceptTerms();
        signUpScreen.enterCredentials(new User("ronow30323@fsouda.com","Ronow30323?"));//Manually Enter Credentials
        // https://temp-mail.org/en/
        signUpScreen.createAccount();
        signUpScreen.validate_NextScreen();
        Reporter.log("Screen Validated!");
        signUpScreen.validate_Email_Adrress();
        Reporter.log("Email Registered and Validated!");
        signUpScreen.continueButton();

        Reporter.log("Succesfully signed up new User!");

    }

    @Test(description ="Part 2",groups = {"TC2"},priority=1,enabled =false,dataProvider="invalid-user-data",dataProviderClass = UserData.class )
    public void ConfirmRegistration(User user){
        loginScreen.clickLogin();
        loginScreen.enterCredentials(new User("",""));
        loginScreen.confirmButton();
    }

//@Test(description = "Part 3",groups = {"TC3"},enabled=false, priority=2,)
    @AfterMethod
    public void cleanUp() {driver.quit();}
}


