package screens;

import dataobjects.User;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {

    @AndroidFindBy(id="onboard_login",xpath="//android.widget.Button[@text=\"LOG IN\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/onboard_login\")")
    private MobileElement LoginButton;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=0 and @password=\"false\"and @text=\"E-mail address\"]",uiAutomator = "new UiSelector().textStartsWith(\"E-mail address\")")
    private MobileElement EnterEmail;

    @AndroidFindBy(xpath="//android.widget.EditText[@index=0 and @password=\"true\" and @text=\"Password\"]",uiAutomator = "new UiSelector().textStartsWith(\"Password\")")
    private MobileElement EnterPassword;

    @AndroidFindBy(id ="login_sign_in",xpath="//android.widget.Button[@index=6]",uiAutomator="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/login_sign_in\")")
    private MobileElement nextButton_afterLogin;

    @AndroidFindBy(id="gender_skip",xpath="//android.widget.TextView[@index=8]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/gender_skip\")")
    private MobileElement skipButton;

    @AndroidFindBy(id = "pl.com.fourf.ecommerce:id/action_to_taxonomy",xpath="//android.widget.FrameLayout[@content-desc=\"Search\"]",uiAutomator ="pl.com.fourf.ecommerce:id/action_to_taxonomy" )
    private MobileElement clothingPageButton;

    private final AndroidDriver driver;
    public AddToCart(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);}

    public void LoggingIn(User user){
        LoginButton.click();
        EnterEmail.sendKeys(user.getEmail());
        EnterPassword.sendKeys(user.getPassword());
        nextButton_afterLogin.click();
        skipButton.click();
    }
    public void getToClothingPage(){
        clothingPageButton.click();

    }
}
//navigate to the login page
//Enter valid credentials (username and password) and log in to the app.
//load and locate the category I chose
//scroll down to the desired clothing category and tap on it.
//save the name and price of the item by extracting the text from the relevant UI elements, press "add to cart" button
//navigate to cart page ,validate that the item name and price match the values saved and  UI elements are relevant to the saved values.
//also use Id, ui and xpath Selectors and structure packages in Tasks