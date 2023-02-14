package screens;


import dataobjects.User;
import dataobjects.tempUser;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ConfirmRegistration {

    public String tempEmail= tempUser.TempEmail; //For creating manual account

    public String tempPassword=tempUser.TempPassword;//For creating manual account


    @AndroidFindBy(id="onboard_login",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/onboard_login\"]",uiAutomator="new UiSelector().textStartsWith(\"LOG IN\")")
    private MobileElement loginButton;

    @AndroidFindBy(xpath="//android.widget.EditText[@password=\"false\"]")//Can't locate with uiSelector
    private MobileElement enterEmail;

    @AndroidFindBy(xpath="//android.widget.EditText[@password=\"true\" and @text=\"Password\"]",uiAutomator="new UiSelector().text(\"Password\")")
    private MobileElement enterPassword;

    @AndroidFindBy(id="login_sign_in",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/login_sign_in\"]",uiAutomator="new UiSelector().text(\"NEXT\")")
    private MobileElement nextButton;

    @AndroidFindBy(id="login_sign_in",xpath="//android.widget.Button[@text=\"NEXT\"]",uiAutomator ="new UiSelector().text(\"NEXT\")")
    private MobileElement consentButton;

    @AndroidFindBy(id="gender_skip",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/gender_skip\"]",uiAutomator="new UiSelector().text(\"Skip\")")
    private MobileElement skipButton;

    @AndroidFindBy(id="action_to_account",xpath="//android.widget.FrameLayout[@content-desc=\"My account\"]",uiAutomator="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_account\")")
    private MobileElement myAccountButton;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Profile\"]",uiAutomator="new UiSelector().text(\"Profile\")")
    private MobileElement profileButton;

    @AndroidFindBy(id="profile_toolbar_title",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/profile_toolbar_title\"]",uiAutomator="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/profile_toolbar_title\")")
    private MobileElement profileEmail;



    private final AndroidDriver driver;

    public ConfirmRegistration(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void clickLoginButton(){
        loginButton.click();
    }
    public void loginEnterCredentials(){
        enterEmail.sendKeys(tempEmail);
        enterPassword.sendKeys(tempPassword);
        nextButton.click();
    }
    public void skipConsent(){
        consentButton.click();
    }
    public void skipButton(){
        skipButton.click();
    }
    public void goToMyAccount(){
        myAccountButton.click();
        profileButton.click();
    }

    public void validateProfileEmail(){
        String actualEmail = profileEmail.getText();
        Assert.assertEquals(tempEmail,actualEmail);
    }

}

