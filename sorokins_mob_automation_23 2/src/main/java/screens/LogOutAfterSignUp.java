package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LogOutAfterSignUp {


    @AndroidFindBy(id="action_to_account",xpath="//android.widget.FrameLayout[@content-desc=\"My account\"]",uiAutomator="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_account\")")
    private MobileElement myAccountButton;

    @AndroidFindBy(id="account_log_out",xpath="//android.widget.TextView[@text=\"Log out\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/account_log_out\")")
    private MobileElement logOut;

    private final AndroidDriver driver;
    public LogOutAfterSignUp(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);}


    public void clickmyAccountButton(){myAccountButton.click();}

    public void clickLogOut(){logOut.click();}
}
