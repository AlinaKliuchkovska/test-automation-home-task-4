package intertoppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSneakersPage extends BasePage {
    public SearchSneakersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> searchResultProductsList;

    @FindBy(xpath = "//div[@class='product-name']")
    private List<WebElement> productsNameList;

    @FindBy(xpath = "//span[@class='likes']")
    private List<WebElement> likeButtonsList;

    @FindBy(xpath = "//div[@id='ModalFavouriteSizeContent']")
    private WebElement chooseFavouriteSizePopup;

    @FindBy(xpath = "//label[@class='jsShowPrice btn']")
    private List<WebElement> chooseFavouriteSizeList;

    @FindBy(xpath = "//button[contains(@class,'by-this-item')]")
    private WebElement addProductToWishlistButton;

    public List<WebElement> getProductsNameList() {
        return productsNameList;
    }

    public String getProductsNameText(WebElement item) {
        return item.getText();
    }

    public SearchSneakersPage clickOnProduct(){
        waitForVisibilityOfElement(searchResultProductsList.get(0));
        searchResultProductsList.get(0).click();
        return this;
    }

    public SearchSneakersPage clickOnLikeButton(){
        likeButtonsList.get(0).click();
        waitForVisibilityOfElement(chooseFavouriteSizePopup);
        return this;
    }

    public SearchSneakersPage chooseFavouriteSize(){
        chooseFavouriteSizeList.get(0).click();
        return this;
    }

    public SearchSneakersPage clickOnAddProductToWishlistButton(){
        addProductToWishlistButton.click();
        return this;
    }
}