package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NotificationScreen{

    @AndroidFindBy(id="notification_next",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/notification_next\"]",uiAutomator="new UiSelector().text(\"NEXT\")")
    private MobileElement nextButton;
    private final AndroidDriver driver;
    public NotificationScreen(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);}

    public void clickNext(){nextButton.click();}
}
