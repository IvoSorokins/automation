package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class LogOutScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Profile\"]",uiAutomator="new UiSelector().textStartsWith(\"Profile\")")
    private MobileElement profileButton;

    @AndroidFindBy(id="account_log_out",xpath="//android.widget.TextView[@text=\"Log out\"]",uiAutomator ="new UiSelector().textStartsWith(\"Log out\")")
    private MobileElement logOutButton;

    private final AndroidDriver driver;

    public LogOutScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }
    public void LogOut() {
        profileButton.click();
        logOutButton.click();

    }
    //This Screen  was optional for AfterTest or AfterMethod (not finished)
}

