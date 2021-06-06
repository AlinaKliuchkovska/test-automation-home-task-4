package intertoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@id='basket_add_preview']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='intertop-basket-popup']")
    private WebElement cartPopup;

    @FindBy(xpath = "//span[contains(text(),'Артикул')]/following-sibling::span")
    private WebElement articleNumberProductPage;

    @FindBy(xpath = "//span[contains(@class,'now-price')]")
    private WebElement actualProductPrice;

    @FindBy(xpath = "//h2[contains(@class,'product-name')]")
    private WebElement productName;

    @FindBy(xpath = "//label[contains(@class,'jsShowPrice')]")
    private List<WebElement> sizeRadioButtonsList;

    @FindBy(xpath = "//div[@class='art']")
    private WebElement articleNumberCart;

    @FindBy(xpath = " //span[@class='basket-count hovered']")
    private WebElement countOfProductsInCart;

    public String getArticleNumberFromCart() {
        return articleNumberCart.getText();
    }

    public String getCountOfProductsInCart() {
        return countOfProductsInCart.getText();
    }

    public String  getArticleNumberFromProductPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(actualProductPrice).perform();
        return articleNumberProductPage.getText();
    }

    public boolean isAddToCartButtonEnabled() {
        return addToCartButton.isEnabled();
    }

    public ProductPage clickOnAddToCartButton() {
        addToCartButton.click();
        waitForVisibilityOfElement(cartPopup);
        return this;
    }

    public boolean isActualProductPriceDisplayed() {
        return actualProductPrice.isDisplayed();
    }

    public boolean isProductNameDisplayed() {
        return productName.isDisplayed();
    }

    public ProductPage chooseSize() {
        sizeRadioButtonsList.get(0).click();
        return this;
    }
}