package screens;


import dataobjects.tempUser;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class SignUpScreen {
    public String tempEmail= tempUser.unTempEmail; //For creating manual account

    public String tempPassword=tempUser.unTempPassword;//For creating manual account


    @AndroidFindBy(id = "onboard_sign_up", xpath ="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/onboard_sign_up\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/onboard_sign_up\")" )
    private MobileElement start_SignUpButton;

    @AndroidFindBy(id = "registration_regulations_check", xpath ="//android.widget.CheckBox[@resource-id=\"pl.com.fourf.ecommerce:id/registration_regulations_check\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_regulations_check\")" )
    private MobileElement Terms;
    @AndroidFindBy(xpath="//android.widget.EditText[@text=\"E-mail address\"]",uiAutomator ="new UiSelector().textStartsWith(\"E-mail\")" )
    private static MobileElement Email;

    @AndroidFindBy(id="registration_sign_up",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/registration_sign_up\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/registration_sign_up\")")
    private MobileElement createAccountButton;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Password\"]",uiAutomator ="new UiSelector().textStartsWith(\"Password\")" )
    private static MobileElement Password;

    @AndroidFindBy (id="confirm_title",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/confirm_title\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/confirm_title\")")
    private MobileElement validate_NextScreen_is_Registration;

    @AndroidFindBy(xpath="//android.widget.Button[@text=\"CONTINUE\"]",uiAutomator ="new UiSelector().textStartsWith(\"CONTINUE\")")
    private MobileElement continueButton;

    @AndroidFindBy(id="confirm_description",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/confirm_description\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/confirm_description\")")//Manually enter email you want to check
    private MobileElement validateEmail;






    private final AndroidDriver driver;
    public SignUpScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void enterCredentials() {
        Email.sendKeys(tempEmail);
        Password.sendKeys(tempPassword);
    }
    public void AcceptTerms(){Terms.click();}



    public void validate_NextScreen(){
        WebElement confirmRegistrationText = validate_NextScreen_is_Registration;
        confirmRegistrationText.isDisplayed();
    }
    public void validate_Email_Adrress(){
        String emailAddress = validateEmail.getText();
        Assert.assertEquals("click the link sent to your e-mail address: " + tempEmail,emailAddress);
    }

    public void createAccount(){createAccountButton.click();}

    public void continueButton(){continueButton.click();}


    public void start_clickSignUp() {start_SignUpButton.click();}
}
