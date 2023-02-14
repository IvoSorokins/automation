package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class InvalidCredentialsScreen {

    @AndroidFindBy(id="onboard_login",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/onboard_login\"]",uiAutomator="new UiSelector().textStartsWith(\"LOG IN\")")
    private MobileElement loginButton;

    @AndroidFindBy(id="login_sign_in",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/login_sign_in\"]",uiAutomator="new UiSelector().textStartsWith(\"NEXT\")")
    private MobileElement nextButton;

    @AndroidFindBy(xpath="//android.widget.EditText[@password=\"false\"]")//Can't locate with uiSelector
    private MobileElement enterEmail;

    @AndroidFindBy(xpath="//android.widget.EditText[@password=\"true\" and @text=\"Password\"]",uiAutomator="new UiSelector().text(\"Password\")")
    private MobileElement enterPassword;

    @AndroidFindBy(id="login_error",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/login_error\"]",uiAutomator="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/login_error\")")
    private MobileElement errorWidget;

    private final AndroidDriver driver;
    public InvalidCredentialsScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);}

    public void getToSignIn(){loginButton.click();}

    public void clickNextButton(){nextButton.click();}

    public void fillEmail(String email){
        enterEmail.sendKeys(email);}
    public void fillPassword(String password){
        enterPassword.sendKeys(password);}

    public String getErrorMessage(){
        String ErrorMessage =errorWidget.getText();
        return ErrorMessage;}

}



//DataProvider was settup all I had to do is navigate to the login page, enter credentials using @DataProvider, tap Log In" button
//store error message to compare with results and display error, @DataProvider will repeate same steps for me
//Also use Id, ui and xpath Selectors and structure packages in Tasks