package screens.Part1;

import dataobjects.User;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class SignUpScreen {


    @AndroidFindBy(id = "onboard_sign_up", xpath ="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/onboard_sign_up\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/onboard_sign_up\")" )
    private MobileElement start_SignUpButton;

    @AndroidFindBy(id = "registration_regulations_check", xpath ="//android.widget.CheckBox[@resource-id=\"pl.com.fourf.ecommerce:id/registration_regulations_check\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_regulations_check\")" )
    private MobileElement Terms;
    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText",uiAutomator ="new UiSelector().textStartsWith(\"E-mail\")" )
    private static MobileElement Email;

    @AndroidFindBy(id="registration_sign_up",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/registration_sign_up\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_sign_up\")")
    private MobileElement createAccountButton;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText",uiAutomator ="new UiSelector().textStartsWith(\"Password\")" )
    private static MobileElement Password;

    @AndroidFindBy (id="confirm_title",xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.TextView[2]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/confirm_title\")")
    private MobileElement validate_NextScreen_is_Registration;

    @AndroidFindBy(xpath="//*[contains(@text, 'ronow30323@fsouda.com')]",uiAutomator ="new UiSelector().textContains(\"debig24019@mustbeit.com\")")//Manually enter email you want to check
    private MobileElement validateEmail;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.Button",uiAutomator ="new UiSelector().textStartsWith(\"CONTINUE\")")
    private MobileElement continueButton;


    private final AndroidDriver driver;
    public SignUpScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void enterCredentials(User user) {
        Email.sendKeys(user.getEmail());
        Password.sendKeys(user.getPassword());
    }
    public void AcceptTerms(){Terms.click();}



    public void validate_NextScreen(){
        WebElement confirmRegistrationText = validate_NextScreen_is_Registration;
        confirmRegistrationText.isDisplayed();
    }
    public void validate_Email_Adrress(){
        WebElement emailAddress = validateEmail;
        Assert.assertTrue(emailAddress.isDisplayed());
    }

    public void createAccount(){createAccountButton.click();}

    public void continueButton(){continueButton.click();}


    public void start_clickSignUp() {start_SignUpButton.click();}
}
