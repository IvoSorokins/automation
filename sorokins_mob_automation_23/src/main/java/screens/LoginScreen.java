package screens;

import dataobjects.User;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen {
    @AndroidFindBy(id="onboard_login",xpath="//android.widget.Button[@text=\"LOG IN\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/onboard_login\")")
    private MobileElement LoginButton;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=0 and @password=\"false\"and @text=\"E-mail address\"]",uiAutomator = "new UiSelector().textStartsWith(\"E-mail address\")")
    private MobileElement EnterEmail;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=0 and @password=\"true\" and @text=\"Password\"]",uiAutomator = "new UiSelector().textStartsWith(\"Password\")")
    private MobileElement EnterPassword;


    @AndroidFindBy(id="login_sign_in",xpath = "//android.widget.Button[@text=\"NEXT\"]",uiAutomator = "new UiSelector().textStartsWith(\"NEXT\")")
    private MobileElement confirmButton;

    @AndroidFindBy(id="gender_skip",xpath="//android.widget.TextView[@index=8]",uiAutomator ="new UiSelector().textStartsWith(\"Skip\")" )
    private MobileElement skipButton;

    @AndroidFindBy(id="action_to_dashboard",xpath ="//android.widget.FrameLayout[@content-desc=\"Dashboard\"]",uiAutomator ="new UiSelector().description(\"Dashboard\")")
    private MobileElement homescreenButton;

    @AndroidFindBy(id="action_to_account", xpath="//android.widget.FrameLayout[@content-desc=\"My account\"]",uiAutomator ="new UiSelector().description(\"My account\")")
    private MobileElement myAccountButton;

    private final AndroidDriver driver;
    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void clickLogin(){LoginButton.click();}
    public void enterCredentials(User user) {
        EnterEmail.sendKeys(user.getEmail());
        EnterPassword.sendKeys(user.getPassword());}

    public void confirmButton(){
        confirmButton.click();
        skipButton.click();}
    public void getHomeScreen(){homescreenButton.click();}

    public void getMyAccountScreen(){myAccountButton.click();}
    }
    //Got problems with account disabled account so I couldn't login and finish this also
    //Probobly shouldn't have used temporary email generator
