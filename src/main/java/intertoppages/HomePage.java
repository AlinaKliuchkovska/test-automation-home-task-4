package intertoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='v_search_input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@class='btn-search']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[contains(@href,'/wishlist')]")
    private WebElement wishlistButton;

    public HomePage enterKeyWordToSearchInput(String keyWord){
        searchInput.sendKeys(keyWord);
        return this;
    }

    public HomePage clickOnSearchButton(){
        searchButton.click();
        return this;
    }

    public HomePage clickOnWishlistButton(){
        wishlistButton.click();
        return this;
    }
}