package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {

    @AndroidFindBy(id="dashboard_graphic_tile_item_title",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/dashboard_graphic_tile_item_title\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/dashboard_graphic_tile_item_title\")")
    private MobileElement dashboard_skip;

    @AndroidFindBy(id="action_to_taxonomy",xpath="//android.widget.FrameLayout[@resource-id=\"pl.com.fourf.ecommerce:id/action_to_taxonomy\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/action_to_taxonomy\")")
    private MobileElement categorysButton;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"SHOES\"))", xpath = "//android.widget.TextView[@text=\"SHOES\"]")
    private MobileElement scrollsDownToShoes;

    @AndroidFindBy(xpath="//android.widget.TextView[@text=\"Show all\"]",uiAutomator = "new UiSelector().text(\"Show all\").resourceId(\"pl.com.fourf.ecommerce:id/taxonomy_subcategory_item_name\")")
    private MobileElement ShowAllButton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[2]")
    private MobileElement firstItem;

    @AndroidFindBy(id="product_header_item_name",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_name\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_name\")")
    private MobileElement itemName;

    @AndroidFindBy(id="product_header_item_current_price",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_current_price\"]",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_current_price\")")
    private MobileElement itemPrice;

    @AndroidFindBy(id="product_header_item_buy",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/product_header_item_buy\"])",uiAutomator = "new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_header_item_buy\")")
    private MobileElement addToCartButton;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@index=0 and @clickable=\"true\"]")
    private MobileElement chooseSize;

    @AndroidFindBy(id="product_add_to_cart_confirm_cart",xpath="//android.widget.Button[@resource-id=\"pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_cart\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/product_add_to_cart_confirm_cart\")")
    private MobileElement checkYourCartButton;

    @AndroidFindBy(id="cart_product_item_title",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/cart_product_item_title\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/cart_product_item_title\")")
    private MobileElement productNameCart;

    @AndroidFindBy(id="cart_product_item_current_price",xpath="//android.widget.TextView[@resource-id=\"pl.com.fourf.ecommerce:id/cart_product_item_current_price\"]",uiAutomator ="new UiSelector().resourceId(\"pl.com.fourf.ecommerce:id/cart_product_item_current_price\")")
    private MobileElement productPriceCart;




    private final AndroidDriver driver;
    public AddToCart(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void clickDashboard(){dashboard_skip.click();}

    public void clickCategory(){categorysButton.click();}

    public void chooseCategory(){scrollsDownToShoes.click();}

    public void clickShowAll(){ShowAllButton.click();}

    public void clickFirstItem(){firstItem.click();}

    public String getName(){
        return itemName.getText();
    }
    public String getPrice(){
       return itemPrice.getText();
    }
    public void AddtoCart(){addToCartButton.click();}

    public void ChooseSize(){chooseSize.click();}

    public void CheckCart(){checkYourCartButton.click();}

    public String cartName(){
        return productNameCart.getText();
    }
    public String cartPrice(){
        return productPriceCart.getText();
    }

}
