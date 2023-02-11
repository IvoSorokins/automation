package screens;


import dataobjects.User;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ConfirmRegistration {



    @AndroidFindBy(id="action_to_account",xpath="//android.widget.Button[@index=2]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_account\")")
    private MobileElement myAccount;
    @AndroidFindBy(id = "onboard_login", xpath="//android.widget.Button[@index=2]",uiAutomator = "new UiSelector().textStartsWith(\"LOG IN\")")
    private MobileElement LogInButton;

    @AndroidFindBy(id="account_guest_sign_in",xpath="//android.widget.Button[@index=3]",uiAutomator ="new UiSelector().textStartsWith(\"LOG IN\")")
    private MobileElement LogInButton_Confirmation;
    @AndroidFindBy(xpath="//android.widget.EditText[@index=0 and @password=\"false\"and @text=\"E-mail address\"]",uiAutomator = "new UiSelector().textStartsWith(\"E-mail address\")")
    private MobileElement EnterEmail;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=0 and @password=\"true\" and @text=\"Password\"]",uiAutomator = "new UiSelector().textStartsWith(\"Password\")")
    private MobileElement EnterPassword;

    @AndroidFindBy(id="login_sign_in",xpath = "//android.widget.Button[@text=\"NEXT\"]",uiAutomator = "new UiSelector().textStartsWith(\"NEXT\")")
    private MobileElement nextButton;

    @AndroidFindBy(xpath="//android.widget.Button[@index=7]",uiAutomator="new UiSelector().textStartsWith(\"NEXT\")")
    private MobileElement nextButton_afterLogin;

    @AndroidFindBy(id="gender_skip",xpath="//android.widget.TextView[@index=8]",uiAutomator ="new UiSelector().textStartsWith(\"Skip\")" )
    private MobileElement skipButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]",uiAutomator="new UiSelector().textStartsWith(\"Profile\")")
    private MobileElement profileButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@index=3]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/profile_toolbar_title\")" )
    private MobileElement profileEmail;




    private final AndroidDriver driver;
    public ConfirmRegistration(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);}

    public void clickLogInButton_Confirmation(){LogInButton_Confirmation.click();}

    public void enterCredentials_Confirmation(User user) {
        EnterEmail.sendKeys(user.getEmail());
        EnterPassword.sendKeys(user.getPassword());}
    public void clickNext(){
        nextButton.click();
    }
    public void clickNextAfter(){
        nextButton_afterLogin.click();
        skipButton.click();
    }
    public void accountCheck(){
        myAccount.click();
        profileButton.click();
    }
    
//This Screen Checked if Registered User Accualy was saved , but it's (not finished)


}

